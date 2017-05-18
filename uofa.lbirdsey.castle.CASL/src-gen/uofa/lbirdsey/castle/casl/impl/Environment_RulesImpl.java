/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Environment_Attribute;
import uofa.lbirdsey.castle.casl.Environment_Rules;
import uofa.lbirdsey.castle.casl.Environment_Type;
import uofa.lbirdsey.castle.casl.LayoutType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment Rules</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Environment_RulesImpl#getEnv_def <em>Env def</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Environment_RulesImpl#getEnv_attributes <em>Env attributes</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Environment_RulesImpl#getLayout_type <em>Layout type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Environment_RulesImpl extends MinimalEObjectImpl.Container implements Environment_Rules
{
  /**
   * The default value of the '{@link #getEnv_def() <em>Env def</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnv_def()
   * @generated
   * @ordered
   */
  protected static final Environment_Type ENV_DEF_EDEFAULT = Environment_Type.IMPLICIT;

  /**
   * The cached value of the '{@link #getEnv_def() <em>Env def</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnv_def()
   * @generated
   * @ordered
   */
  protected Environment_Type env_def = ENV_DEF_EDEFAULT;

  /**
   * The default value of the '{@link #getEnv_attributes() <em>Env attributes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnv_attributes()
   * @generated
   * @ordered
   */
  protected static final Environment_Attribute ENV_ATTRIBUTES_EDEFAULT = Environment_Attribute.VIRTUAL;

  /**
   * The cached value of the '{@link #getEnv_attributes() <em>Env attributes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnv_attributes()
   * @generated
   * @ordered
   */
  protected Environment_Attribute env_attributes = ENV_ATTRIBUTES_EDEFAULT;

  /**
   * The default value of the '{@link #getLayout_type() <em>Layout type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayout_type()
   * @generated
   * @ordered
   */
  protected static final LayoutType LAYOUT_TYPE_EDEFAULT = LayoutType.GRID;

  /**
   * The cached value of the '{@link #getLayout_type() <em>Layout type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayout_type()
   * @generated
   * @ordered
   */
  protected LayoutType layout_type = LAYOUT_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Environment_RulesImpl()
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
    return CaslPackage.eINSTANCE.getEnvironment_Rules();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment_Type getEnv_def()
  {
    return env_def;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnv_def(Environment_Type newEnv_def)
  {
    Environment_Type oldEnv_def = env_def;
    env_def = newEnv_def == null ? ENV_DEF_EDEFAULT : newEnv_def;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ENVIRONMENT_RULES__ENV_DEF, oldEnv_def, env_def));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment_Attribute getEnv_attributes()
  {
    return env_attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnv_attributes(Environment_Attribute newEnv_attributes)
  {
    Environment_Attribute oldEnv_attributes = env_attributes;
    env_attributes = newEnv_attributes == null ? ENV_ATTRIBUTES_EDEFAULT : newEnv_attributes;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ENVIRONMENT_RULES__ENV_ATTRIBUTES, oldEnv_attributes, env_attributes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LayoutType getLayout_type()
  {
    return layout_type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLayout_type(LayoutType newLayout_type)
  {
    LayoutType oldLayout_type = layout_type;
    layout_type = newLayout_type == null ? LAYOUT_TYPE_EDEFAULT : newLayout_type;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ENVIRONMENT_RULES__LAYOUT_TYPE, oldLayout_type, layout_type));
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
      case CaslPackage.ENVIRONMENT_RULES__ENV_DEF:
        return getEnv_def();
      case CaslPackage.ENVIRONMENT_RULES__ENV_ATTRIBUTES:
        return getEnv_attributes();
      case CaslPackage.ENVIRONMENT_RULES__LAYOUT_TYPE:
        return getLayout_type();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CaslPackage.ENVIRONMENT_RULES__ENV_DEF:
        setEnv_def((Environment_Type)newValue);
        return;
      case CaslPackage.ENVIRONMENT_RULES__ENV_ATTRIBUTES:
        setEnv_attributes((Environment_Attribute)newValue);
        return;
      case CaslPackage.ENVIRONMENT_RULES__LAYOUT_TYPE:
        setLayout_type((LayoutType)newValue);
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
      case CaslPackage.ENVIRONMENT_RULES__ENV_DEF:
        setEnv_def(ENV_DEF_EDEFAULT);
        return;
      case CaslPackage.ENVIRONMENT_RULES__ENV_ATTRIBUTES:
        setEnv_attributes(ENV_ATTRIBUTES_EDEFAULT);
        return;
      case CaslPackage.ENVIRONMENT_RULES__LAYOUT_TYPE:
        setLayout_type(LAYOUT_TYPE_EDEFAULT);
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
      case CaslPackage.ENVIRONMENT_RULES__ENV_DEF:
        return env_def != ENV_DEF_EDEFAULT;
      case CaslPackage.ENVIRONMENT_RULES__ENV_ATTRIBUTES:
        return env_attributes != ENV_ATTRIBUTES_EDEFAULT;
      case CaslPackage.ENVIRONMENT_RULES__LAYOUT_TYPE:
        return layout_type != LAYOUT_TYPE_EDEFAULT;
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
    result.append(" (env_def: ");
    result.append(env_def);
    result.append(", env_attributes: ");
    result.append(env_attributes);
    result.append(", layout_type: ");
    result.append(layout_type);
    result.append(')');
    return result.toString();
  }

} //Environment_RulesImpl
