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
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.GroupExternalInteraction;
import uofa.lbirdsey.castle.casl.Symbol;
import uofa.lbirdsey.castle.casl.Transmission_Contents;
import uofa.lbirdsey.castle.casl.Transmission_Phase;
import uofa.lbirdsey.castle.casl.Transmission_Repeat;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group External Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupExternalInteractionImpl#getName <em>Name</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupExternalInteractionImpl#getTransmissionPhase <em>Transmission Phase</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupExternalInteractionImpl#getTransmissionContents <em>Transmission Contents</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupExternalInteractionImpl#getTransmissionRepeat <em>Transmission Repeat</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupExternalInteractionImpl#getReaction_time_parm <em>Reaction time parm</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupExternalInteractionImpl#getFunctionParameters <em>Function Parameters</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupExternalInteractionImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupExternalInteractionImpl extends Entity_FeatureImpl implements GroupExternalInteraction
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
   * The default value of the '{@link #getTransmissionPhase() <em>Transmission Phase</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransmissionPhase()
   * @generated
   * @ordered
   */
  protected static final Transmission_Phase TRANSMISSION_PHASE_EDEFAULT = Transmission_Phase.SETUP;

  /**
   * The cached value of the '{@link #getTransmissionPhase() <em>Transmission Phase</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransmissionPhase()
   * @generated
   * @ordered
   */
  protected Transmission_Phase transmissionPhase = TRANSMISSION_PHASE_EDEFAULT;

  /**
   * The default value of the '{@link #getTransmissionContents() <em>Transmission Contents</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransmissionContents()
   * @generated
   * @ordered
   */
  protected static final Transmission_Contents TRANSMISSION_CONTENTS_EDEFAULT = Transmission_Contents.STATE;

  /**
   * The cached value of the '{@link #getTransmissionContents() <em>Transmission Contents</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransmissionContents()
   * @generated
   * @ordered
   */
  protected Transmission_Contents transmissionContents = TRANSMISSION_CONTENTS_EDEFAULT;

  /**
   * The default value of the '{@link #getTransmissionRepeat() <em>Transmission Repeat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransmissionRepeat()
   * @generated
   * @ordered
   */
  protected static final Transmission_Repeat TRANSMISSION_REPEAT_EDEFAULT = Transmission_Repeat.REPEAT;

  /**
   * The cached value of the '{@link #getTransmissionRepeat() <em>Transmission Repeat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransmissionRepeat()
   * @generated
   * @ordered
   */
  protected Transmission_Repeat transmissionRepeat = TRANSMISSION_REPEAT_EDEFAULT;

  /**
   * The cached value of the '{@link #getReaction_time_parm() <em>Reaction time parm</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReaction_time_parm()
   * @generated
   * @ordered
   */
  protected Expression reaction_time_parm;

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
  protected GroupExternalInteractionImpl()
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
    return CaslPackage.eINSTANCE.getGroupExternalInteraction();
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
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_EXTERNAL_INTERACTION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transmission_Phase getTransmissionPhase()
  {
    return transmissionPhase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransmissionPhase(Transmission_Phase newTransmissionPhase)
  {
    Transmission_Phase oldTransmissionPhase = transmissionPhase;
    transmissionPhase = newTransmissionPhase == null ? TRANSMISSION_PHASE_EDEFAULT : newTransmissionPhase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_PHASE, oldTransmissionPhase, transmissionPhase));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transmission_Contents getTransmissionContents()
  {
    return transmissionContents;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransmissionContents(Transmission_Contents newTransmissionContents)
  {
    Transmission_Contents oldTransmissionContents = transmissionContents;
    transmissionContents = newTransmissionContents == null ? TRANSMISSION_CONTENTS_EDEFAULT : newTransmissionContents;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_CONTENTS, oldTransmissionContents, transmissionContents));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transmission_Repeat getTransmissionRepeat()
  {
    return transmissionRepeat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransmissionRepeat(Transmission_Repeat newTransmissionRepeat)
  {
    Transmission_Repeat oldTransmissionRepeat = transmissionRepeat;
    transmissionRepeat = newTransmissionRepeat == null ? TRANSMISSION_REPEAT_EDEFAULT : newTransmissionRepeat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_REPEAT, oldTransmissionRepeat, transmissionRepeat));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getReaction_time_parm()
  {
    return reaction_time_parm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReaction_time_parm(Expression newReaction_time_parm, NotificationChain msgs)
  {
    Expression oldReaction_time_parm = reaction_time_parm;
    reaction_time_parm = newReaction_time_parm;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_EXTERNAL_INTERACTION__REACTION_TIME_PARM, oldReaction_time_parm, newReaction_time_parm);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReaction_time_parm(Expression newReaction_time_parm)
  {
    if (newReaction_time_parm != reaction_time_parm)
    {
      NotificationChain msgs = null;
      if (reaction_time_parm != null)
        msgs = ((InternalEObject)reaction_time_parm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.GROUP_EXTERNAL_INTERACTION__REACTION_TIME_PARM, null, msgs);
      if (newReaction_time_parm != null)
        msgs = ((InternalEObject)newReaction_time_parm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.GROUP_EXTERNAL_INTERACTION__REACTION_TIME_PARM, null, msgs);
      msgs = basicSetReaction_time_parm(newReaction_time_parm, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_EXTERNAL_INTERACTION__REACTION_TIME_PARM, newReaction_time_parm, newReaction_time_parm));
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
      functionParameters = new EObjectContainmentEList<Symbol>(Symbol.class, this, CaslPackage.GROUP_EXTERNAL_INTERACTION__FUNCTION_PARAMETERS);
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
      body = new EObjectContainmentEList<EObject>(EObject.class, this, CaslPackage.GROUP_EXTERNAL_INTERACTION__BODY);
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
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__REACTION_TIME_PARM:
        return basicSetReaction_time_parm(null, msgs);
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__FUNCTION_PARAMETERS:
        return ((InternalEList<?>)getFunctionParameters()).basicRemove(otherEnd, msgs);
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__BODY:
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
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__NAME:
        return getName();
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_PHASE:
        return getTransmissionPhase();
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_CONTENTS:
        return getTransmissionContents();
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_REPEAT:
        return getTransmissionRepeat();
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__REACTION_TIME_PARM:
        return getReaction_time_parm();
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__FUNCTION_PARAMETERS:
        return getFunctionParameters();
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__BODY:
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
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__NAME:
        setName((String)newValue);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_PHASE:
        setTransmissionPhase((Transmission_Phase)newValue);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_CONTENTS:
        setTransmissionContents((Transmission_Contents)newValue);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_REPEAT:
        setTransmissionRepeat((Transmission_Repeat)newValue);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__REACTION_TIME_PARM:
        setReaction_time_parm((Expression)newValue);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__FUNCTION_PARAMETERS:
        getFunctionParameters().clear();
        getFunctionParameters().addAll((Collection<? extends Symbol>)newValue);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__BODY:
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
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_PHASE:
        setTransmissionPhase(TRANSMISSION_PHASE_EDEFAULT);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_CONTENTS:
        setTransmissionContents(TRANSMISSION_CONTENTS_EDEFAULT);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_REPEAT:
        setTransmissionRepeat(TRANSMISSION_REPEAT_EDEFAULT);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__REACTION_TIME_PARM:
        setReaction_time_parm((Expression)null);
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__FUNCTION_PARAMETERS:
        getFunctionParameters().clear();
        return;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__BODY:
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
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_PHASE:
        return transmissionPhase != TRANSMISSION_PHASE_EDEFAULT;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_CONTENTS:
        return transmissionContents != TRANSMISSION_CONTENTS_EDEFAULT;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__TRANSMISSION_REPEAT:
        return transmissionRepeat != TRANSMISSION_REPEAT_EDEFAULT;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__REACTION_TIME_PARM:
        return reaction_time_parm != null;
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__FUNCTION_PARAMETERS:
        return functionParameters != null && !functionParameters.isEmpty();
      case CaslPackage.GROUP_EXTERNAL_INTERACTION__BODY:
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
    result.append(", transmissionPhase: ");
    result.append(transmissionPhase);
    result.append(", transmissionContents: ");
    result.append(transmissionContents);
    result.append(", transmissionRepeat: ");
    result.append(transmissionRepeat);
    result.append(')');
    return result.toString();
  }

} //GroupExternalInteractionImpl