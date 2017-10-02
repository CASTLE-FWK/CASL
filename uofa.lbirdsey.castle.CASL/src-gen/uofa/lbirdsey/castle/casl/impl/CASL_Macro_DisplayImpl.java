/**
 * generated by Xtext 2.12.0
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
import org.eclipse.emf.ecore.util.InternalEList;

import uofa.lbirdsey.castle.casl.CASL_Macro_Display;
import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.LayoutType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CASL Macro Display</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_DisplayImpl#getRepresentationType <em>Representation Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_DisplayImpl#getToProject <em>To Project</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CASL_Macro_DisplayImpl extends CASL_MacroImpl implements CASL_Macro_Display
{
  /**
   * The default value of the '{@link #getRepresentationType() <em>Representation Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepresentationType()
   * @generated
   * @ordered
   */
  protected static final LayoutType REPRESENTATION_TYPE_EDEFAULT = LayoutType.GRID;

  /**
   * The cached value of the '{@link #getRepresentationType() <em>Representation Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepresentationType()
   * @generated
   * @ordered
   */
  protected LayoutType representationType = REPRESENTATION_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getToProject() <em>To Project</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToProject()
   * @generated
   * @ordered
   */
  protected EList<Expression> toProject;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CASL_Macro_DisplayImpl()
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
    return CaslPackage.eINSTANCE.getCASL_Macro_Display();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LayoutType getRepresentationType()
  {
    return representationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRepresentationType(LayoutType newRepresentationType)
  {
    LayoutType oldRepresentationType = representationType;
    representationType = newRepresentationType == null ? REPRESENTATION_TYPE_EDEFAULT : newRepresentationType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_DISPLAY__REPRESENTATION_TYPE, oldRepresentationType, representationType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getToProject()
  {
    if (toProject == null)
    {
      toProject = new EObjectContainmentEList<Expression>(Expression.class, this, CaslPackage.CASL_MACRO_DISPLAY__TO_PROJECT);
    }
    return toProject;
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
      case CaslPackage.CASL_MACRO_DISPLAY__TO_PROJECT:
        return ((InternalEList<?>)getToProject()).basicRemove(otherEnd, msgs);
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
      case CaslPackage.CASL_MACRO_DISPLAY__REPRESENTATION_TYPE:
        return getRepresentationType();
      case CaslPackage.CASL_MACRO_DISPLAY__TO_PROJECT:
        return getToProject();
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
      case CaslPackage.CASL_MACRO_DISPLAY__REPRESENTATION_TYPE:
        setRepresentationType((LayoutType)newValue);
        return;
      case CaslPackage.CASL_MACRO_DISPLAY__TO_PROJECT:
        getToProject().clear();
        getToProject().addAll((Collection<? extends Expression>)newValue);
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
      case CaslPackage.CASL_MACRO_DISPLAY__REPRESENTATION_TYPE:
        setRepresentationType(REPRESENTATION_TYPE_EDEFAULT);
        return;
      case CaslPackage.CASL_MACRO_DISPLAY__TO_PROJECT:
        getToProject().clear();
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
      case CaslPackage.CASL_MACRO_DISPLAY__REPRESENTATION_TYPE:
        return representationType != REPRESENTATION_TYPE_EDEFAULT;
      case CaslPackage.CASL_MACRO_DISPLAY__TO_PROJECT:
        return toProject != null && !toProject.isEmpty();
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
    result.append(" (representationType: ");
    result.append(representationType);
    result.append(')');
    return result.toString();
  }

} //CASL_Macro_DisplayImpl
