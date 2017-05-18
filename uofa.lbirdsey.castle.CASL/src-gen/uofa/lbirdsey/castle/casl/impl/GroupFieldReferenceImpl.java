/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.Group;
import uofa.lbirdsey.castle.casl.GroupFieldReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Field Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupFieldReferenceImpl#getGrp <em>Grp</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.GroupFieldReferenceImpl#getAssignment <em>Assignment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupFieldReferenceImpl extends SymbolImpl implements GroupFieldReference
{
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
   * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignment()
   * @generated
   * @ordered
   */
  protected Expression assignment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GroupFieldReferenceImpl()
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
    return CaslPackage.eINSTANCE.getGroupFieldReference();
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.GROUP_FIELD_REFERENCE__GRP, oldGrp, grp));
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
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_FIELD_REFERENCE__GRP, oldGrp, grp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getAssignment()
  {
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssignment(Expression newAssignment, NotificationChain msgs)
  {
    Expression oldAssignment = assignment;
    assignment = newAssignment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_FIELD_REFERENCE__ASSIGNMENT, oldAssignment, newAssignment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignment(Expression newAssignment)
  {
    if (newAssignment != assignment)
    {
      NotificationChain msgs = null;
      if (assignment != null)
        msgs = ((InternalEObject)assignment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.GROUP_FIELD_REFERENCE__ASSIGNMENT, null, msgs);
      if (newAssignment != null)
        msgs = ((InternalEObject)newAssignment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.GROUP_FIELD_REFERENCE__ASSIGNMENT, null, msgs);
      msgs = basicSetAssignment(newAssignment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_FIELD_REFERENCE__ASSIGNMENT, newAssignment, newAssignment));
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
      case CaslPackage.GROUP_FIELD_REFERENCE__ASSIGNMENT:
        return basicSetAssignment(null, msgs);
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
      case CaslPackage.GROUP_FIELD_REFERENCE__GRP:
        if (resolve) return getGrp();
        return basicGetGrp();
      case CaslPackage.GROUP_FIELD_REFERENCE__ASSIGNMENT:
        return getAssignment();
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
      case CaslPackage.GROUP_FIELD_REFERENCE__GRP:
        setGrp((Group)newValue);
        return;
      case CaslPackage.GROUP_FIELD_REFERENCE__ASSIGNMENT:
        setAssignment((Expression)newValue);
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
      case CaslPackage.GROUP_FIELD_REFERENCE__GRP:
        setGrp((Group)null);
        return;
      case CaslPackage.GROUP_FIELD_REFERENCE__ASSIGNMENT:
        setAssignment((Expression)null);
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
      case CaslPackage.GROUP_FIELD_REFERENCE__GRP:
        return grp != null;
      case CaslPackage.GROUP_FIELD_REFERENCE__ASSIGNMENT:
        return assignment != null;
    }
    return super.eIsSet(featureID);
  }

} //GroupFieldReferenceImpl
