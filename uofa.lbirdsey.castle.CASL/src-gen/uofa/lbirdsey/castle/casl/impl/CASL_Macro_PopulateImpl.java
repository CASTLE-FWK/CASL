/**
 * generated by Xtext 2.12.0
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

import uofa.lbirdsey.castle.casl.CASL_Macro_Populate;
import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Entity;
import uofa.lbirdsey.castle.casl.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CASL Macro Populate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_PopulateImpl#getInitNum <em>Init Num</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_PopulateImpl#getEnt <em>Ent</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_PopulateImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CASL_Macro_PopulateImpl extends CASL_MacroImpl implements CASL_Macro_Populate
{
  /**
   * The cached value of the '{@link #getInitNum() <em>Init Num</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitNum()
   * @generated
   * @ordered
   */
  protected Expression initNum;

  /**
   * The cached value of the '{@link #getEnt() <em>Ent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnt()
   * @generated
   * @ordered
   */
  protected Entity ent;

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
  protected CASL_Macro_PopulateImpl()
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
    return CaslPackage.eINSTANCE.getCASL_Macro_Populate();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getInitNum()
  {
    return initNum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitNum(Expression newInitNum, NotificationChain msgs)
  {
    Expression oldInitNum = initNum;
    initNum = newInitNum;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_POPULATE__INIT_NUM, oldInitNum, newInitNum);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitNum(Expression newInitNum)
  {
    if (newInitNum != initNum)
    {
      NotificationChain msgs = null;
      if (initNum != null)
        msgs = ((InternalEObject)initNum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.CASL_MACRO_POPULATE__INIT_NUM, null, msgs);
      if (newInitNum != null)
        msgs = ((InternalEObject)newInitNum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.CASL_MACRO_POPULATE__INIT_NUM, null, msgs);
      msgs = basicSetInitNum(newInitNum, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_POPULATE__INIT_NUM, newInitNum, newInitNum));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity getEnt()
  {
    if (ent != null && ent.eIsProxy())
    {
      InternalEObject oldEnt = (InternalEObject)ent;
      ent = (Entity)eResolveProxy(oldEnt);
      if (ent != oldEnt)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.CASL_MACRO_POPULATE__ENT, oldEnt, ent));
      }
    }
    return ent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity basicGetEnt()
  {
    return ent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnt(Entity newEnt)
  {
    Entity oldEnt = ent;
    ent = newEnt;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_POPULATE__ENT, oldEnt, ent));
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
      body = new EObjectContainmentEList<EObject>(EObject.class, this, CaslPackage.CASL_MACRO_POPULATE__BODY);
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
      case CaslPackage.CASL_MACRO_POPULATE__INIT_NUM:
        return basicSetInitNum(null, msgs);
      case CaslPackage.CASL_MACRO_POPULATE__BODY:
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
      case CaslPackage.CASL_MACRO_POPULATE__INIT_NUM:
        return getInitNum();
      case CaslPackage.CASL_MACRO_POPULATE__ENT:
        if (resolve) return getEnt();
        return basicGetEnt();
      case CaslPackage.CASL_MACRO_POPULATE__BODY:
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
      case CaslPackage.CASL_MACRO_POPULATE__INIT_NUM:
        setInitNum((Expression)newValue);
        return;
      case CaslPackage.CASL_MACRO_POPULATE__ENT:
        setEnt((Entity)newValue);
        return;
      case CaslPackage.CASL_MACRO_POPULATE__BODY:
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
      case CaslPackage.CASL_MACRO_POPULATE__INIT_NUM:
        setInitNum((Expression)null);
        return;
      case CaslPackage.CASL_MACRO_POPULATE__ENT:
        setEnt((Entity)null);
        return;
      case CaslPackage.CASL_MACRO_POPULATE__BODY:
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
      case CaslPackage.CASL_MACRO_POPULATE__INIT_NUM:
        return initNum != null;
      case CaslPackage.CASL_MACRO_POPULATE__ENT:
        return ent != null;
      case CaslPackage.CASL_MACRO_POPULATE__BODY:
        return body != null && !body.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CASL_Macro_PopulateImpl