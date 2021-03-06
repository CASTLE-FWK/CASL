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
import uofa.lbirdsey.castle.casl.Environment;
import uofa.lbirdsey.castle.casl.Environment_Call;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Environment_CallImpl#getEnvironmentCall <em>Environment Call</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Environment_CallImpl#getEnv <em>Env</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Environment_CallImpl#getQnc <em>Qnc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Environment_CallImpl extends ExpressionImpl implements Environment_Call
{
  /**
   * The cached value of the '{@link #getEnvironmentCall() <em>Environment Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnvironmentCall()
   * @generated
   * @ordered
   */
  protected Environment_Call environmentCall;

  /**
   * The cached value of the '{@link #getEnv() <em>Env</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnv()
   * @generated
   * @ordered
   */
  protected Environment env;

  /**
   * The default value of the '{@link #getQnc() <em>Qnc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQnc()
   * @generated
   * @ordered
   */
  protected static final String QNC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getQnc() <em>Qnc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQnc()
   * @generated
   * @ordered
   */
  protected String qnc = QNC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Environment_CallImpl()
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
    return CaslPackage.eINSTANCE.getEnvironment_Call();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment_Call getEnvironmentCall()
  {
    return environmentCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnvironmentCall(Environment_Call newEnvironmentCall, NotificationChain msgs)
  {
    Environment_Call oldEnvironmentCall = environmentCall;
    environmentCall = newEnvironmentCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.ENVIRONMENT_CALL__ENVIRONMENT_CALL, oldEnvironmentCall, newEnvironmentCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnvironmentCall(Environment_Call newEnvironmentCall)
  {
    if (newEnvironmentCall != environmentCall)
    {
      NotificationChain msgs = null;
      if (environmentCall != null)
        msgs = ((InternalEObject)environmentCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.ENVIRONMENT_CALL__ENVIRONMENT_CALL, null, msgs);
      if (newEnvironmentCall != null)
        msgs = ((InternalEObject)newEnvironmentCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.ENVIRONMENT_CALL__ENVIRONMENT_CALL, null, msgs);
      msgs = basicSetEnvironmentCall(newEnvironmentCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ENVIRONMENT_CALL__ENVIRONMENT_CALL, newEnvironmentCall, newEnvironmentCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment getEnv()
  {
    if (env != null && env.eIsProxy())
    {
      InternalEObject oldEnv = (InternalEObject)env;
      env = (Environment)eResolveProxy(oldEnv);
      if (env != oldEnv)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.ENVIRONMENT_CALL__ENV, oldEnv, env));
      }
    }
    return env;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment basicGetEnv()
  {
    return env;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnv(Environment newEnv)
  {
    Environment oldEnv = env;
    env = newEnv;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ENVIRONMENT_CALL__ENV, oldEnv, env));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getQnc()
  {
    return qnc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQnc(String newQnc)
  {
    String oldQnc = qnc;
    qnc = newQnc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ENVIRONMENT_CALL__QNC, oldQnc, qnc));
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
      case CaslPackage.ENVIRONMENT_CALL__ENVIRONMENT_CALL:
        return basicSetEnvironmentCall(null, msgs);
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
      case CaslPackage.ENVIRONMENT_CALL__ENVIRONMENT_CALL:
        return getEnvironmentCall();
      case CaslPackage.ENVIRONMENT_CALL__ENV:
        if (resolve) return getEnv();
        return basicGetEnv();
      case CaslPackage.ENVIRONMENT_CALL__QNC:
        return getQnc();
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
      case CaslPackage.ENVIRONMENT_CALL__ENVIRONMENT_CALL:
        setEnvironmentCall((Environment_Call)newValue);
        return;
      case CaslPackage.ENVIRONMENT_CALL__ENV:
        setEnv((Environment)newValue);
        return;
      case CaslPackage.ENVIRONMENT_CALL__QNC:
        setQnc((String)newValue);
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
      case CaslPackage.ENVIRONMENT_CALL__ENVIRONMENT_CALL:
        setEnvironmentCall((Environment_Call)null);
        return;
      case CaslPackage.ENVIRONMENT_CALL__ENV:
        setEnv((Environment)null);
        return;
      case CaslPackage.ENVIRONMENT_CALL__QNC:
        setQnc(QNC_EDEFAULT);
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
      case CaslPackage.ENVIRONMENT_CALL__ENVIRONMENT_CALL:
        return environmentCall != null;
      case CaslPackage.ENVIRONMENT_CALL__ENV:
        return env != null;
      case CaslPackage.ENVIRONMENT_CALL__QNC:
        return QNC_EDEFAULT == null ? qnc != null : !QNC_EDEFAULT.equals(qnc);
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
    result.append(" (qnc: ");
    result.append(qnc);
    result.append(')');
    return result.toString();
  }

} //Environment_CallImpl
