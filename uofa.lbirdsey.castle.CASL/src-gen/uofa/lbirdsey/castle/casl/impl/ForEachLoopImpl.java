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

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.ForEachLoop;
import uofa.lbirdsey.castle.casl.Symbol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Each Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.ForEachLoopImpl#getTy <em>Ty</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.ForEachLoopImpl#getItem <em>Item</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.ForEachLoopImpl#getList <em>List</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.ForEachLoopImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForEachLoopImpl extends ExpressionImpl implements ForEachLoop
{
  /**
   * The default value of the '{@link #getTy() <em>Ty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTy()
   * @generated
   * @ordered
   */
  protected static final String TY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTy() <em>Ty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTy()
   * @generated
   * @ordered
   */
  protected String ty = TY_EDEFAULT;

  /**
   * The cached value of the '{@link #getItem() <em>Item</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getItem()
   * @generated
   * @ordered
   */
  protected Symbol item;

  /**
   * The cached value of the '{@link #getList() <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getList()
   * @generated
   * @ordered
   */
  protected Expression list;

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
  protected ForEachLoopImpl()
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
    return CaslPackage.eINSTANCE.getForEachLoop();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTy()
  {
    return ty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTy(String newTy)
  {
    String oldTy = ty;
    ty = newTy;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_EACH_LOOP__TY, oldTy, ty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Symbol getItem()
  {
    return item;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetItem(Symbol newItem, NotificationChain msgs)
  {
    Symbol oldItem = item;
    item = newItem;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_EACH_LOOP__ITEM, oldItem, newItem);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setItem(Symbol newItem)
  {
    if (newItem != item)
    {
      NotificationChain msgs = null;
      if (item != null)
        msgs = ((InternalEObject)item).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FOR_EACH_LOOP__ITEM, null, msgs);
      if (newItem != null)
        msgs = ((InternalEObject)newItem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FOR_EACH_LOOP__ITEM, null, msgs);
      msgs = basicSetItem(newItem, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_EACH_LOOP__ITEM, newItem, newItem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getList()
  {
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetList(Expression newList, NotificationChain msgs)
  {
    Expression oldList = list;
    list = newList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_EACH_LOOP__LIST, oldList, newList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setList(Expression newList)
  {
    if (newList != list)
    {
      NotificationChain msgs = null;
      if (list != null)
        msgs = ((InternalEObject)list).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FOR_EACH_LOOP__LIST, null, msgs);
      if (newList != null)
        msgs = ((InternalEObject)newList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FOR_EACH_LOOP__LIST, null, msgs);
      msgs = basicSetList(newList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FOR_EACH_LOOP__LIST, newList, newList));
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
      body = new EObjectContainmentEList<EObject>(EObject.class, this, CaslPackage.FOR_EACH_LOOP__BODY);
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
      case CaslPackage.FOR_EACH_LOOP__ITEM:
        return basicSetItem(null, msgs);
      case CaslPackage.FOR_EACH_LOOP__LIST:
        return basicSetList(null, msgs);
      case CaslPackage.FOR_EACH_LOOP__BODY:
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
      case CaslPackage.FOR_EACH_LOOP__TY:
        return getTy();
      case CaslPackage.FOR_EACH_LOOP__ITEM:
        return getItem();
      case CaslPackage.FOR_EACH_LOOP__LIST:
        return getList();
      case CaslPackage.FOR_EACH_LOOP__BODY:
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
      case CaslPackage.FOR_EACH_LOOP__TY:
        setTy((String)newValue);
        return;
      case CaslPackage.FOR_EACH_LOOP__ITEM:
        setItem((Symbol)newValue);
        return;
      case CaslPackage.FOR_EACH_LOOP__LIST:
        setList((Expression)newValue);
        return;
      case CaslPackage.FOR_EACH_LOOP__BODY:
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
      case CaslPackage.FOR_EACH_LOOP__TY:
        setTy(TY_EDEFAULT);
        return;
      case CaslPackage.FOR_EACH_LOOP__ITEM:
        setItem((Symbol)null);
        return;
      case CaslPackage.FOR_EACH_LOOP__LIST:
        setList((Expression)null);
        return;
      case CaslPackage.FOR_EACH_LOOP__BODY:
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
      case CaslPackage.FOR_EACH_LOOP__TY:
        return TY_EDEFAULT == null ? ty != null : !TY_EDEFAULT.equals(ty);
      case CaslPackage.FOR_EACH_LOOP__ITEM:
        return item != null;
      case CaslPackage.FOR_EACH_LOOP__LIST:
        return list != null;
      case CaslPackage.FOR_EACH_LOOP__BODY:
        return body != null && !body.isEmpty();
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
    result.append(" (ty: ");
    result.append(ty);
    result.append(')');
    return result.toString();
  }

} //ForEachLoopImpl
