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
import uofa.lbirdsey.castle.casl.Environment;
import uofa.lbirdsey.castle.casl.EnvironmentFieldReference;
import uofa.lbirdsey.castle.casl.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment Field Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.EnvironmentFieldReferenceImpl#getEnv <em>Env</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.EnvironmentFieldReferenceImpl#getAssignment <em>Assignment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnvironmentFieldReferenceImpl extends SymbolImpl implements EnvironmentFieldReference
{
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
  protected EnvironmentFieldReferenceImpl()
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
    return CaslPackage.eINSTANCE.getEnvironmentFieldReference();
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ENV, oldEnv, env));
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
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ENV, oldEnv, env));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ASSIGNMENT, oldAssignment, newAssignment);
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
        msgs = ((InternalEObject)assignment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ASSIGNMENT, null, msgs);
      if (newAssignment != null)
        msgs = ((InternalEObject)newAssignment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ASSIGNMENT, null, msgs);
      msgs = basicSetAssignment(newAssignment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ASSIGNMENT, newAssignment, newAssignment));
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
      case CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ASSIGNMENT:
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
      case CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ENV:
        if (resolve) return getEnv();
        return basicGetEnv();
      case CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ASSIGNMENT:
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
      case CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ENV:
        setEnv((Environment)newValue);
        return;
      case CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ASSIGNMENT:
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
      case CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ENV:
        setEnv((Environment)null);
        return;
      case CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ASSIGNMENT:
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
      case CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ENV:
        return env != null;
      case CaslPackage.ENVIRONMENT_FIELD_REFERENCE__ASSIGNMENT:
        return assignment != null;
    }
    return super.eIsSet(featureID);
  }

} //EnvironmentFieldReferenceImpl
