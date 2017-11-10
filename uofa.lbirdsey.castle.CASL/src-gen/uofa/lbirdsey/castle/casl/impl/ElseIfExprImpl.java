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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.ElseIfExpr;
import uofa.lbirdsey.castle.casl.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Else If Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.ElseIfExprImpl#getElseifCond <em>Elseif Cond</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.ElseIfExprImpl#getElseifthen <em>Elseifthen</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElseIfExprImpl extends MinimalEObjectImpl.Container implements ElseIfExpr
{
  /**
   * The cached value of the '{@link #getElseifCond() <em>Elseif Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseifCond()
   * @generated
   * @ordered
   */
  protected Expression elseifCond;

  /**
   * The cached value of the '{@link #getElseifthen() <em>Elseifthen</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseifthen()
   * @generated
   * @ordered
   */
  protected EList<EObject> elseifthen;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElseIfExprImpl()
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
    return CaslPackage.eINSTANCE.getElseIfExpr();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getElseifCond()
  {
    return elseifCond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseifCond(Expression newElseifCond, NotificationChain msgs)
  {
    Expression oldElseifCond = elseifCond;
    elseifCond = newElseifCond;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.ELSE_IF_EXPR__ELSEIF_COND, oldElseifCond, newElseifCond);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElseifCond(Expression newElseifCond)
  {
    if (newElseifCond != elseifCond)
    {
      NotificationChain msgs = null;
      if (elseifCond != null)
        msgs = ((InternalEObject)elseifCond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.ELSE_IF_EXPR__ELSEIF_COND, null, msgs);
      if (newElseifCond != null)
        msgs = ((InternalEObject)newElseifCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.ELSE_IF_EXPR__ELSEIF_COND, null, msgs);
      msgs = basicSetElseifCond(newElseifCond, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ELSE_IF_EXPR__ELSEIF_COND, newElseifCond, newElseifCond));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getElseifthen()
  {
    if (elseifthen == null)
    {
      elseifthen = new EObjectContainmentEList<EObject>(EObject.class, this, CaslPackage.ELSE_IF_EXPR__ELSEIFTHEN);
    }
    return elseifthen;
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
      case CaslPackage.ELSE_IF_EXPR__ELSEIF_COND:
        return basicSetElseifCond(null, msgs);
      case CaslPackage.ELSE_IF_EXPR__ELSEIFTHEN:
        return ((InternalEList<?>)getElseifthen()).basicRemove(otherEnd, msgs);
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
      case CaslPackage.ELSE_IF_EXPR__ELSEIF_COND:
        return getElseifCond();
      case CaslPackage.ELSE_IF_EXPR__ELSEIFTHEN:
        return getElseifthen();
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
      case CaslPackage.ELSE_IF_EXPR__ELSEIF_COND:
        setElseifCond((Expression)newValue);
        return;
      case CaslPackage.ELSE_IF_EXPR__ELSEIFTHEN:
        getElseifthen().clear();
        getElseifthen().addAll((Collection<? extends EObject>)newValue);
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
      case CaslPackage.ELSE_IF_EXPR__ELSEIF_COND:
        setElseifCond((Expression)null);
        return;
      case CaslPackage.ELSE_IF_EXPR__ELSEIFTHEN:
        getElseifthen().clear();
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
      case CaslPackage.ELSE_IF_EXPR__ELSEIF_COND:
        return elseifCond != null;
      case CaslPackage.ELSE_IF_EXPR__ELSEIFTHEN:
        return elseifthen != null && !elseifthen.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ElseIfExprImpl
