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
import uofa.lbirdsey.castle.casl.Function;
import uofa.lbirdsey.castle.casl.FunctionFeatureCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Feature Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionFeatureCallImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionFeatureCallImpl#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionFeatureCallImpl extends MinimalEObjectImpl.Container implements FunctionFeatureCall
{
  /**
   * The cached value of the '{@link #getProcess() <em>Process</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcess()
   * @generated
   * @ordered
   */
  protected Function process;

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
  protected FunctionFeatureCallImpl()
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
    return CaslPackage.eINSTANCE.getFunctionFeatureCall();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function getProcess()
  {
    if (process != null && process.eIsProxy())
    {
      InternalEObject oldProcess = (InternalEObject)process;
      process = (Function)eResolveProxy(oldProcess);
      if (process != oldProcess)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.FUNCTION_FEATURE_CALL__PROCESS, oldProcess, process));
      }
    }
    return process;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function basicGetProcess()
  {
    return process;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProcess(Function newProcess)
  {
    Function oldProcess = process;
    process = newProcess;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FUNCTION_FEATURE_CALL__PROCESS, oldProcess, process));
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
      inputs = new EObjectContainmentEList<Expression>(Expression.class, this, CaslPackage.FUNCTION_FEATURE_CALL__INPUTS);
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
      case CaslPackage.FUNCTION_FEATURE_CALL__INPUTS:
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
      case CaslPackage.FUNCTION_FEATURE_CALL__PROCESS:
        if (resolve) return getProcess();
        return basicGetProcess();
      case CaslPackage.FUNCTION_FEATURE_CALL__INPUTS:
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
      case CaslPackage.FUNCTION_FEATURE_CALL__PROCESS:
        setProcess((Function)newValue);
        return;
      case CaslPackage.FUNCTION_FEATURE_CALL__INPUTS:
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
      case CaslPackage.FUNCTION_FEATURE_CALL__PROCESS:
        setProcess((Function)null);
        return;
      case CaslPackage.FUNCTION_FEATURE_CALL__INPUTS:
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
      case CaslPackage.FUNCTION_FEATURE_CALL__PROCESS:
        return process != null;
      case CaslPackage.FUNCTION_FEATURE_CALL__INPUTS:
        return inputs != null && !inputs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunctionFeatureCallImpl
