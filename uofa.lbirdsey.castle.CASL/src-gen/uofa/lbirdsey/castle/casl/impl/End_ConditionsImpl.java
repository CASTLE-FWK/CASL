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
import uofa.lbirdsey.castle.casl.End_Condition;
import uofa.lbirdsey.castle.casl.End_Conditions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End Conditions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.End_ConditionsImpl#getEnd_conditions <em>End conditions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class End_ConditionsImpl extends MinimalEObjectImpl.Container implements End_Conditions
{
  /**
   * The cached value of the '{@link #getEnd_conditions() <em>End conditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnd_conditions()
   * @generated
   * @ordered
   */
  protected EList<End_Condition> end_conditions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected End_ConditionsImpl()
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
    return CaslPackage.eINSTANCE.getEnd_Conditions();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<End_Condition> getEnd_conditions()
  {
    if (end_conditions == null)
    {
      end_conditions = new EObjectContainmentEList<End_Condition>(End_Condition.class, this, CaslPackage.END_CONDITIONS__END_CONDITIONS);
    }
    return end_conditions;
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
      case CaslPackage.END_CONDITIONS__END_CONDITIONS:
        return ((InternalEList<?>)getEnd_conditions()).basicRemove(otherEnd, msgs);
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
      case CaslPackage.END_CONDITIONS__END_CONDITIONS:
        return getEnd_conditions();
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
      case CaslPackage.END_CONDITIONS__END_CONDITIONS:
        getEnd_conditions().clear();
        getEnd_conditions().addAll((Collection<? extends End_Condition>)newValue);
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
      case CaslPackage.END_CONDITIONS__END_CONDITIONS:
        getEnd_conditions().clear();
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
      case CaslPackage.END_CONDITIONS__END_CONDITIONS:
        return end_conditions != null && !end_conditions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //End_ConditionsImpl
