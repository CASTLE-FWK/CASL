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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uofa.lbirdsey.castle.casl.Agent;
import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.DataTypeDeclaration;
import uofa.lbirdsey.castle.casl.Environment;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.Group;
import uofa.lbirdsey.castle.casl.NonPrimitiveType;
import uofa.lbirdsey.castle.casl.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.DataTypeDeclarationImpl#getInitInclude <em>Init Include</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.DataTypeDeclarationImpl#getType <em>Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.DataTypeDeclarationImpl#getObj <em>Obj</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.DataTypeDeclarationImpl#getUseGroup <em>Use Group</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.DataTypeDeclarationImpl#getUseAgent <em>Use Agent</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.DataTypeDeclarationImpl#getUseEnv <em>Use Env</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.DataTypeDeclarationImpl#getUseObj <em>Use Obj</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.DataTypeDeclarationImpl#getUseType <em>Use Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.DataTypeDeclarationImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataTypeDeclarationImpl extends SymbolImpl implements DataTypeDeclaration
{
  /**
   * The default value of the '{@link #getInitInclude() <em>Init Include</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitInclude()
   * @generated
   * @ordered
   */
  protected static final String INIT_INCLUDE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInitInclude() <em>Init Include</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitInclude()
   * @generated
   * @ordered
   */
  protected String initInclude = INIT_INCLUDE_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected PrimitiveType type;

  /**
   * The cached value of the '{@link #getObj() <em>Obj</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObj()
   * @generated
   * @ordered
   */
  protected NonPrimitiveType obj;

  /**
   * The cached value of the '{@link #getUseGroup() <em>Use Group</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseGroup()
   * @generated
   * @ordered
   */
  protected EList<Group> useGroup;

  /**
   * The cached value of the '{@link #getUseAgent() <em>Use Agent</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseAgent()
   * @generated
   * @ordered
   */
  protected EList<Agent> useAgent;

  /**
   * The cached value of the '{@link #getUseEnv() <em>Use Env</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseEnv()
   * @generated
   * @ordered
   */
  protected EList<Environment> useEnv;

  /**
   * The cached value of the '{@link #getUseObj() <em>Use Obj</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseObj()
   * @generated
   * @ordered
   */
  protected EList<NonPrimitiveType> useObj;

  /**
   * The cached value of the '{@link #getUseType() <em>Use Type</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseType()
   * @generated
   * @ordered
   */
  protected EList<PrimitiveType> useType;

  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected Expression expr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataTypeDeclarationImpl()
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
    return CaslPackage.eINSTANCE.getDataTypeDeclaration();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInitInclude()
  {
    return initInclude;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitInclude(String newInitInclude)
  {
    String oldInitInclude = initInclude;
    initInclude = newInitInclude;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.DATA_TYPE_DECLARATION__INIT_INCLUDE, oldInitInclude, initInclude));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(PrimitiveType newType, NotificationChain msgs)
  {
    PrimitiveType oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.DATA_TYPE_DECLARATION__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(PrimitiveType newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.DATA_TYPE_DECLARATION__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.DATA_TYPE_DECLARATION__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.DATA_TYPE_DECLARATION__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonPrimitiveType getObj()
  {
    if (obj != null && obj.eIsProxy())
    {
      InternalEObject oldObj = (InternalEObject)obj;
      obj = (NonPrimitiveType)eResolveProxy(oldObj);
      if (obj != oldObj)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.DATA_TYPE_DECLARATION__OBJ, oldObj, obj));
      }
    }
    return obj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonPrimitiveType basicGetObj()
  {
    return obj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObj(NonPrimitiveType newObj)
  {
    NonPrimitiveType oldObj = obj;
    obj = newObj;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.DATA_TYPE_DECLARATION__OBJ, oldObj, obj));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Group> getUseGroup()
  {
    if (useGroup == null)
    {
      useGroup = new EObjectResolvingEList<Group>(Group.class, this, CaslPackage.DATA_TYPE_DECLARATION__USE_GROUP);
    }
    return useGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Agent> getUseAgent()
  {
    if (useAgent == null)
    {
      useAgent = new EObjectResolvingEList<Agent>(Agent.class, this, CaslPackage.DATA_TYPE_DECLARATION__USE_AGENT);
    }
    return useAgent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Environment> getUseEnv()
  {
    if (useEnv == null)
    {
      useEnv = new EObjectResolvingEList<Environment>(Environment.class, this, CaslPackage.DATA_TYPE_DECLARATION__USE_ENV);
    }
    return useEnv;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NonPrimitiveType> getUseObj()
  {
    if (useObj == null)
    {
      useObj = new EObjectResolvingEList<NonPrimitiveType>(NonPrimitiveType.class, this, CaslPackage.DATA_TYPE_DECLARATION__USE_OBJ);
    }
    return useObj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PrimitiveType> getUseType()
  {
    if (useType == null)
    {
      useType = new EObjectContainmentEList<PrimitiveType>(PrimitiveType.class, this, CaslPackage.DATA_TYPE_DECLARATION__USE_TYPE);
    }
    return useType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpr()
  {
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpr(Expression newExpr, NotificationChain msgs)
  {
    Expression oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.DATA_TYPE_DECLARATION__EXPR, oldExpr, newExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpr(Expression newExpr)
  {
    if (newExpr != expr)
    {
      NotificationChain msgs = null;
      if (expr != null)
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.DATA_TYPE_DECLARATION__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.DATA_TYPE_DECLARATION__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.DATA_TYPE_DECLARATION__EXPR, newExpr, newExpr));
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
      case CaslPackage.DATA_TYPE_DECLARATION__TYPE:
        return basicSetType(null, msgs);
      case CaslPackage.DATA_TYPE_DECLARATION__USE_TYPE:
        return ((InternalEList<?>)getUseType()).basicRemove(otherEnd, msgs);
      case CaslPackage.DATA_TYPE_DECLARATION__EXPR:
        return basicSetExpr(null, msgs);
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
      case CaslPackage.DATA_TYPE_DECLARATION__INIT_INCLUDE:
        return getInitInclude();
      case CaslPackage.DATA_TYPE_DECLARATION__TYPE:
        return getType();
      case CaslPackage.DATA_TYPE_DECLARATION__OBJ:
        if (resolve) return getObj();
        return basicGetObj();
      case CaslPackage.DATA_TYPE_DECLARATION__USE_GROUP:
        return getUseGroup();
      case CaslPackage.DATA_TYPE_DECLARATION__USE_AGENT:
        return getUseAgent();
      case CaslPackage.DATA_TYPE_DECLARATION__USE_ENV:
        return getUseEnv();
      case CaslPackage.DATA_TYPE_DECLARATION__USE_OBJ:
        return getUseObj();
      case CaslPackage.DATA_TYPE_DECLARATION__USE_TYPE:
        return getUseType();
      case CaslPackage.DATA_TYPE_DECLARATION__EXPR:
        return getExpr();
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
      case CaslPackage.DATA_TYPE_DECLARATION__INIT_INCLUDE:
        setInitInclude((String)newValue);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__TYPE:
        setType((PrimitiveType)newValue);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__OBJ:
        setObj((NonPrimitiveType)newValue);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_GROUP:
        getUseGroup().clear();
        getUseGroup().addAll((Collection<? extends Group>)newValue);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_AGENT:
        getUseAgent().clear();
        getUseAgent().addAll((Collection<? extends Agent>)newValue);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_ENV:
        getUseEnv().clear();
        getUseEnv().addAll((Collection<? extends Environment>)newValue);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_OBJ:
        getUseObj().clear();
        getUseObj().addAll((Collection<? extends NonPrimitiveType>)newValue);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_TYPE:
        getUseType().clear();
        getUseType().addAll((Collection<? extends PrimitiveType>)newValue);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__EXPR:
        setExpr((Expression)newValue);
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
      case CaslPackage.DATA_TYPE_DECLARATION__INIT_INCLUDE:
        setInitInclude(INIT_INCLUDE_EDEFAULT);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__TYPE:
        setType((PrimitiveType)null);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__OBJ:
        setObj((NonPrimitiveType)null);
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_GROUP:
        getUseGroup().clear();
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_AGENT:
        getUseAgent().clear();
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_ENV:
        getUseEnv().clear();
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_OBJ:
        getUseObj().clear();
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_TYPE:
        getUseType().clear();
        return;
      case CaslPackage.DATA_TYPE_DECLARATION__EXPR:
        setExpr((Expression)null);
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
      case CaslPackage.DATA_TYPE_DECLARATION__INIT_INCLUDE:
        return INIT_INCLUDE_EDEFAULT == null ? initInclude != null : !INIT_INCLUDE_EDEFAULT.equals(initInclude);
      case CaslPackage.DATA_TYPE_DECLARATION__TYPE:
        return type != null;
      case CaslPackage.DATA_TYPE_DECLARATION__OBJ:
        return obj != null;
      case CaslPackage.DATA_TYPE_DECLARATION__USE_GROUP:
        return useGroup != null && !useGroup.isEmpty();
      case CaslPackage.DATA_TYPE_DECLARATION__USE_AGENT:
        return useAgent != null && !useAgent.isEmpty();
      case CaslPackage.DATA_TYPE_DECLARATION__USE_ENV:
        return useEnv != null && !useEnv.isEmpty();
      case CaslPackage.DATA_TYPE_DECLARATION__USE_OBJ:
        return useObj != null && !useObj.isEmpty();
      case CaslPackage.DATA_TYPE_DECLARATION__USE_TYPE:
        return useType != null && !useType.isEmpty();
      case CaslPackage.DATA_TYPE_DECLARATION__EXPR:
        return expr != null;
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
    result.append(" (initInclude: ");
    result.append(initInclude);
    result.append(')');
    return result.toString();
  }

} //DataTypeDeclarationImpl
