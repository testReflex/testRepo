/**
 * generated by Xtext 2.29.0
 */
package ru.iaie.reflex.reflex.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ru.iaie.reflex.reflex.CompareEqOp;
import ru.iaie.reflex.reflex.EqualityExpression;
import ru.iaie.reflex.reflex.ReflexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equality Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.impl.EqualityExpressionImpl#getEqCmpOp <em>Eq Cmp Op</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EqualityExpressionImpl extends BitAndExpressionImpl implements EqualityExpression
{
  /**
   * The default value of the '{@link #getEqCmpOp() <em>Eq Cmp Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqCmpOp()
   * @generated
   * @ordered
   */
  protected static final CompareEqOp EQ_CMP_OP_EDEFAULT = CompareEqOp.EQ;

  /**
   * The cached value of the '{@link #getEqCmpOp() <em>Eq Cmp Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqCmpOp()
   * @generated
   * @ordered
   */
  protected CompareEqOp eqCmpOp = EQ_CMP_OP_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EqualityExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ReflexPackage.Literals.EQUALITY_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CompareEqOp getEqCmpOp()
  {
    return eqCmpOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setEqCmpOp(CompareEqOp newEqCmpOp)
  {
    CompareEqOp oldEqCmpOp = eqCmpOp;
    eqCmpOp = newEqCmpOp == null ? EQ_CMP_OP_EDEFAULT : newEqCmpOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.EQUALITY_EXPRESSION__EQ_CMP_OP, oldEqCmpOp, eqCmpOp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReflexPackage.EQUALITY_EXPRESSION__EQ_CMP_OP:
        return getEqCmpOp();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReflexPackage.EQUALITY_EXPRESSION__EQ_CMP_OP:
        setEqCmpOp((CompareEqOp)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ReflexPackage.EQUALITY_EXPRESSION__EQ_CMP_OP:
        setEqCmpOp(EQ_CMP_OP_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ReflexPackage.EQUALITY_EXPRESSION__EQ_CMP_OP:
        return eqCmpOp != EQ_CMP_OP_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (eqCmpOp: ");
    result.append(eqCmpOp);
    result.append(')');
    return result.toString();
  }

} //EqualityExpressionImpl