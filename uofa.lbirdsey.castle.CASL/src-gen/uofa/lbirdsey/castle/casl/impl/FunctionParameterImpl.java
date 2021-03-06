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
import uofa.lbirdsey.castle.casl.Environment;
import uofa.lbirdsey.castle.casl.FunctionParameter;
import uofa.lbirdsey.castle.casl.Group;
import uofa.lbirdsey.castle.casl.NonPrimitiveType;
import uofa.lbirdsey.castle.casl.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionParameterImpl#getAgent <em>Agent</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionParameterImpl#getEnv <em>Env</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionParameterImpl#getGrp <em>Grp</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionParameterImpl#getObj <em>Obj</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionParameterImpl#getUseGroup <em>Use Group</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionParameterImpl#getUseAgent <em>Use Agent</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionParameterImpl#getUseEnv <em>Use Env</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionParameterImpl#getUseObj <em>Use Obj</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.FunctionParameterImpl#getUseType <em>Use Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionParameterImpl extends SymbolImpl implements FunctionParameter
{
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
   * The cached value of the '{@link #getAgent() <em>Agent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAgent()
   * @generated
   * @ordered
   */
  protected Agent agent;

  /**
   * The cached value of the '{@link #getEnv() <em>Env</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnv()
   * @generated
   * @ordered
   */
  protected Environment env;

  /**
   * The cached value of the '{@link #getGrp() <em>Grp</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGrp()
   * @generated
   * @ordered
   */
  protected Group grp;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionParameterImpl()
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
    return CaslPackage.eINSTANCE.getFunctionParameter();
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.FUNCTION_PARAMETER__TYPE, oldType, newType);
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
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FUNCTION_PARAMETER__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.FUNCTION_PARAMETER__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FUNCTION_PARAMETER__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Agent getAgent()
  {
    if (agent != null && agent.eIsProxy())
    {
      InternalEObject oldAgent = (InternalEObject)agent;
      agent = (Agent)eResolveProxy(oldAgent);
      if (agent != oldAgent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.FUNCTION_PARAMETER__AGENT, oldAgent, agent));
      }
    }
    return agent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Agent basicGetAgent()
  {
    return agent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAgent(Agent newAgent)
  {
    Agent oldAgent = agent;
    agent = newAgent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FUNCTION_PARAMETER__AGENT, oldAgent, agent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment getEnv()
  {
    if (env != null && env.eIsProxy())
    {
      InternalEObject oldEnv = (InternalEObject)env;
      env = (Environment)eResolveProxy(oldEnv);
      if (env != oldEnv)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.FUNCTION_PARAMETER__ENV, oldEnv, env));
      }
    }
    return env;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment basicGetEnv()
  {
    return env;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnv(Environment newEnv)
  {
    Environment oldEnv = env;
    env = newEnv;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FUNCTION_PARAMETER__ENV, oldEnv, env));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Group getGrp()
  {
    if (grp != null && grp.eIsProxy())
    {
      InternalEObject oldGrp = (InternalEObject)grp;
      grp = (Group)eResolveProxy(oldGrp);
      if (grp != oldGrp)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.FUNCTION_PARAMETER__GRP, oldGrp, grp));
      }
    }
    return grp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Group basicGetGrp()
  {
    return grp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGrp(Group newGrp)
  {
    Group oldGrp = grp;
    grp = newGrp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FUNCTION_PARAMETER__GRP, oldGrp, grp));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.FUNCTION_PARAMETER__OBJ, oldObj, obj));
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
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.FUNCTION_PARAMETER__OBJ, oldObj, obj));
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
      useGroup = new EObjectResolvingEList<Group>(Group.class, this, CaslPackage.FUNCTION_PARAMETER__USE_GROUP);
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
      useAgent = new EObjectResolvingEList<Agent>(Agent.class, this, CaslPackage.FUNCTION_PARAMETER__USE_AGENT);
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
      useEnv = new EObjectResolvingEList<Environment>(Environment.class, this, CaslPackage.FUNCTION_PARAMETER__USE_ENV);
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
      useObj = new EObjectResolvingEList<NonPrimitiveType>(NonPrimitiveType.class, this, CaslPackage.FUNCTION_PARAMETER__USE_OBJ);
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
      useType = new EObjectContainmentEList<PrimitiveType>(PrimitiveType.class, this, CaslPackage.FUNCTION_PARAMETER__USE_TYPE);
    }
    return useType;
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
      case CaslPackage.FUNCTION_PARAMETER__TYPE:
        return basicSetType(null, msgs);
      case CaslPackage.FUNCTION_PARAMETER__USE_TYPE:
        return ((InternalEList<?>)getUseType()).basicRemove(otherEnd, msgs);
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
      case CaslPackage.FUNCTION_PARAMETER__TYPE:
        return getType();
      case CaslPackage.FUNCTION_PARAMETER__AGENT:
        if (resolve) return getAgent();
        return basicGetAgent();
      case CaslPackage.FUNCTION_PARAMETER__ENV:
        if (resolve) return getEnv();
        return basicGetEnv();
      case CaslPackage.FUNCTION_PARAMETER__GRP:
        if (resolve) return getGrp();
        return basicGetGrp();
      case CaslPackage.FUNCTION_PARAMETER__OBJ:
        if (resolve) return getObj();
        return basicGetObj();
      case CaslPackage.FUNCTION_PARAMETER__USE_GROUP:
        return getUseGroup();
      case CaslPackage.FUNCTION_PARAMETER__USE_AGENT:
        return getUseAgent();
      case CaslPackage.FUNCTION_PARAMETER__USE_ENV:
        return getUseEnv();
      case CaslPackage.FUNCTION_PARAMETER__USE_OBJ:
        return getUseObj();
      case CaslPackage.FUNCTION_PARAMETER__USE_TYPE:
        return getUseType();
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
      case CaslPackage.FUNCTION_PARAMETER__TYPE:
        setType((PrimitiveType)newValue);
        return;
      case CaslPackage.FUNCTION_PARAMETER__AGENT:
        setAgent((Agent)newValue);
        return;
      case CaslPackage.FUNCTION_PARAMETER__ENV:
        setEnv((Environment)newValue);
        return;
      case CaslPackage.FUNCTION_PARAMETER__GRP:
        setGrp((Group)newValue);
        return;
      case CaslPackage.FUNCTION_PARAMETER__OBJ:
        setObj((NonPrimitiveType)newValue);
        return;
      case CaslPackage.FUNCTION_PARAMETER__USE_GROUP:
        getUseGroup().clear();
        getUseGroup().addAll((Collection<? extends Group>)newValue);
        return;
      case CaslPackage.FUNCTION_PARAMETER__USE_AGENT:
        getUseAgent().clear();
        getUseAgent().addAll((Collection<? extends Agent>)newValue);
        return;
      case CaslPackage.FUNCTION_PARAMETER__USE_ENV:
        getUseEnv().clear();
        getUseEnv().addAll((Collection<? extends Environment>)newValue);
        return;
      case CaslPackage.FUNCTION_PARAMETER__USE_OBJ:
        getUseObj().clear();
        getUseObj().addAll((Collection<? extends NonPrimitiveType>)newValue);
        return;
      case CaslPackage.FUNCTION_PARAMETER__USE_TYPE:
        getUseType().clear();
        getUseType().addAll((Collection<? extends PrimitiveType>)newValue);
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
      case CaslPackage.FUNCTION_PARAMETER__TYPE:
        setType((PrimitiveType)null);
        return;
      case CaslPackage.FUNCTION_PARAMETER__AGENT:
        setAgent((Agent)null);
        return;
      case CaslPackage.FUNCTION_PARAMETER__ENV:
        setEnv((Environment)null);
        return;
      case CaslPackage.FUNCTION_PARAMETER__GRP:
        setGrp((Group)null);
        return;
      case CaslPackage.FUNCTION_PARAMETER__OBJ:
        setObj((NonPrimitiveType)null);
        return;
      case CaslPackage.FUNCTION_PARAMETER__USE_GROUP:
        getUseGroup().clear();
        return;
      case CaslPackage.FUNCTION_PARAMETER__USE_AGENT:
        getUseAgent().clear();
        return;
      case CaslPackage.FUNCTION_PARAMETER__USE_ENV:
        getUseEnv().clear();
        return;
      case CaslPackage.FUNCTION_PARAMETER__USE_OBJ:
        getUseObj().clear();
        return;
      case CaslPackage.FUNCTION_PARAMETER__USE_TYPE:
        getUseType().clear();
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
      case CaslPackage.FUNCTION_PARAMETER__TYPE:
        return type != null;
      case CaslPackage.FUNCTION_PARAMETER__AGENT:
        return agent != null;
      case CaslPackage.FUNCTION_PARAMETER__ENV:
        return env != null;
      case CaslPackage.FUNCTION_PARAMETER__GRP:
        return grp != null;
      case CaslPackage.FUNCTION_PARAMETER__OBJ:
        return obj != null;
      case CaslPackage.FUNCTION_PARAMETER__USE_GROUP:
        return useGroup != null && !useGroup.isEmpty();
      case CaslPackage.FUNCTION_PARAMETER__USE_AGENT:
        return useAgent != null && !useAgent.isEmpty();
      case CaslPackage.FUNCTION_PARAMETER__USE_ENV:
        return useEnv != null && !useEnv.isEmpty();
      case CaslPackage.FUNCTION_PARAMETER__USE_OBJ:
        return useObj != null && !useObj.isEmpty();
      case CaslPackage.FUNCTION_PARAMETER__USE_TYPE:
        return useType != null && !useType.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunctionParameterImpl
