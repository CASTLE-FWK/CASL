/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.ForLoop;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.ForLoopImpl#getInit <em>Init</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.ForLoopImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.ForLoopImpl#getShifter <em>Shifter</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.ForLoopImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForLoopImpl extends ExpressionImpl implements ForLoop
{
  /**
   * The cached value of the '{@link #getInit() <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInit()
   * @generated
   * @ordered
   */
  protected EObject init;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected Expression condition;

  /**
   * The cached value of the '{@link #getShifter() <em>Shifter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShifter()
   * @generated
   * @ordered
   */
  protected EObject shifter;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected EList<EObject> body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForLoopImpl()
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
    return CaslPackage.eINSTANCE.getForLoop();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getInit()
  {
    return init;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInit(EObject newInit, NotificationChain msgs)
  {
    EObject oldInit = init;
    init = newInit;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_LOOP__INIT, oldInit, newInit);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInit(EObject newInit)
  {
    if (newInit != init)
    {
      NotificationChain msgs = null;
      if (init != null)
        msgs = ((InternalEObject)init).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FOR_LOOP__INIT, null, msgs);
      if (newInit != null)
        msgs = ((InternalEObject)newInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FOR_LOOP__INIT, null, msgs);
      msgs = basicSetInit(newInit, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_LOOP__INIT, newInit, newInit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs)
  {
    Expression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_LOOP__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(Expression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FOR_LOOP__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FOR_LOOP__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_LOOP__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getShifter()
  {
    return shifter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetShifter(EObject newShifter, NotificationChain msgs)
  {
    EObject oldShifter = shifter;
    shifter = newShifter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_LOOP__SHIFTER, oldShifter, newShifter);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShifter(EObject newShifter)
  {
    if (newShifter != shifter)
    {
      NotificationChain msgs = null;
      if (shifter != null)
        msgs = ((InternalEObject)shifter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FOR_LOOP__SHIFTER, null, msgs);
      if (newShifter != null)
        msgs = ((InternalEObject)newShifter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FOR_LOOP__SHIFTER, null, msgs);
      msgs = basicSetShifter(newShifter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_LOOP__SHIFTER, newShifter, newShifter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getBody()
  {
    if (body == null)
    {
      body = new EObjectContainmentEList<EObject>(EObject.class, this, CaslPackage.FOR_LOOP__BODY);
    }
    return body;
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
      case CaslPackage.FOR_LOOP__INIT:
        return basicSetInit(null, msgs);
      case CaslPackage.FOR_LOOP__CONDITION:
        return basicSetCondition(null, msgs);
      case CaslPackage.FOR_LOOP__SHIFTER:
        return basicSetShifter(null, msgs);
      case CaslPackage.FOR_LOOP__BODY:
        return ((InternalEList<?>)getBody()).basicRemove(otherEnd, msgs);
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
      case CaslPackage.FOR_LOOP__INIT:
        return getInit();
      case CaslPackage.FOR_LOOP__CONDITION:
        return getCondition();
      case CaslPackage.FOR_LOOP__SHIFTER:
        return getShifter();
      case CaslPackage.FOR_LOOP__BODY:
        return getBody();
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
      case CaslPackage.FOR_LOOP__INIT:
        setInit((EObject)newValue);
        return;
      case CaslPackage.FOR_LOOP__CONDITION:
        setCondition((Expression)newValue);
        return;
      case CaslPackage.FOR_LOOP__SHIFTER:
        setShifter((EObject)newValue);
        return;
      case CaslPackage.FOR_LOOP__BODY:
        getBody().clear();
        getBody().addAll((Collection<? extends EObject>)newValue);
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
      case CaslPackage.FOR_LOOP__INIT:
        setInit((EObject)null);
        return;
      case CaslPackage.FOR_LOOP__CONDITION:
        setCondition((Expression)null);
        return;
      case CaslPackage.FOR_LOOP__SHIFTER:
        setShifter((EObject)null);
        return;
      case CaslPackage.FOR_LOOP__BODY:
        getBody().clear();
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
      case CaslPackage.FOR_LOOP__INIT:
        return init != null;
      case CaslPackage.FOR_LOOP__CONDITION:
        return condition != null;
      case CaslPackage.FOR_LOOP__SHIFTER:
        return shifter != null;
      case CaslPackage.FOR_LOOP__BODY:
        return body != null && !body.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ForLoopImpl
