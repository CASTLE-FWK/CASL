/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>CAS Rule Exception</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getCAS_Rule_Exception()
 * @model
 * @generated
 */
public enum CAS_Rule_Exception implements Enumerator
{
  /**
   * The '<em><b>MODULARITY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODULARITY_VALUE
   * @generated
   * @ordered
   */
  MODULARITY(0, "MODULARITY", "modularity"),

  /**
   * The '<em><b>DIVERSITY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DIVERSITY_VALUE
   * @generated
   * @ordered
   */
  DIVERSITY(1, "DIVERSITY", "diversity"),

  /**
   * The '<em><b>NONE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NONE_VALUE
   * @generated
   * @ordered
   */
  NONE(2, "NONE", "none"),

  /**
   * The '<em><b>ADAPTATION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADAPTATION_VALUE
   * @generated
   * @ordered
   */
  ADAPTATION(3, "ADAPTATION", "adaptation");

  /**
   * The '<em><b>MODULARITY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MODULARITY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MODULARITY
   * @model literal="modularity"
   * @generated
   * @ordered
   */
  public static final int MODULARITY_VALUE = 0;

  /**
   * The '<em><b>DIVERSITY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DIVERSITY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DIVERSITY
   * @model literal="diversity"
   * @generated
   * @ordered
   */
  public static final int DIVERSITY_VALUE = 1;

  /**
   * The '<em><b>NONE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NONE
   * @model literal="none"
   * @generated
   * @ordered
   */
  public static final int NONE_VALUE = 2;

  /**
   * The '<em><b>ADAPTATION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ADAPTATION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ADAPTATION
   * @model literal="adaptation"
   * @generated
   * @ordered
   */
  public static final int ADAPTATION_VALUE = 3;

  /**
   * An array of all the '<em><b>CAS Rule Exception</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final CAS_Rule_Exception[] VALUES_ARRAY =
    new CAS_Rule_Exception[]
    {
      MODULARITY,
      DIVERSITY,
      NONE,
      ADAPTATION,
    };

  /**
   * A public read-only list of all the '<em><b>CAS Rule Exception</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<CAS_Rule_Exception> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>CAS Rule Exception</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static CAS_Rule_Exception get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      CAS_Rule_Exception result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>CAS Rule Exception</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static CAS_Rule_Exception getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      CAS_Rule_Exception result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>CAS Rule Exception</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static CAS_Rule_Exception get(int value)
  {
    switch (value)
    {
      case MODULARITY_VALUE: return MODULARITY;
      case DIVERSITY_VALUE: return DIVERSITY;
      case NONE_VALUE: return NONE;
      case ADAPTATION_VALUE: return ADAPTATION;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private CAS_Rule_Exception(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
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
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //CAS_Rule_Exception
