/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.FeatureCall;
import uofa.lbirdsey.castle.casl.FunctionCall;
import uofa.lbirdsey.castle.casl.SelfCall;
import uofa.lbirdsey.castle.casl.Symbol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Self Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.SelfCallImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.SelfCallImpl#getFc <em>Fc</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.SelfCallImpl#getFec <em>Fec</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelfCallImpl extends MinimalEObjectImpl.Container implements SelfCall
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Symbol ref;

  /**
   * The cached value of the '{@link #getFc() <em>Fc</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFc()
   * @generated
   * @ordered
   */
  protected FunctionCall fc;

  /**
   * The cached value of the '{@link #getFec() <em>Fec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFec()
   * @generated
   * @ordered
   */
  protected FeatureCall fec;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelfCallImpl()
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
    return CaslPackage.eINSTANCE.getSelfCall();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Symbol getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Symbol)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.SELF_CALL__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Symbol basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Symbol newRef)
  {
    Symbol oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.SELF_CALL__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionCall getFc()
  {
    return fc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFc(FunctionCall newFc, NotificationChain msgs)
  {
    FunctionCall oldFc = fc;
    fc = newFc;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.SELF_CALL__FC, oldFc, newFc);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFc(FunctionCall newFc)
  {
    if (newFc != fc)
    {
      NotificationChain msgs = null;
      if (fc != null)
        msgs = ((InternalEObject)fc).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.SELF_CALL__FC, null, msgs);
      if (newFc != null)
        msgs = ((InternalEObject)newFc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.SELF_CALL__FC, null, msgs);
      msgs = basicSetFc(newFc, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.SELF_CALL__FC, newFc, newFc));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureCall getFec()
  {
    return fec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFec(FeatureCall newFec, NotificationChain msgs)
  {
    FeatureCall oldFec = fec;
    fec = newFec;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.SELF_CALL__FEC, oldFec, newFec);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFec(FeatureCall newFec)
  {
    if (newFec != fec)
    {
      NotificationChain msgs = null;
      if (fec != null)
        msgs = ((InternalEObject)fec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.SELF_CALL__FEC, null, msgs);
      if (newFec != null)
        msgs = ((InternalEObject)newFec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.SELF_CALL__FEC, null, msgs);
      msgs = basicSetFec(newFec, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.SELF_CALL__FEC, newFec, newFec));
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
      case CaslPackage.SELF_CALL__FC:
        return basicSetFc(null, msgs);
      case CaslPackage.SELF_CALL__FEC:
        return basicSetFec(null, msgs);
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
      case CaslPackage.SELF_CALL__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case CaslPackage.SELF_CALL__FC:
        return getFc();
      case CaslPackage.SELF_CALL__FEC:
        return getFec();
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
      case CaslPackage.SELF_CALL__REF:
        setRef((Symbol)newValue);
        return;
      case CaslPackage.SELF_CALL__FC:
        setFc((FunctionCall)newValue);
        return;
      case CaslPackage.SELF_CALL__FEC:
        setFec((FeatureCall)newValue);
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
      case CaslPackage.SELF_CALL__REF:
        setRef((Symbol)null);
        return;
      case CaslPackage.SELF_CALL__FC:
        setFc((FunctionCall)null);
        return;
      case CaslPackage.SELF_CALL__FEC:
        setFec((FeatureCall)null);
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
      case CaslPackage.SELF_CALL__REF:
        return ref != null;
      case CaslPackage.SELF_CALL__FC:
        return fc != null;
      case CaslPackage.SELF_CALL__FEC:
        return fec != null;
    }
    return super.eIsSet(featureID);
  }

} //SelfCallImpl
