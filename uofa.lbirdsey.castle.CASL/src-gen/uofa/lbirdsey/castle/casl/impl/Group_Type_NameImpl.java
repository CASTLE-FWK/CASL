/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Group_Type_Name;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Type Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Group_Type_NameImpl#getGroup_type_name <em>Group type name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Group_Type_NameImpl extends MinimalEObjectImpl.Container implements Group_Type_Name
{
  /**
   * The default value of the '{@link #getGroup_type_name() <em>Group type name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup_type_name()
   * @generated
   * @ordered
   */
  protected static final String GROUP_TYPE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGroup_type_name() <em>Group type name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup_type_name()
   * @generated
   * @ordered
   */
  protected String group_type_name = GROUP_TYPE_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Group_Type_NameImpl()
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
    return CaslPackage.eINSTANCE.getGroup_Type_Name();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGroup_type_name()
  {
    return group_type_name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGroup_type_name(String newGroup_type_name)
  {
    String oldGroup_type_name = group_type_name;
    group_type_name = newGroup_type_name;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_TYPE_NAME__GROUP_TYPE_NAME, oldGroup_type_name, group_type_name));
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
      case CaslPackage.GROUP_TYPE_NAME__GROUP_TYPE_NAME:
        return getGroup_type_name();
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
      case CaslPackage.GROUP_TYPE_NAME__GROUP_TYPE_NAME:
        setGroup_type_name((String)newValue);
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
      case CaslPackage.GROUP_TYPE_NAME__GROUP_TYPE_NAME:
        setGroup_type_name(GROUP_TYPE_NAME_EDEFAULT);
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
      case CaslPackage.GROUP_TYPE_NAME__GROUP_TYPE_NAME:
        return GROUP_TYPE_NAME_EDEFAULT == null ? group_type_name != null : !GROUP_TYPE_NAME_EDEFAULT.equals(group_type_name);
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
    result.append(" (group_type_name: ");
    result.append(group_type_name);
    result.append(')');
    return result.toString();
  }

} //Group_Type_NameImpl
