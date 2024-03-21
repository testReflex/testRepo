/*
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.validation

import org.eclipse.xtext.validation.Check
import ru.iaie.reflex.reflex.ReflexPackage
import ru.iaie.reflex.reflex.SetStateStat
import ru.iaie.reflex.reflex.Process

import static extension ru.iaie.reflex.utils.ReflexModelUtil.*
import static extension ru.iaie.reflex.utils.ExpressionUtil.*
import static extension ru.iaie.reflex.typing.TypeUtils.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import ru.iaie.reflex.reflex.ErrorStat
import ru.iaie.reflex.reflex.StopProcStat
import ru.iaie.reflex.reflex.StartProcStat
import ru.iaie.reflex.reflex.AssignmentExpression
import ru.iaie.reflex.reflex.PhysicalVariable
import ru.iaie.reflex.reflex.Program
import ru.iaie.reflex.reflex.TimeoutFunction
import ru.iaie.reflex.reflex.ProgramVariable
import ru.iaie.reflex.reflex.Const
import ru.iaie.reflex.reflex.EnumMember
import org.eclipse.emf.ecore.EObject
import java.util.Map
import ru.iaie.reflex.reflex.GlobalVariable
import ru.iaie.reflex.reflex.ImportedVariableList
import static java.util.function.Function.identity;
import ru.iaie.reflex.reflex.CompoundStatement
import ru.iaie.reflex.reflex.IfElseStat
import ru.iaie.reflex.reflex.Statement
import ru.iaie.reflex.reflex.SwitchStat
import ru.iaie.reflex.reflex.ProcessVariable
import ru.iaie.reflex.reflex.PortType
import ru.iaie.reflex.reflex.Port
import ru.iaie.reflex.utils.LiteralUtils
import ru.iaie.reflex.reflex.Expression
import ru.iaie.reflex.typing.TypeWarning
import java.util.List
import ru.iaie.reflex.reflex.Type

/** 
 * This class contains custom validation rules. 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class ReflexValidator extends AbstractReflexValidator {

	static ReflexPackage ePackage = ReflexPackage.eINSTANCE

	@Check def void checkForNextState(SetStateStat setStateStat) {
		if (setStateStat.isNext()) {
			val state = setStateStat.getContainerOfType(ru.iaie.reflex.reflex.State)
			val process = setStateStat.getContainerOfType(Process)
			if (state.index + 1 >= process.states.length) {
				error("Invalid state transition: no next state in the process", ePackage.setStateStat_Next)
			}
		}
	}

	@Check def void checkStateTransitions(ru.iaie.reflex.reflex.State state) {
		if(state.isLooped) return;
		val stateTransitions = state.eAllContents.filter(SetStateStat)
		if (stateTransitions.isEmpty) {
			val selfStopTransitions = state.eAllContents.filter(StopProcStat).filter[selfStop]
			if (selfStopTransitions.isEmpty) {
				val selfErrorTransitions = state.eAllContents.filter(ErrorStat).filter[selfError]
				if (selfErrorTransitions.isEmpty) {
					error('''Potential cycle in state «state.name»: no state transitions declared''',
						ePackage.state_Name)
				}
			}
		}
	}

	@Check def void checkStartStatement(StartProcStat startStat) {
		val selfProcess = startStat.getContainerOfType(Process)
		val procName = startStat.process.name;
		if (selfProcess.name.equals(procName)) {
			warning('''Use 'restart' statement for restarting current process''', ePackage.startProcStat_Process)
		}
	}

	@Check def void checkStopStatement(StopProcStat stopStat) {
		val selfProcess = stopStat.getContainerOfType(Process)
		val procName = stopStat.process.name;
		if (selfProcess.name.equals(procName)) {
			warning('''Use 'stop' without argument to stop current process''', ePackage.stopProcStat_Process)
		}
	}

	@Check def void checkErrorStatement(ErrorStat errorStat) {
		val selfProcess = errorStat.getContainerOfType(Process)
		val procName = errorStat.process.name;
		if (selfProcess.name.equals(procName)) {
			warning("Use 'error' without argument to set current process state to error", ePackage.errorStat_Process)
		}
	}

	@Check def void checkAssignVariable(AssignmentExpression expr) {
		if (expr.hasAssignment) {
			val assignVar = expr.assignVar
			if (assignVar instanceof PhysicalVariable) {
				if (assignVar.mappedPortType == PortType.INPUT) {
					warning("An attempt to assign value into variable mapped on input port",
						ePackage.assignmentExpression_AssignVar);
				}
			}
			if (assignVar instanceof Const || assignVar instanceof EnumMember) {
				error("Can't assign values to constants or enum members", ePackage.assignmentExpression_AssignVar)
			}
		}
	}

	@Check def void checkOutputVarUsagesInAssignment(PhysicalVariable physVar) {
		if (physVar.mappedPortType == PortType.OUTPUT) {
			val program = physVar.getContainerOfType(Program)
			var usedInAssignment = program.containsReferencesOfType(physVar, ePackage.assignmentExpression_AssignVar)

			if (!usedInAssignment) {
				warning("Variable mapped on output port is not used in assignment", ePackage.physicalVariable_Name)
			}
		}
	}

	@Check def void checkStateReachability(ru.iaie.reflex.reflex.State state) {
		val process = state.getContainerOfType(Process)
		var curStateIndex = state.index
		if(curStateIndex == 0) return
		var transitionExists = process.containsReferencesOfType(state, ePackage.setStateStat_State)
		if (!transitionExists) {
			// Try check in previous state
			val prevState = process.states.get(curStateIndex - 1)
			val nextStateTransitions = prevState.eAllOfType(SetStateStat).filter[isNext]
			transitionExists = transitionExists || !nextStateTransitions.empty
		}
		if (!transitionExists) {
			warning("State is unreachable", ePackage.state_Name)
		}
	}

	@Check def void checkTimeoutVariable(TimeoutFunction func) {
		if (func.isReferencedTimeout) {
			val program = func.getContainerOfType(Program)
			val timeContainer = func.ref
			if (timeContainer instanceof ProgramVariable) {
				if (!program.containsReferencesOfType(timeContainer, ePackage.assignmentExpression_AssignVar)) {
					warning("Uninitialized variable is used in timeout", ePackage.timeAmountOrRef_Ref)
				}
			}
		}
	}

	@Check def void checkNameShadowing(Process process) {
		val Map<String, EObject> globalCtx = newHashMap()

		val program = process.getContainerOfType(Program)
		globalCtx.putAll(program.globalVars.toMap([name], identity))
		globalCtx.putAll(program.ports.toMap([name], identity))
		globalCtx.putAll(program.enums.map[enumMembers].flatten.toMap([name], identity))
		globalCtx.putAll(program.consts.toMap([name], identity))

		for (variable : process.variables) {
			var ref = variable.isPhysical ? ePackage.physicalVariable_Name : ePackage.programVariable_Name
			if (globalCtx.containsKey(variable.name)) {
				var shadowed = globalCtx.get(variable.name)
				var String errorMessage
				switch shadowed {
					GlobalVariable:
						errorMessage = '''Process variable shadows global variable with name "«shadowed.name»"'''
					Port:
						errorMessage = '''Process variable shadows port with name "«shadowed.name»"'''
					EnumMember:
						errorMessage = '''Process variable shadows enum member with name "«shadowed.name»"'''
					Const:
						errorMessage = '''Process variable shadows constant with name "«shadowed.name»"'''
				}
				error(errorMessage, variable, ref)
			}
		}
	}

	@Check def void checkImportedVariablesConflictsProcessVariables(ImportedVariableList imports) {
		val Map<String, ProcessVariable> ctx = imports.getContainerOfType(Process).variables.toMap([name], identity);
		for (variable : imports.variables) {
			if (ctx.containsKey(variable.name)) {
				var conflicted = ctx.get(variable.name)
				var ref = conflicted.isPhysical ? ePackage.physicalVariable_Name : ePackage.programVariable_Name
				error("Process variable conflicts with imported variable", conflicted, ref)
				error('''Name "«variable.name»" conflicts with process variable name''',
					ePackage.importedVariableList_Variables)
			}
		}
	}

	@Check def void checkImportedVariablesConflictsOtherImports(ImportedVariableList importToCheck) {
		var Map<String, ImportedVariableList> ctx = newHashMap()
		for (imp : importToCheck.getContainerOfType(Process).imports.reject[equals(importToCheck)]) {
			for (variable : imp.variables) {
				ctx.put(variable.name, imp)
			}
		}

		for (variable : importToCheck.variables) {
			if (ctx.containsKey(variable.name)) {
				var conflicted = ctx.get(variable.name)
				error('''Conflict for name «variable.name» in imports''', conflicted,
					ePackage.importedVariableList_Variables)
				error('''Conflict for name «variable.name» in imports''', importToCheck,
					ePackage.importedVariableList_Variables)

			}
		}
	}

	@Check def void checkProcessHasStates(Process proc) {
		if (proc.states.empty) {
			error("No states declared in process", ePackage.process_Name)
		}
	}

	@Check def void checkTimeoutHasReaction(TimeoutFunction func) {
		val rootStat = func.body;
		if (rootStat instanceof CompoundStatement) {
			if (rootStat.empty) {
				error("Timeout reaction has no statements", null)
			}
		}
	}

	@Check def void checkIfStat(IfElseStat stat) {
		val ifRootStat = stat.then
		if (ifRootStat instanceof CompoundStatement) {
			if (ifRootStat.empty) {
				warning("Empty body", null)
			}
		}
	}

	@Check def void checkStateBody(ru.iaie.reflex.reflex.State state) {
		if (state.stateFunction.statements.empty && !state.hasTimeoutReaction) {
			error("State body has no statements", null)
		}
	}

	@Check def void checkProcessIsReachable(Process process) {
		if(process.index == 0) return
		val program = process.getContainerOfType(Program)
		for (outsideProcess : program.processes.reject[equals(process)]) {
			if(outsideProcess.containsReferencesOfType(process, ePackage.startProcStat_Process)) return
		}
		warning("Process is unreachable (never started by another process)", ePackage.process_Name)
	}

	@Check def void checkStateContainsMeaningfulStatements(ru.iaie.reflex.reflex.State state) {
		val meaningful = state.eAllOfType(Statement).filter(
			stat |
				stat instanceof StartProcStat || stat instanceof StopProcStat && !(stat as StopProcStat).selfStop ||
					stat instanceof ErrorStat && !(stat as ErrorStat).selfError ||
					stat instanceof AssignmentExpression &&
						((stat as AssignmentExpression).hasAssignment ||
							(stat as AssignmentExpression).hasFunctionCall) || stat instanceof IfElseStat ||
					stat instanceof SwitchStat
		)
		if (meaningful.empty) {
			warning("State body has no start | stop | error process statements or assign expressions", null)
		}
	}

	@Check def void checkConstValue(Const c) {
		if (!c.value.isConstExpr) {
			error("Only constant expressions allowed", ePackage.const_Value)
		}
	}

	@Check def void checkEnumMemberValue(EnumMember em) {
		if (em.hasValue) {
			if (!em.value.isConstExpr) {
				error("Only constant expressions allowed", ePackage.enumMember_Value)
			}
		}
	}

	@Check def void checkPortSize(Port p) {
		val size = LiteralUtils.parseInteger(p.size)
		if (!(size == 8 || size == 16)) {
			error("Only 8 or 16 values allowed", ePackage.port_Size)
		}
	}

	@Check def void checkPortMapping(PhysicalVariable physVar) {
		if (!physVar.mapping.fullMapping) {
			val portSize = LiteralUtils.parseInteger(physVar.mapping.port.size)
			val bitNum = LiteralUtils.parseInteger(physVar.mapping.bit)
			if (bitNum > portSize || bitNum <= 0) {
				error('''Port bit value must be in interval of 1..«portSize»''', physVar.mapping,
					ePackage.portMapping_Bit)
			}
		}
	}

	@Check def void validateTypes(Expression expr) {
		try {
			val List<TypeWarning> warnings = newArrayList()
			expr.resolveType(warnings)
			for (typeWarning : warnings) {
				warning(typeWarning.message, typeWarning.expression, null)
			}
		} catch (IllegalStateException e) {
			// Ignore
		}
	}
	
	@Check def void checkConstAssignType(Const const) {
		try {
			val assignType = const.value.resolveType
			if (!assignType.canBeSafelySignedTo(const.type)) {
				warning('''Constant type «const.type» is not compitable with assigned value type «assignType»''',
					ePackage.const_Name)
			}
		} catch (IllegalStateException e) {
			// Ignore
		}
	}
	
	@Check def void checkEnumMemberAssignType(EnumMember em) {
		try {
			val assignType = em.value.resolveType
			if (!assignType.canBeSafelyCastedTo(em.defaultType)) {
				warning('''Enum member type «Type.INT32_U» is not compitable with assigned value type «assignType»''',
					ePackage.enumMember_Name)
			}
		} catch (IllegalStateException e) {
			// Ignore
		}

	}
	
	@Check def void checkPhysicalVariableType(PhysicalVariable physVar) {
		val mapping = physVar.mapping
		if (mapping.isFullMapping) {
			try {
				val expectedType = mapping.port.suitableTypeForPort
				if (expectedType != physVar.type) {
					warning('''Variable mapped on port «mapping.port.name» should have «expectedType» type''',
						ePackage.physicalVariable_Type)
				}
			} catch (IllegalStateException e) {
				// Ignore
				return;
			}
		} else {
			if (physVar.type != Type.BOOL)
				warning('''One bit mapped variables should be only «Type.BOOL» type''', ePackage.physicalVariable_Type)
		}
	}
}