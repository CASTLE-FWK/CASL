/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.GroupInternalInteraction;
import uofa.lbirdsey.castle.casl.GroupInternalInteractionsFeatureCall;
import uofa.lbirdsey.castle.casl.Symbol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Internal Interactions Feature Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupInternalInteractionsFeatureCallImpl#getGrp <em>Grp</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupInternalInteractionsFeatureCallImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupInternalInteractionsFeatureCallImpl#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupInternalInteractionsFeatureCallImpl extends MinimalEObjectImpl.Container implements GroupInternalInteractionsFeatureCall
{
  /**
   * The cached value of the '{@link #getGrp() <em>Grp</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGrp()
   * @generated
   * @ordered
   */
  protected Symbol grp;

  /**
   * The cached value of the '{@link #getProcess() <em>Process</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcess()
   * @generated
   * @ordered
   */
  protected GroupInternalInteraction process;

  /**
   * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputs()
   * @generated
   * @ordered
   */
  protected EList<Expression> inputs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GroupInternalInteractionsFeatureCallImpl()
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
    return CaslPackage.eINSTANCE.getGroupInternalInteractionsFeatureCall();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Symbol getGrp()
  {
    if (grp != null && grp.eIsProxy())
    {
      InternalEObject oldGrp = (InternalEObject)grp;
      grp = (Symbol)eResolveProxy(oldGrp);
      if (grp != oldGrp)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__GRP, oldGrp, grp));
      }
    }
    return grp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Symbol basicGetGrp()
  {
    return grp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGrp(Symbol newGrp)
  {
    Symbol oldGrp = grp;
    grp = newGrp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__GRP, oldGrp, grp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupInternalInteraction getProcess()
  {
    if (process != null && process.eIsProxy())
    {
      InternalEObject oldProcess = (InternalEObject)process;
      process = (GroupInternalInteraction)eResolveProxy(oldProcess);
      if (process != oldProcess)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__PROCESS, oldProcess, process));
      }
    }
    return process;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupInternalInteraction basicGetProcess()
  {
    return process;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProcess(GroupInternalInteraction newProcess)
  {
    GroupInternalInteraction oldProcess = process;
    process = newProcess;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__PROCESS, oldProcess, process));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getInputs()
  {
    if (inputs == null)
    {
      inputs = new EObjectContainmentEList<Expression>(Expression.class, this, CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__INPUTS);
    }
    return inputs;
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
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__INPUTS:
        return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
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
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__GRP:
        if (resolve) return getGrp();
        return basicGetGrp();
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__PROCESS:
        if (resolve) return getProcess();
        return basicGetProcess();
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__INPUTS:
        return getInputs();
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
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__GRP:
        setGrp((Symbol)newValue);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__PROCESS:
        setProcess((GroupInternalInteraction)newValue);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__INPUTS:
        getInputs().clear();
        getInputs().addAll((Collection<? extends Expression>)newValue);
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
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__GRP:
        setGrp((Symbol)null);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__PROCESS:
        setProcess((GroupInternalInteraction)null);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__INPUTS:
        getInputs().clear();
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
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__GRP:
        return grp != null;
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__PROCESS:
        return process != null;
      case CaslPackage.GROUP_INTERNAL_INTERACTIONS_FEATURE_CALL__INPUTS:
        return inputs != null && !inputs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GroupInternalInteractionsFeatureCallImpl