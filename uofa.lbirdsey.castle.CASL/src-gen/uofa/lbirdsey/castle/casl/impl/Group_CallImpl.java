/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Group;
import uofa.lbirdsey.castle.casl.Group_Call;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Group_CallImpl#getGroupCall <em>Group Call</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Group_CallImpl#getGrp <em>Grp</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.Group_CallImpl#getQnc <em>Qnc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Group_CallImpl extends ExpressionImpl implements Group_Call
{
  /**
   * The cached value of the '{@link #getGroupCall() <em>Group Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroupCall()
   * @generated
   * @ordered
   */
  protected Group_Call groupCall;

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
   * The default value of the '{@link #getQnc() <em>Qnc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQnc()
   * @generated
   * @ordered
   */
  protected static final String QNC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getQnc() <em>Qnc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQnc()
   * @generated
   * @ordered
   */
  protected String qnc = QNC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Group_CallImpl()
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
    return CaslPackage.eINSTANCE.getGroup_Call();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Group_Call getGroupCall()
  {
    return groupCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGroupCall(Group_Call newGroupCall, NotificationChain msgs)
  {
    Group_Call oldGroupCall = groupCall;
    groupCall = newGroupCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_CALL__GROUP_CALL, oldGroupCall, newGroupCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGroupCall(Group_Call newGroupCall)
  {
    if (newGroupCall != groupCall)
    {
      NotificationChain msgs = null;
      if (groupCall != null)
        msgs = ((InternalEObject)groupCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.GROUP_CALL__GROUP_CALL, null, msgs);
      if (newGroupCall != null)
        msgs = ((InternalEObject)newGroupCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.GROUP_CALL__GROUP_CALL, null, msgs);
      msgs = basicSetGroupCall(newGroupCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_CALL__GROUP_CALL, newGroupCall, newGroupCall));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.GROUP_CALL__GRP, oldGrp, grp));
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
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_CALL__GRP, oldGrp, grp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getQnc()
  {
    return qnc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQnc(String newQnc)
  {
    String oldQnc = qnc;
    qnc = newQnc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.GROUP_CALL__QNC, oldQnc, qnc));
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
      case CaslPackage.GROUP_CALL__GROUP_CALL:
        return basicSetGroupCall(null, msgs);
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
      case CaslPackage.GROUP_CALL__GROUP_CALL:
        return getGroupCall();
      case CaslPackage.GROUP_CALL__GRP:
        if (resolve) return getGrp();
        return basicGetGrp();
      case CaslPackage.GROUP_CALL__QNC:
        return getQnc();
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
      case CaslPackage.GROUP_CALL__GROUP_CALL:
        setGroupCall((Group_Call)newValue);
        return;
      case CaslPackage.GROUP_CALL__GRP:
        setGrp((Group)newValue);
        return;
      case CaslPackage.GROUP_CALL__QNC:
        setQnc((String)newValue);
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
      case CaslPackage.GROUP_CALL__GROUP_CALL:
        setGroupCall((Group_Call)null);
        return;
      case CaslPackage.GROUP_CALL__GRP:
        setGrp((Group)null);
        return;
      case CaslPackage.GROUP_CALL__QNC:
        setQnc(QNC_EDEFAULT);
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
      case CaslPackage.GROUP_CALL__GROUP_CALL:
        return groupCall != null;
      case CaslPackage.GROUP_CALL__GRP:
        return grp != null;
      case CaslPackage.GROUP_CALL__QNC:
        return QNC_EDEFAULT == null ? qnc != null : !QNC_EDEFAULT.equals(qnc);
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
    result.append(" (qnc: ");
    result.append(qnc);
    result.append(')');
    return result.toString();
  }

} //Group_CallImpl
