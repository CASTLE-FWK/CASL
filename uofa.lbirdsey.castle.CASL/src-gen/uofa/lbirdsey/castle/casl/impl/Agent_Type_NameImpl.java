/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uofa.lbirdsey.castle.casl.Agent_Type_Name;
import uofa.lbirdsey.castle.casl.CaslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent Type Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Agent_Type_NameImpl#getAgent_type_name <em>Agent type name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Agent_Type_NameImpl extends MinimalEObjectImpl.Container implements Agent_Type_Name
{
  /**
   * The default value of the '{@link #getAgent_type_name() <em>Agent type name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAgent_type_name()
   * @generated
   * @ordered
   */
  protected static final String AGENT_TYPE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAgent_type_name() <em>Agent type name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAgent_type_name()
   * @generated
   * @ordered
   */
  protected String agent_type_name = AGENT_TYPE_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Agent_Type_NameImpl()
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
    return CaslPackage.eINSTANCE.getAgent_Type_Name();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAgent_type_name()
  {
    return agent_type_name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAgent_type_name(String newAgent_type_name)
  {
    String oldAgent_type_name = agent_type_name;
    agent_type_name = newAgent_type_name;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.AGENT_TYPE_NAME__AGENT_TYPE_NAME, oldAgent_type_name, agent_type_name));
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
      case CaslPackage.AGENT_TYPE_NAME__AGENT_TYPE_NAME:
        return getAgent_type_name();
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
      case CaslPackage.AGENT_TYPE_NAME__AGENT_TYPE_NAME:
        setAgent_type_name((String)newValue);
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
      case CaslPackage.AGENT_TYPE_NAME__AGENT_TYPE_NAME:
        setAgent_type_name(AGENT_TYPE_NAME_EDEFAULT);
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
      case CaslPackage.AGENT_TYPE_NAME__AGENT_TYPE_NAME:
        return AGENT_TYPE_NAME_EDEFAULT == null ? agent_type_name != null : !AGENT_TYPE_NAME_EDEFAULT.equals(agent_type_name);
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
    result.append(" (agent_type_name: ");
    result.append(agent_type_name);
    result.append(')');
    return result.toString();
  }

} //Agent_Type_NameImpl
