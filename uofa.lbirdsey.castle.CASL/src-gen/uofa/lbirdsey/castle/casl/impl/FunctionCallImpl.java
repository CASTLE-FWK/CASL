/**
 * generated by Xtext 2.13.0
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.Function;
import uofa.lbirdsey.castle.casl.FunctionCall;
import uofa.lbirdsey.castle.casl.Symbol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionCallImpl#getObj <em>Obj</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionCallImpl#getFunc <em>Func</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionCallImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionCallImpl#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionCallImpl extends MinimalEObjectImpl.Container implements FunctionCall
{
  /**
   * The cached value of the '{@link #getObj() <em>Obj</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObj()
   * @generated
   * @ordered
   */
  protected Symbol obj;

  /**
   * The cached value of the '{@link #getFunc() <em>Func</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunc()
   * @generated
   * @ordered
   */
  protected Function func;

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
   * The cached value of the '{@link #getFields() <em>Fields</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFields()
   * @generated
   * @ordered
   */
  protected EList<Symbol> fields;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionCallImpl()
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
    return CaslPackage.eINSTANCE.getFunctionCall();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Symbol getObj()
  {
    if (obj != null && obj.eIsProxy())
    {
      InternalEObject oldObj = (InternalEObject)obj;
      obj = (Symbol)eResolveProxy(oldObj);
      if (obj != oldObj)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.FUNCTION_CALL__OBJ, oldObj, obj));
      }
    }
    return obj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Symbol basicGetObj()
  {
    return obj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObj(Symbol newObj)
  {
    Symbol oldObj = obj;
    obj = newObj;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FUNCTION_CALL__OBJ, oldObj, obj));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function getFunc()
  {
    if (func != null && func.eIsProxy())
    {
      InternalEObject oldFunc = (InternalEObject)func;
      func = (Function)eResolveProxy(oldFunc);
      if (func != oldFunc)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.FUNCTION_CALL__FUNC, oldFunc, func));
      }
    }
    return func;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function basicGetFunc()
  {
    return func;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunc(Function newFunc)
  {
    Function oldFunc = func;
    func = newFunc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FUNCTION_CALL__FUNC, oldFunc, func));
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
      inputs = new EObjectContainmentEList<Expression>(Expression.class, this, CaslPackage.FUNCTION_CALL__INPUTS);
    }
    return inputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Symbol> getFields()
  {
    if (fields == null)
    {
      fields = new EObjectResolvingEList<Symbol>(Symbol.class, this, CaslPackage.FUNCTION_CALL__FIELDS);
    }
    return fields;
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
      case CaslPackage.FUNCTION_CALL__INPUTS:
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
      case CaslPackage.FUNCTION_CALL__OBJ:
        if (resolve) return getObj();
        return basicGetObj();
      case CaslPackage.FUNCTION_CALL__FUNC:
        if (resolve) return getFunc();
        return basicGetFunc();
      case CaslPackage.FUNCTION_CALL__INPUTS:
        return getInputs();
      case CaslPackage.FUNCTION_CALL__FIELDS:
        return getFields();
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
      case CaslPackage.FUNCTION_CALL__OBJ:
        setObj((Symbol)newValue);
        return;
      case CaslPackage.FUNCTION_CALL__FUNC:
        setFunc((Function)newValue);
        return;
      case CaslPackage.FUNCTION_CALL__INPUTS:
        getInputs().clear();
        getInputs().addAll((Collection<? extends Expression>)newValue);
        return;
      case CaslPackage.FUNCTION_CALL__FIELDS:
        getFields().clear();
        getFields().addAll((Collection<? extends Symbol>)newValue);
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
      case CaslPackage.FUNCTION_CALL__OBJ:
        setObj((Symbol)null);
        return;
      case CaslPackage.FUNCTION_CALL__FUNC:
        setFunc((Function)null);
        return;
      case CaslPackage.FUNCTION_CALL__INPUTS:
        getInputs().clear();
        return;
      case CaslPackage.FUNCTION_CALL__FIELDS:
        getFields().clear();
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
      case CaslPackage.FUNCTION_CALL__OBJ:
        return obj != null;
      case CaslPackage.FUNCTION_CALL__FUNC:
        return func != null;
      case CaslPackage.FUNCTION_CALL__INPUTS:
        return inputs != null && !inputs.isEmpty();
      case CaslPackage.FUNCTION_CALL__FIELDS:
        return fields != null && !fields.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunctionCallImpl
