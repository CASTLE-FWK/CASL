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
import uofa.lbirdsey.castle.casl.Group_Transmission;
import uofa.lbirdsey.castle.casl.Group_Transmissions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Transmissions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Group_TransmissionsImpl#getTransmissions <em>Transmissions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Group_TransmissionsImpl extends MinimalEObjectImpl.Container implements Group_Transmissions
{
  /**
   * The cached value of the '{@link #getTransmissions() <em>Transmissions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransmissions()
   * @generated
   * @ordered
   */
  protected EList<Group_Transmission> transmissions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Group_TransmissionsImpl()
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
    return CaslPackage.eINSTANCE.getGroup_Transmissions();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Group_Transmission> getTransmissions()
  {
    if (transmissions == null)
    {
      transmissions = new EObjectContainmentEList<Group_Transmission>(Group_Transmission.class, this, CaslPackage.GROUP_TRANSMISSIONS__TRANSMISSIONS);
    }
    return transmissions;
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
      case CaslPackage.GROUP_TRANSMISSIONS__TRANSMISSIONS:
        return ((InternalEList<?>)getTransmissions()).basicRemove(otherEnd, msgs);
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
      case CaslPackage.GROUP_TRANSMISSIONS__TRANSMISSIONS:
        return getTransmissions();
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
      case CaslPackage.GROUP_TRANSMISSIONS__TRANSMISSIONS:
        getTransmissions().clear();
        getTransmissions().addAll((Collection<? extends Group_Transmission>)newValue);
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
      case CaslPackage.GROUP_TRANSMISSIONS__TRANSMISSIONS:
        getTransmissions().clear();
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
      case CaslPackage.GROUP_TRANSMISSIONS__TRANSMISSIONS:
        return transmissions != null && !transmissions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Group_TransmissionsImpl
