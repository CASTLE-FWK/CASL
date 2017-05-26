/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uofa.lbirdsey.castle.casl.Agent;
import uofa.lbirdsey.castle.casl.Agent_Call;
import uofa.lbirdsey.castle.casl.CaslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Agent_CallImpl#getAgentCall <em>Agent Call</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Agent_CallImpl#getAgent <em>Agent</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Agent_CallImpl#getQnc <em>Qnc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Agent_CallImpl extends ExpressionImpl implements Agent_Call
{
  /**
   * The cached value of the '{@link #getAgentCall() <em>Agent Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAgentCall()
   * @generated
   * @ordered
   */
  protected Agent_Call agentCall;

  /**
   * The cached value of the '{@link #getAgent() <em>Agent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAgent()
   * @generated
   * @ordered
   */
  protected Agent agent;

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
  protected Agent_CallImpl()
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
    return CaslPackage.eINSTANCE.getAgent_Call();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Agent_Call getAgentCall()
  {
    return agentCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAgentCall(Agent_Call newAgentCall, NotificationChain msgs)
  {
    Agent_Call oldAgentCall = agentCall;
    agentCall = newAgentCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.AGENT_CALL__AGENT_CALL, oldAgentCall, newAgentCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAgentCall(Agent_Call newAgentCall)
  {
    if (newAgentCall != agentCall)
    {
      NotificationChain msgs = null;
      if (agentCall != null)
        msgs = ((InternalEObject)agentCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.AGENT_CALL__AGENT_CALL, null, msgs);
      if (newAgentCall != null)
        msgs = ((InternalEObject)newAgentCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.AGENT_CALL__AGENT_CALL, null, msgs);
      msgs = basicSetAgentCall(newAgentCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.AGENT_CALL__AGENT_CALL, newAgentCall, newAgentCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Agent getAgent()
  {
    if (agent != null && agent.eIsProxy())
    {
      InternalEObject oldAgent = (InternalEObject)agent;
      agent = (Agent)eResolveProxy(oldAgent);
      if (agent != oldAgent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.AGENT_CALL__AGENT, oldAgent, agent));
      }
    }
    return agent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Agent basicGetAgent()
  {
    return agent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAgent(Agent newAgent)
  {
    Agent oldAgent = agent;
    agent = newAgent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.AGENT_CALL__AGENT, oldAgent, agent));
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
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.AGENT_CALL__QNC, oldQnc, qnc));
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
      case CaslPackage.AGENT_CALL__AGENT_CALL:
        return basicSetAgentCall(null, msgs);
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
      case CaslPackage.AGENT_CALL__AGENT_CALL:
        return getAgentCall();
      case CaslPackage.AGENT_CALL__AGENT:
        if (resolve) return getAgent();
        return basicGetAgent();
      case CaslPackage.AGENT_CALL__QNC:
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
      case CaslPackage.AGENT_CALL__AGENT_CALL:
        setAgentCall((Agent_Call)newValue);
        return;
      case CaslPackage.AGENT_CALL__AGENT:
        setAgent((Agent)newValue);
        return;
      case CaslPackage.AGENT_CALL__QNC:
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
      case CaslPackage.AGENT_CALL__AGENT_CALL:
        setAgentCall((Agent_Call)null);
        return;
      case CaslPackage.AGENT_CALL__AGENT:
        setAgent((Agent)null);
        return;
      case CaslPackage.AGENT_CALL__QNC:
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
      case CaslPackage.AGENT_CALL__AGENT_CALL:
        return agentCall != null;
      case CaslPackage.AGENT_CALL__AGENT:
        return agent != null;
      case CaslPackage.AGENT_CALL__QNC:
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

} //Agent_CallImpl
