/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uofa.lbirdsey.castle.casl.CASL_Macro_Random;
import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.RandomType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CASL Macro Random</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_RandomImpl#getType <em>Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_RandomImpl#getLow <em>Low</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_RandomImpl#getHigh <em>High</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CASL_Macro_RandomImpl extends CASL_MacroImpl implements CASL_Macro_Random
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final RandomType TYPE_EDEFAULT = RandomType.INT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected RandomType type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getLow() <em>Low</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLow()
   * @generated
   * @ordered
   */
  protected Expression low;

  /**
   * The cached value of the '{@link #getHigh() <em>High</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHigh()
   * @generated
   * @ordered
   */
  protected Expression high;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CASL_Macro_RandomImpl()
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
    return CaslPackage.eINSTANCE.getCASL_Macro_Random();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RandomType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(RandomType newType)
  {
    RandomType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_RANDOM__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getLow()
  {
    return low;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLow(Expression newLow, NotificationChain msgs)
  {
    Expression oldLow = low;
    low = newLow;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_RANDOM__LOW, oldLow, newLow);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLow(Expression newLow)
  {
    if (newLow != low)
    {
      NotificationChain msgs = null;
      if (low != null)
        msgs = ((InternalEObject)low).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.CASL_MACRO_RANDOM__LOW, null, msgs);
      if (newLow != null)
        msgs = ((InternalEObject)newLow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.CASL_MACRO_RANDOM__LOW, null, msgs);
      msgs = basicSetLow(newLow, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_RANDOM__LOW, newLow, newLow));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getHigh()
  {
    return high;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetHigh(Expression newHigh, NotificationChain msgs)
  {
    Expression oldHigh = high;
    high = newHigh;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_RANDOM__HIGH, oldHigh, newHigh);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHigh(Expression newHigh)
  {
    if (newHigh != high)
    {
      NotificationChain msgs = null;
      if (high != null)
        msgs = ((InternalEObject)high).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.CASL_MACRO_RANDOM__HIGH, null, msgs);
      if (newHigh != null)
        msgs = ((InternalEObject)newHigh).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.CASL_MACRO_RANDOM__HIGH, null, msgs);
      msgs = basicSetHigh(newHigh, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_RANDOM__HIGH, newHigh, newHigh));
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
      case CaslPackage.CASL_MACRO_RANDOM__LOW:
        return basicSetLow(null, msgs);
      case CaslPackage.CASL_MACRO_RANDOM__HIGH:
        return basicSetHigh(null, msgs);
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
      case CaslPackage.CASL_MACRO_RANDOM__TYPE:
        return getType();
      case CaslPackage.CASL_MACRO_RANDOM__LOW:
        return getLow();
      case CaslPackage.CASL_MACRO_RANDOM__HIGH:
        return getHigh();
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
      case CaslPackage.CASL_MACRO_RANDOM__TYPE:
        setType((RandomType)newValue);
        return;
      case CaslPackage.CASL_MACRO_RANDOM__LOW:
        setLow((Expression)newValue);
        return;
      case CaslPackage.CASL_MACRO_RANDOM__HIGH:
        setHigh((Expression)newValue);
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
      case CaslPackage.CASL_MACRO_RANDOM__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case CaslPackage.CASL_MACRO_RANDOM__LOW:
        setLow((Expression)null);
        return;
      case CaslPackage.CASL_MACRO_RANDOM__HIGH:
        setHigh((Expression)null);
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
      case CaslPackage.CASL_MACRO_RANDOM__TYPE:
        return type != TYPE_EDEFAULT;
      case CaslPackage.CASL_MACRO_RANDOM__LOW:
        return low != null;
      case CaslPackage.CASL_MACRO_RANDOM__HIGH:
        return high != null;
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //CASL_Macro_RandomImpl
