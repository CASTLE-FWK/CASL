/**
 * generated by Xtext 2.11.0
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
import uofa.lbirdsey.castle.casl.ElseIfExpr;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.IfStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.IfStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.IfStatementImpl#getThen <em>Then</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.IfStatementImpl#getElseifexpr <em>Elseifexpr</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.IfStatementImpl#getElseexp <em>Elseexp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfStatementImpl extends ExpressionImpl implements IfStatement
{
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
   * The cached value of the '{@link #getThen() <em>Then</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThen()
   * @generated
   * @ordered
   */
  protected EList<EObject> then;

  /**
   * The cached value of the '{@link #getElseifexpr() <em>Elseifexpr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseifexpr()
   * @generated
   * @ordered
   */
  protected EList<ElseIfExpr> elseifexpr;

  /**
   * The cached value of the '{@link #getElseexp() <em>Elseexp</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseexp()
   * @generated
   * @ordered
   */
  protected EList<EObject> elseexp;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfStatementImpl()
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
    return CaslPackage.eINSTANCE.getIfStatement();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.IF_STATEMENT__CONDITION, oldCondition, newCondition);
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
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.IF_STATEMENT__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.IF_STATEMENT__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.IF_STATEMENT__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getThen()
  {
    if (then == null)
    {
      then = new EObjectContainmentEList<EObject>(EObject.class, this, CaslPackage.IF_STATEMENT__THEN);
    }
    return then;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ElseIfExpr> getElseifexpr()
  {
    if (elseifexpr == null)
    {
      elseifexpr = new EObjectContainmentEList<ElseIfExpr>(ElseIfExpr.class, this, CaslPackage.IF_STATEMENT__ELSEIFEXPR);
    }
    return elseifexpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getElseexp()
  {
    if (elseexp == null)
    {
      elseexp = new EObjectContainmentEList<EObject>(EObject.class, this, CaslPackage.IF_STATEMENT__ELSEEXP);
    }
    return elseexp;
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
      case CaslPackage.IF_STATEMENT__CONDITION:
        return basicSetCondition(null, msgs);
      case CaslPackage.IF_STATEMENT__THEN:
        return ((InternalEList<?>)getThen()).basicRemove(otherEnd, msgs);
      case CaslPackage.IF_STATEMENT__ELSEIFEXPR:
        return ((InternalEList<?>)getElseifexpr()).basicRemove(otherEnd, msgs);
      case CaslPackage.IF_STATEMENT__ELSEEXP:
        return ((InternalEList<?>)getElseexp()).basicRemove(otherEnd, msgs);
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
      case CaslPackage.IF_STATEMENT__CONDITION:
        return getCondition();
      case CaslPackage.IF_STATEMENT__THEN:
        return getThen();
      case CaslPackage.IF_STATEMENT__ELSEIFEXPR:
        return getElseifexpr();
      case CaslPackage.IF_STATEMENT__ELSEEXP:
        return getElseexp();
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
      case CaslPackage.IF_STATEMENT__CONDITION:
        setCondition((Expression)newValue);
        return;
      case CaslPackage.IF_STATEMENT__THEN:
        getThen().clear();
        getThen().addAll((Collection<? extends EObject>)newValue);
        return;
      case CaslPackage.IF_STATEMENT__ELSEIFEXPR:
        getElseifexpr().clear();
        getElseifexpr().addAll((Collection<? extends ElseIfExpr>)newValue);
        return;
      case CaslPackage.IF_STATEMENT__ELSEEXP:
        getElseexp().clear();
        getElseexp().addAll((Collection<? extends EObject>)newValue);
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
      case CaslPackage.IF_STATEMENT__CONDITION:
        setCondition((Expression)null);
        return;
      case CaslPackage.IF_STATEMENT__THEN:
        getThen().clear();
        return;
      case CaslPackage.IF_STATEMENT__ELSEIFEXPR:
        getElseifexpr().clear();
        return;
      case CaslPackage.IF_STATEMENT__ELSEEXP:
        getElseexp().clear();
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
      case CaslPackage.IF_STATEMENT__CONDITION:
        return condition != null;
      case CaslPackage.IF_STATEMENT__THEN:
        return then != null && !then.isEmpty();
      case CaslPackage.IF_STATEMENT__ELSEIFEXPR:
        return elseifexpr != null && !elseifexpr.isEmpty();
      case CaslPackage.IF_STATEMENT__ELSEEXP:
        return elseexp != null && !elseexp.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IfStatementImpl