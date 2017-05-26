/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.SelfCall;
import uofa.lbirdsey.castle.casl.SelfCallExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Self Call Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.SelfCallExprImpl#getSelfCall <em>Self Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelfCallExprImpl extends ExpressionImpl implements SelfCallExpr
{
  /**
   * The cached value of the '{@link #getSelfCall() <em>Self Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelfCall()
   * @generated
   * @ordered
   */
  protected SelfCall selfCall;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelfCallExprImpl()
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
    return CaslPackage.eINSTANCE.getSelfCallExpr();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelfCall getSelfCall()
  {
    return selfCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSelfCall(SelfCall newSelfCall, NotificationChain msgs)
  {
    SelfCall oldSelfCall = selfCall;
    selfCall = newSelfCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.SELF_CALL_EXPR__SELF_CALL, oldSelfCall, newSelfCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelfCall(SelfCall newSelfCall)
  {
    if (newSelfCall != selfCall)
    {
      NotificationChain msgs = null;
      if (selfCall != null)
        msgs = ((InternalEObject)selfCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.SELF_CALL_EXPR__SELF_CALL, null, msgs);
      if (newSelfCall != null)
        msgs = ((InternalEObject)newSelfCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.SELF_CALL_EXPR__SELF_CALL, null, msgs);
      msgs = basicSetSelfCall(newSelfCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.SELF_CALL_EXPR__SELF_CALL, newSelfCall, newSelfCall));
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
      case CaslPackage.SELF_CALL_EXPR__SELF_CALL:
        return basicSetSelfCall(null, msgs);
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
      case CaslPackage.SELF_CALL_EXPR__SELF_CALL:
        return getSelfCall();
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
      case CaslPackage.SELF_CALL_EXPR__SELF_CALL:
        setSelfCall((SelfCall)newValue);
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
      case CaslPackage.SELF_CALL_EXPR__SELF_CALL:
        setSelfCall((SelfCall)null);
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
      case CaslPackage.SELF_CALL_EXPR__SELF_CALL:
        return selfCall != null;
    }
    return super.eIsSet(featureID);
  }

} //SelfCallExprImpl