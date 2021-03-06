/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.NullType;
import uofa.lbirdsey.castle.casl.NullTypeLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Null Type Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.NullTypeLiteralImpl#getNulltype <em>Nulltype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NullTypeLiteralImpl extends ExpressionImpl implements NullTypeLiteral
{
  /**
   * The cached value of the '{@link #getNulltype() <em>Nulltype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNulltype()
   * @generated
   * @ordered
   */
  protected NullType nulltype;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NullTypeLiteralImpl()
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
    return CaslPackage.eINSTANCE.getNullTypeLiteral();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullType getNulltype()
  {
    return nulltype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNulltype(NullType newNulltype, NotificationChain msgs)
  {
    NullType oldNulltype = nulltype;
    nulltype = newNulltype;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.NULL_TYPE_LITERAL__NULLTYPE, oldNulltype, newNulltype);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNulltype(NullType newNulltype)
  {
    if (newNulltype != nulltype)
    {
      NotificationChain msgs = null;
      if (nulltype != null)
        msgs = ((InternalEObject)nulltype).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.NULL_TYPE_LITERAL__NULLTYPE, null, msgs);
      if (newNulltype != null)
        msgs = ((InternalEObject)newNulltype).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.NULL_TYPE_LITERAL__NULLTYPE, null, msgs);
      msgs = basicSetNulltype(newNulltype, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.NULL_TYPE_LITERAL__NULLTYPE, newNulltype, newNulltype));
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
      case CaslPackage.NULL_TYPE_LITERAL__NULLTYPE:
        return basicSetNulltype(null, msgs);
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
      case CaslPackage.NULL_TYPE_LITERAL__NULLTYPE:
        return getNulltype();
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
      case CaslPackage.NULL_TYPE_LITERAL__NULLTYPE:
        setNulltype((NullType)newValue);
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
      case CaslPackage.NULL_TYPE_LITERAL__NULLTYPE:
        setNulltype((NullType)null);
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
      case CaslPackage.NULL_TYPE_LITERAL__NULLTYPE:
        return nulltype != null;
    }
    return super.eIsSet(featureID);
  }

} //NullTypeLiteralImpl
