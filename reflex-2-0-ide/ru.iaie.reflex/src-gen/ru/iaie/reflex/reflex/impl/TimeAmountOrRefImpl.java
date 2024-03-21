/**
 * generated by Xtext 2.29.0
 */
package ru.iaie.reflex.reflex.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import ru.iaie.reflex.reflex.IdReference;
import ru.iaie.reflex.reflex.ReflexPackage;
import ru.iaie.reflex.reflex.TimeAmountOrRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Amount Or Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.impl.TimeAmountOrRefImpl#getTime <em>Time</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.TimeAmountOrRefImpl#getIntTime <em>Int Time</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.TimeAmountOrRefImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeAmountOrRefImpl extends MinimalEObjectImpl.Container implements TimeAmountOrRef
{
  /**
   * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTime()
   * @generated
   * @ordered
   */
  protected static final String TIME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTime()
   * @generated
   * @ordered
   */
  protected String time = TIME_EDEFAULT;

  /**
   * The default value of the '{@link #getIntTime() <em>Int Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntTime()
   * @generated
   * @ordered
   */
  protected static final String INT_TIME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIntTime() <em>Int Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntTime()
   * @generated
   * @ordered
   */
  protected String intTime = INT_TIME_EDEFAULT;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected IdReference ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimeAmountOrRefImpl()
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
    return ReflexPackage.Literals.TIME_AMOUNT_OR_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getTime()
  {
    return time;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTime(String newTime)
  {
    String oldTime = time;
    time = newTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.TIME_AMOUNT_OR_REF__TIME, oldTime, time));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getIntTime()
  {
    return intTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIntTime(String newIntTime)
  {
    String oldIntTime = intTime;
    intTime = newIntTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.TIME_AMOUNT_OR_REF__INT_TIME, oldIntTime, intTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IdReference getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (IdReference)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReflexPackage.TIME_AMOUNT_OR_REF__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdReference basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRef(IdReference newRef)
  {
    IdReference oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.TIME_AMOUNT_OR_REF__REF, oldRef, ref));
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
      case ReflexPackage.TIME_AMOUNT_OR_REF__TIME:
        return getTime();
      case ReflexPackage.TIME_AMOUNT_OR_REF__INT_TIME:
        return getIntTime();
      case ReflexPackage.TIME_AMOUNT_OR_REF__REF:
        if (resolve) return getRef();
        return basicGetRef();
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
      case ReflexPackage.TIME_AMOUNT_OR_REF__TIME:
        setTime((String)newValue);
        return;
      case ReflexPackage.TIME_AMOUNT_OR_REF__INT_TIME:
        setIntTime((String)newValue);
        return;
      case ReflexPackage.TIME_AMOUNT_OR_REF__REF:
        setRef((IdReference)newValue);
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
      case ReflexPackage.TIME_AMOUNT_OR_REF__TIME:
        setTime(TIME_EDEFAULT);
        return;
      case ReflexPackage.TIME_AMOUNT_OR_REF__INT_TIME:
        setIntTime(INT_TIME_EDEFAULT);
        return;
      case ReflexPackage.TIME_AMOUNT_OR_REF__REF:
        setRef((IdReference)null);
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
      case ReflexPackage.TIME_AMOUNT_OR_REF__TIME:
        return TIME_EDEFAULT == null ? time != null : !TIME_EDEFAULT.equals(time);
      case ReflexPackage.TIME_AMOUNT_OR_REF__INT_TIME:
        return INT_TIME_EDEFAULT == null ? intTime != null : !INT_TIME_EDEFAULT.equals(intTime);
      case ReflexPackage.TIME_AMOUNT_OR_REF__REF:
        return ref != null;
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
    result.append(" (time: ");
    result.append(time);
    result.append(", intTime: ");
    result.append(intTime);
    result.append(')');
    return result.toString();
  }

} //TimeAmountOrRefImpl