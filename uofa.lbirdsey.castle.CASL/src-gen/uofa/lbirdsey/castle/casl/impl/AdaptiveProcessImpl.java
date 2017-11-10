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

import uofa.lbirdsey.castle.casl.AdaptationDelay;
import uofa.lbirdsey.castle.casl.AdaptationType;
import uofa.lbirdsey.castle.casl.AdaptiveProcess;
import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Symbol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adaptive Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.AdaptiveProcessImpl#getName <em>Name</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.AdaptiveProcessImpl#getAdaptation_type <em>Adaptation type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.AdaptiveProcessImpl#getAdaptationDelay <em>Adaptation Delay</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.AdaptiveProcessImpl#getFunctionParameters <em>Function Parameters</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.AdaptiveProcessImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdaptiveProcessImpl extends Entity_FeatureImpl implements AdaptiveProcess
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
   * The default value of the '{@link #getAdaptation_type() <em>Adaptation type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdaptation_type()
   * @generated
   * @ordered
   */
  protected static final AdaptationType ADAPTATION_TYPE_EDEFAULT = AdaptationType.IMPLICIT;

  /**
   * The cached value of the '{@link #getAdaptation_type() <em>Adaptation type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdaptation_type()
   * @generated
   * @ordered
   */
  protected AdaptationType adaptation_type = ADAPTATION_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getAdaptationDelay() <em>Adaptation Delay</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdaptationDelay()
   * @generated
   * @ordered
   */
  protected static final AdaptationDelay ADAPTATION_DELAY_EDEFAULT = AdaptationDelay.NONE;

  /**
   * The cached value of the '{@link #getAdaptationDelay() <em>Adaptation Delay</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdaptationDelay()
   * @generated
   * @ordered
   */
  protected AdaptationDelay adaptationDelay = ADAPTATION_DELAY_EDEFAULT;

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
  protected AdaptiveProcessImpl()
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
    return CaslPackage.eINSTANCE.getAdaptiveProcess();
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
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ADAPTIVE_PROCESS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdaptationType getAdaptation_type()
  {
    return adaptation_type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdaptation_type(AdaptationType newAdaptation_type)
  {
    AdaptationType oldAdaptation_type = adaptation_type;
    adaptation_type = newAdaptation_type == null ? ADAPTATION_TYPE_EDEFAULT : newAdaptation_type;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ADAPTIVE_PROCESS__ADAPTATION_TYPE, oldAdaptation_type, adaptation_type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdaptationDelay getAdaptationDelay()
  {
    return adaptationDelay;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdaptationDelay(AdaptationDelay newAdaptationDelay)
  {
    AdaptationDelay oldAdaptationDelay = adaptationDelay;
    adaptationDelay = newAdaptationDelay == null ? ADAPTATION_DELAY_EDEFAULT : newAdaptationDelay;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ADAPTIVE_PROCESS__ADAPTATION_DELAY, oldAdaptationDelay, adaptationDelay));
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
      functionParameters = new EObjectContainmentEList<Symbol>(Symbol.class, this, CaslPackage.ADAPTIVE_PROCESS__FUNCTION_PARAMETERS);
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
      body = new EObjectContainmentEList<EObject>(EObject.class, this, CaslPackage.ADAPTIVE_PROCESS__BODY);
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
      case CaslPackage.ADAPTIVE_PROCESS__FUNCTION_PARAMETERS:
        return ((InternalEList<?>)getFunctionParameters()).basicRemove(otherEnd, msgs);
      case CaslPackage.ADAPTIVE_PROCESS__BODY:
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
      case CaslPackage.ADAPTIVE_PROCESS__NAME:
        return getName();
      case CaslPackage.ADAPTIVE_PROCESS__ADAPTATION_TYPE:
        return getAdaptation_type();
      case CaslPackage.ADAPTIVE_PROCESS__ADAPTATION_DELAY:
        return getAdaptationDelay();
      case CaslPackage.ADAPTIVE_PROCESS__FUNCTION_PARAMETERS:
        return getFunctionParameters();
      case CaslPackage.ADAPTIVE_PROCESS__BODY:
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
      case CaslPackage.ADAPTIVE_PROCESS__NAME:
        setName((String)newValue);
        return;
      case CaslPackage.ADAPTIVE_PROCESS__ADAPTATION_TYPE:
        setAdaptation_type((AdaptationType)newValue);
        return;
      case CaslPackage.ADAPTIVE_PROCESS__ADAPTATION_DELAY:
        setAdaptationDelay((AdaptationDelay)newValue);
        return;
      case CaslPackage.ADAPTIVE_PROCESS__FUNCTION_PARAMETERS:
        getFunctionParameters().clear();
        getFunctionParameters().addAll((Collection<? extends Symbol>)newValue);
        return;
      case CaslPackage.ADAPTIVE_PROCESS__BODY:
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
      case CaslPackage.ADAPTIVE_PROCESS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CaslPackage.ADAPTIVE_PROCESS__ADAPTATION_TYPE:
        setAdaptation_type(ADAPTATION_TYPE_EDEFAULT);
        return;
      case CaslPackage.ADAPTIVE_PROCESS__ADAPTATION_DELAY:
        setAdaptationDelay(ADAPTATION_DELAY_EDEFAULT);
        return;
      case CaslPackage.ADAPTIVE_PROCESS__FUNCTION_PARAMETERS:
        getFunctionParameters().clear();
        return;
      case CaslPackage.ADAPTIVE_PROCESS__BODY:
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
      case CaslPackage.ADAPTIVE_PROCESS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CaslPackage.ADAPTIVE_PROCESS__ADAPTATION_TYPE:
        return adaptation_type != ADAPTATION_TYPE_EDEFAULT;
      case CaslPackage.ADAPTIVE_PROCESS__ADAPTATION_DELAY:
        return adaptationDelay != ADAPTATION_DELAY_EDEFAULT;
      case CaslPackage.ADAPTIVE_PROCESS__FUNCTION_PARAMETERS:
        return functionParameters != null && !functionParameters.isEmpty();
      case CaslPackage.ADAPTIVE_PROCESS__BODY:
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
    result.append(", adaptation_type: ");
    result.append(adaptation_type);
    result.append(", adaptationDelay: ");
    result.append(adaptationDelay);
    result.append(')');
    return result.toString();
  }

} //AdaptiveProcessImpl
