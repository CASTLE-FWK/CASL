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
import uofa.lbirdsey.castle.casl.GroupInternalInteraction;
import uofa.lbirdsey.castle.casl.InteractionTriggerParameter;
import uofa.lbirdsey.castle.casl.InteractionTriggerTypes;
import uofa.lbirdsey.castle.casl.InteractionType;
import uofa.lbirdsey.castle.casl.Symbol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Internal Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupInternalInteractionImpl#getName <em>Name</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupInternalInteractionImpl#getInteraction_type <em>Interaction type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupInternalInteractionImpl#getTrigger_type <em>Trigger type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupInternalInteractionImpl#getTriggerParam <em>Trigger Param</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupInternalInteractionImpl#getFunctionParameters <em>Function Parameters</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupInternalInteractionImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupInternalInteractionImpl extends Entity_FeatureImpl implements GroupInternalInteraction
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getInteraction_type() <em>Interaction type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInteraction_type()
   * @generated
   * @ordered
   */
  protected static final InteractionType INTERACTION_TYPE_EDEFAULT = InteractionType.QUERY;

  /**
   * The cached value of the '{@link #getInteraction_type() <em>Interaction type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInteraction_type()
   * @generated
   * @ordered
   */
  protected InteractionType interaction_type = INTERACTION_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getTrigger_type() <em>Trigger type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrigger_type()
   * @generated
   * @ordered
   */
  protected static final InteractionTriggerTypes TRIGGER_TYPE_EDEFAULT = InteractionTriggerTypes.STEP;

  /**
   * The cached value of the '{@link #getTrigger_type() <em>Trigger type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrigger_type()
   * @generated
   * @ordered
   */
  protected InteractionTriggerTypes trigger_type = TRIGGER_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTriggerParam() <em>Trigger Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerParam()
   * @generated
   * @ordered
   */
  protected InteractionTriggerParameter triggerParam;

  /**
   * The cached value of the '{@link #getFunctionParameters() <em>Function Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionParameters()
   * @generated
   * @ordered
   */
  protected EList<Symbol> functionParameters;

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
  protected GroupInternalInteractionImpl()
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
    return CaslPackage.eINSTANCE.getGroupInternalInteraction();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_INTERNAL_INTERACTION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InteractionType getInteraction_type()
  {
    return interaction_type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInteraction_type(InteractionType newInteraction_type)
  {
    InteractionType oldInteraction_type = interaction_type;
    interaction_type = newInteraction_type == null ? INTERACTION_TYPE_EDEFAULT : newInteraction_type;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_INTERNAL_INTERACTION__INTERACTION_TYPE, oldInteraction_type, interaction_type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InteractionTriggerTypes getTrigger_type()
  {
    return trigger_type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrigger_type(InteractionTriggerTypes newTrigger_type)
  {
    InteractionTriggerTypes oldTrigger_type = trigger_type;
    trigger_type = newTrigger_type == null ? TRIGGER_TYPE_EDEFAULT : newTrigger_type;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_TYPE, oldTrigger_type, trigger_type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InteractionTriggerParameter getTriggerParam()
  {
    return triggerParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTriggerParam(InteractionTriggerParameter newTriggerParam, NotificationChain msgs)
  {
    InteractionTriggerParameter oldTriggerParam = triggerParam;
    triggerParam = newTriggerParam;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_PARAM, oldTriggerParam, newTriggerParam);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTriggerParam(InteractionTriggerParameter newTriggerParam)
  {
    if (newTriggerParam != triggerParam)
    {
      NotificationChain msgs = null;
      if (triggerParam != null)
        msgs = ((InternalEObject)triggerParam).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_PARAM, null, msgs);
      if (newTriggerParam != null)
        msgs = ((InternalEObject)newTriggerParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_PARAM, null, msgs);
      msgs = basicSetTriggerParam(newTriggerParam, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_PARAM, newTriggerParam, newTriggerParam));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Symbol> getFunctionParameters()
  {
    if (functionParameters == null)
    {
      functionParameters = new EObjectContainmentEList<Symbol>(Symbol.class, this, CaslPackage.GROUP_INTERNAL_INTERACTION__FUNCTION_PARAMETERS);
    }
    return functionParameters;
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
      body = new EObjectContainmentEList<EObject>(EObject.class, this, CaslPackage.GROUP_INTERNAL_INTERACTION__BODY);
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
      case CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_PARAM:
        return basicSetTriggerParam(null, msgs);
      case CaslPackage.GROUP_INTERNAL_INTERACTION__FUNCTION_PARAMETERS:
        return ((InternalEList<?>)getFunctionParameters()).basicRemove(otherEnd, msgs);
      case CaslPackage.GROUP_INTERNAL_INTERACTION__BODY:
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
      case CaslPackage.GROUP_INTERNAL_INTERACTION__NAME:
        return getName();
      case CaslPackage.GROUP_INTERNAL_INTERACTION__INTERACTION_TYPE:
        return getInteraction_type();
      case CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_TYPE:
        return getTrigger_type();
      case CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_PARAM:
        return getTriggerParam();
      case CaslPackage.GROUP_INTERNAL_INTERACTION__FUNCTION_PARAMETERS:
        return getFunctionParameters();
      case CaslPackage.GROUP_INTERNAL_INTERACTION__BODY:
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
      case CaslPackage.GROUP_INTERNAL_INTERACTION__NAME:
        setName((String)newValue);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__INTERACTION_TYPE:
        setInteraction_type((InteractionType)newValue);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_TYPE:
        setTrigger_type((InteractionTriggerTypes)newValue);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_PARAM:
        setTriggerParam((InteractionTriggerParameter)newValue);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__FUNCTION_PARAMETERS:
        getFunctionParameters().clear();
        getFunctionParameters().addAll((Collection<? extends Symbol>)newValue);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__BODY:
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
      case CaslPackage.GROUP_INTERNAL_INTERACTION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__INTERACTION_TYPE:
        setInteraction_type(INTERACTION_TYPE_EDEFAULT);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_TYPE:
        setTrigger_type(TRIGGER_TYPE_EDEFAULT);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_PARAM:
        setTriggerParam((InteractionTriggerParameter)null);
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__FUNCTION_PARAMETERS:
        getFunctionParameters().clear();
        return;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__BODY:
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
      case CaslPackage.GROUP_INTERNAL_INTERACTION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CaslPackage.GROUP_INTERNAL_INTERACTION__INTERACTION_TYPE:
        return interaction_type != INTERACTION_TYPE_EDEFAULT;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_TYPE:
        return trigger_type != TRIGGER_TYPE_EDEFAULT;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__TRIGGER_PARAM:
        return triggerParam != null;
      case CaslPackage.GROUP_INTERNAL_INTERACTION__FUNCTION_PARAMETERS:
        return functionParameters != null && !functionParameters.isEmpty();
      case CaslPackage.GROUP_INTERNAL_INTERACTION__BODY:
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
    result.append(" (name: ");
    result.append(name);
    result.append(", interaction_type: ");
    result.append(interaction_type);
    result.append(", trigger_type: ");
    result.append(trigger_type);
    result.append(')');
    return result.toString();
  }

} //GroupInternalInteractionImpl
