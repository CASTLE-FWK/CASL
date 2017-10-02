/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl.impl;

import java.math.BigDecimal;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uofa.lbirdsey.castle.casl.CASL_Macro_Neighbours;
import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Entity;
import uofa.lbirdsey.castle.casl.LayoutType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CASL Macro Neighbours</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_NeighboursImpl#getWorldType <em>World Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_NeighboursImpl#getSearchType <em>Search Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.impl.CASL_Macro_NeighboursImpl#getDist <em>Dist</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CASL_Macro_NeighboursImpl extends CASL_MacroImpl implements CASL_Macro_Neighbours
{
  /**
   * The default value of the '{@link #getWorldType() <em>World Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorldType()
   * @generated
   * @ordered
   */
  protected static final LayoutType WORLD_TYPE_EDEFAULT = LayoutType.GRID;

  /**
   * The cached value of the '{@link #getWorldType() <em>World Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorldType()
   * @generated
   * @ordered
   */
  protected LayoutType worldType = WORLD_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getSearchType() <em>Search Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSearchType()
   * @generated
   * @ordered
   */
  protected Entity searchType;

  /**
   * The default value of the '{@link #getDist() <em>Dist</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDist()
   * @generated
   * @ordered
   */
  protected static final BigDecimal DIST_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDist() <em>Dist</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDist()
   * @generated
   * @ordered
   */
  protected BigDecimal dist = DIST_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CASL_Macro_NeighboursImpl()
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
    return CaslPackage.eINSTANCE.getCASL_Macro_Neighbours();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LayoutType getWorldType()
  {
    return worldType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWorldType(LayoutType newWorldType)
  {
    LayoutType oldWorldType = worldType;
    worldType = newWorldType == null ? WORLD_TYPE_EDEFAULT : newWorldType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_NEIGHBOURS__WORLD_TYPE, oldWorldType, worldType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity getSearchType()
  {
    if (searchType != null && searchType.eIsProxy())
    {
      InternalEObject oldSearchType = (InternalEObject)searchType;
      searchType = (Entity)eResolveProxy(oldSearchType);
      if (searchType != oldSearchType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CaslPackage.CASL_MACRO_NEIGHBOURS__SEARCH_TYPE, oldSearchType, searchType));
      }
    }
    return searchType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity basicGetSearchType()
  {
    return searchType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSearchType(Entity newSearchType)
  {
    Entity oldSearchType = searchType;
    searchType = newSearchType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_NEIGHBOURS__SEARCH_TYPE, oldSearchType, searchType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getDist()
  {
    return dist;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDist(BigDecimal newDist)
  {
    BigDecimal oldDist = dist;
    dist = newDist;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CaslPackage.CASL_MACRO_NEIGHBOURS__DIST, oldDist, dist));
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
      case CaslPackage.CASL_MACRO_NEIGHBOURS__WORLD_TYPE:
        return getWorldType();
      case CaslPackage.CASL_MACRO_NEIGHBOURS__SEARCH_TYPE:
        if (resolve) return getSearchType();
        return basicGetSearchType();
      case CaslPackage.CASL_MACRO_NEIGHBOURS__DIST:
        return getDist();
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
      case CaslPackage.CASL_MACRO_NEIGHBOURS__WORLD_TYPE:
        setWorldType((LayoutType)newValue);
        return;
      case CaslPackage.CASL_MACRO_NEIGHBOURS__SEARCH_TYPE:
        setSearchType((Entity)newValue);
        return;
      case CaslPackage.CASL_MACRO_NEIGHBOURS__DIST:
        setDist((BigDecimal)newValue);
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
      case CaslPackage.CASL_MACRO_NEIGHBOURS__WORLD_TYPE:
        setWorldType(WORLD_TYPE_EDEFAULT);
        return;
      case CaslPackage.CASL_MACRO_NEIGHBOURS__SEARCH_TYPE:
        setSearchType((Entity)null);
        return;
      case CaslPackage.CASL_MACRO_NEIGHBOURS__DIST:
        setDist(DIST_EDEFAULT);
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
      case CaslPackage.CASL_MACRO_NEIGHBOURS__WORLD_TYPE:
        return worldType != WORLD_TYPE_EDEFAULT;
      case CaslPackage.CASL_MACRO_NEIGHBOURS__SEARCH_TYPE:
        return searchType != null;
      case CaslPackage.CASL_MACRO_NEIGHBOURS__DIST:
        return DIST_EDEFAULT == null ? dist != null : !DIST_EDEFAULT.equals(dist);
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
    result.append(" (worldType: ");
    result.append(worldType);
    result.append(", dist: ");
    result.append(dist);
    result.append(')');
    return result.toString();
  }

} //CASL_Macro_NeighboursImpl
