/**
 * generated by Xtext 2.29.0
 */
package ru.iaie.reflex.reflex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ru.iaie.reflex.reflex.PhysicalVariable;
import ru.iaie.reflex.reflex.PortMapping;
import ru.iaie.reflex.reflex.ReflexPackage;
import ru.iaie.reflex.reflex.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.impl.PhysicalVariableImpl#isShared <em>Shared</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.PhysicalVariableImpl#getType <em>Type</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.PhysicalVariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.PhysicalVariableImpl#getMapping <em>Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PhysicalVariableImpl extends ProcessVariableImpl implements PhysicalVariable
{
  /**
   * The default value of the '{@link #isShared() <em>Shared</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isShared()
   * @generated
   * @ordered
   */
  protected static final boolean SHARED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isShared() <em>Shared</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isShared()
   * @generated
   * @ordered
   */
  protected boolean shared = SHARED_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final Type TYPE_EDEFAULT = Type.VOID_CTYPE;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getMapping() <em>Mapping</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMapping()
   * @generated
   * @ordered
   */
  protected PortMapping mapping;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PhysicalVariableImpl()
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
    return ReflexPackage.Literals.PHYSICAL_VARIABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isShared()
  {
    return shared;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setShared(boolean newShared)
  {
    boolean oldShared = shared;
    shared = newShared;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.PHYSICAL_VARIABLE__SHARED, oldShared, shared));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Type getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(Type newType)
  {
    Type oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.PHYSICAL_VARIABLE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.PHYSICAL_VARIABLE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PortMapping getMapping()
  {
    return mapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMapping(PortMapping newMapping, NotificationChain msgs)
  {
    PortMapping oldMapping = mapping;
    mapping = newMapping;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReflexPackage.PHYSICAL_VARIABLE__MAPPING, oldMapping, newMapping);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMapping(PortMapping newMapping)
  {
    if (newMapping != mapping)
    {
      NotificationChain msgs = null;
      if (mapping != null)
        msgs = ((InternalEObject)mapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReflexPackage.PHYSICAL_VARIABLE__MAPPING, null, msgs);
      if (newMapping != null)
        msgs = ((InternalEObject)newMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReflexPackage.PHYSICAL_VARIABLE__MAPPING, null, msgs);
      msgs = basicSetMapping(newMapping, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.PHYSICAL_VARIABLE__MAPPING, newMapping, newMapping));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReflexPackage.PHYSICAL_VARIABLE__MAPPING:
        return basicSetMapping(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ReflexPackage.PHYSICAL_VARIABLE__SHARED:
        return isShared();
      case ReflexPackage.PHYSICAL_VARIABLE__TYPE:
        return getType();
      case ReflexPackage.PHYSICAL_VARIABLE__NAME:
        return getName();
      case ReflexPackage.PHYSICAL_VARIABLE__MAPPING:
        return getMapping();
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
      case ReflexPackage.PHYSICAL_VARIABLE__SHARED:
        setShared((Boolean)newValue);
        return;
      case ReflexPackage.PHYSICAL_VARIABLE__TYPE:
        setType((Type)newValue);
        return;
      case ReflexPackage.PHYSICAL_VARIABLE__NAME:
        setName((String)newValue);
        return;
      case ReflexPackage.PHYSICAL_VARIABLE__MAPPING:
        setMapping((PortMapping)newValue);
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
      case ReflexPackage.PHYSICAL_VARIABLE__SHARED:
        setShared(SHARED_EDEFAULT);
        return;
      case ReflexPackage.PHYSICAL_VARIABLE__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case ReflexPackage.PHYSICAL_VARIABLE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ReflexPackage.PHYSICAL_VARIABLE__MAPPING:
        setMapping((PortMapping)null);
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
      case ReflexPackage.PHYSICAL_VARIABLE__SHARED:
        return shared != SHARED_EDEFAULT;
      case ReflexPackage.PHYSICAL_VARIABLE__TYPE:
        return type != TYPE_EDEFAULT;
      case ReflexPackage.PHYSICAL_VARIABLE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ReflexPackage.PHYSICAL_VARIABLE__MAPPING:
        return mapping != null;
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
    result.append(" (shared: ");
    result.append(shared);
    result.append(", type: ");
    result.append(type);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PhysicalVariableImpl
