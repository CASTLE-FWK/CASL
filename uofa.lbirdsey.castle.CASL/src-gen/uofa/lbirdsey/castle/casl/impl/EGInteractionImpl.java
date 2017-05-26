/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.EGInteraction;
import uofa.lbirdsey.castle.casl.LayoutType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EG Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.EGInteractionImpl#getLayoutType <em>Layout Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EGInteractionImpl extends InteractionImpl implements EGInteraction
{
  /**
   * The default value of the '{@link #getLayoutType() <em>Layout Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayoutType()
   * @generated
   * @ordered
   */
  protected static final LayoutType LAYOUT_TYPE_EDEFAULT = LayoutType.GRID;

  /**
   * The cached value of the '{@link #getLayoutType() <em>Layout Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayoutType()
   * @generated
   * @ordered
   */
  protected LayoutType layoutType = LAYOUT_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EGInteractionImpl()
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
    return CaslPackage.eINSTANCE.getEGInteraction();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LayoutType getLayoutType()
  {
    return layoutType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLayoutType(LayoutType newLayoutType)
  {
    LayoutType oldLayoutType = layoutType;
    layoutType = newLayoutType == null ? LAYOUT_TYPE_EDEFAULT : newLayoutType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.EG_INTERACTION__LAYOUT_TYPE, oldLayoutType, layoutType));
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
      case CaslPackage.EG_INTERACTION__LAYOUT_TYPE:
        return getLayoutType();
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
      case CaslPackage.EG_INTERACTION__LAYOUT_TYPE:
        setLayoutType((LayoutType)newValue);
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
      case CaslPackage.EG_INTERACTION__LAYOUT_TYPE:
        setLayoutType(LAYOUT_TYPE_EDEFAULT);
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
      case CaslPackage.EG_INTERACTION__LAYOUT_TYPE:
        return layoutType != LAYOUT_TYPE_EDEFAULT;
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
    result.append(" (layoutType: ");
    result.append(layoutType);
    result.append(')');
    return result.toString();
  }

} //EGInteractionImpl