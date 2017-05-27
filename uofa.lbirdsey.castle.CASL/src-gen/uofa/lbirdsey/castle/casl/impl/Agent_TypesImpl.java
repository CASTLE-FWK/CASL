/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uofa.lbirdsey.castle.casl.Agent_Type_Name;
import uofa.lbirdsey.castle.casl.Agent_Types;
import uofa.lbirdsey.castle.casl.CaslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent Types</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Agent_TypesImpl#getAgent_types <em>Agent types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Agent_TypesImpl extends MinimalEObjectImpl.Container implements Agent_Types
{
  /**
   * The cached value of the '{@link #getAgent_types() <em>Agent types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAgent_types()
   * @generated
   * @ordered
   */
  protected EList<Agent_Type_Name> agent_types;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Agent_TypesImpl()
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
    return CaslPackage.eINSTANCE.getAgent_Types();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Agent_Type_Name> getAgent_types()
  {
    if (agent_types == null)
    {
      agent_types = new EObjectContainmentEList<Agent_Type_Name>(Agent_Type_Name.class, this, CaslPackage.AGENT_TYPES__AGENT_TYPES);
    }
    return agent_types;
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
      case CaslPackage.AGENT_TYPES__AGENT_TYPES:
        return ((InternalEList<?>)getAgent_types()).basicRemove(otherEnd, msgs);
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
      case CaslPackage.AGENT_TYPES__AGENT_TYPES:
        return getAgent_types();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CaslPackage.AGENT_TYPES__AGENT_TYPES:
        getAgent_types().clear();
        getAgent_types().addAll((Collection<? extends Agent_Type_Name>)newValue);
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
      case CaslPackage.AGENT_TYPES__AGENT_TYPES:
        getAgent_types().clear();
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
      case CaslPackage.AGENT_TYPES__AGENT_TYPES:
        return agent_types != null && !agent_types.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Agent_TypesImpl
