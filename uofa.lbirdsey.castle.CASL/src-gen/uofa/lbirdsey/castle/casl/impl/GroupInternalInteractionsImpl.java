/**
 * generated by Xtext 2.11.0
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

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.GroupInternalInteraction;
import uofa.lbirdsey.castle.casl.GroupInternalInteractions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Internal Interactions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupInternalInteractionsImpl#getInternal_interactions <em>Internal interactions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupInternalInteractionsImpl extends MinimalEObjectImpl.Container implements GroupInternalInteractions
{
  /**
   * The cached value of the '{@link #getInternal_interactions() <em>Internal interactions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInternal_interactions()
   * @generated
   * @ordered
   */
  protected EList<GroupInternalInteraction> internal_interactions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GroupInternalInteractionsImpl()
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
    return CaslPackage.eINSTANCE.getGroupInternalInteractions();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GroupInternalInteraction> getInternal_interactions()
  {
    if (internal_interactions == null)
    {
      internal_interactions = new EObjectContainmentEList<GroupInternalInteraction>(GroupInternalInteraction.class, this, CaslPackage.GROUP_INTERNAL_INTERACTIONS__INTERNAL_INTERACTIONS);
    }
    return internal_interactions;
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
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS__INTERNAL_INTERACTIONS:
        return ((InternalEList<?>)getInternal_interactions()).basicRemove(otherEnd, msgs);
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
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS__INTERNAL_INTERACTIONS:
        return getInternal_interactions();
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
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS__INTERNAL_INTERACTIONS:
        getInternal_interactions().clear();
        getInternal_interactions().addAll((Collection<? extends GroupInternalInteraction>)newValue);
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
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS__INTERNAL_INTERACTIONS:
        getInternal_interactions().clear();
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
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS__INTERNAL_INTERACTIONS:
        return internal_interactions != null && !internal_interactions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GroupInternalInteractionsImpl