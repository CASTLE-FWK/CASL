/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Layout Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getLayoutType()
 * @model
 * @generated
 */
public enum LayoutType implements Enumerator
{
  /**
   * The '<em><b>GRID</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GRID_VALUE
   * @generated
   * @ordered
   */
  GRID(0, "GRID", "GRID"),

  /**
   * The '<em><b>TORUS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TORUS_VALUE
   * @generated
   * @ordered
   */
  TORUS(1, "TORUS", "TORUS"),

  /**
   * The '<em><b>BOUND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BOUND_VALUE
   * @generated
   * @ordered
   */
  BOUND(2, "BOUND", "BOUND"),

  /**
   * The '<em><b>GRAPH</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GRAPH_VALUE
   * @generated
   * @ordered
   */
  GRAPH(3, "GRAPH", "GRAPH"),

  /**
   * The '<em><b>NETWORK</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NETWORK_VALUE
   * @generated
   * @ordered
   */
  NETWORK(4, "NETWORK", "NETWORK"),

  /**
   * The '<em><b>GIS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GIS_VALUE
   * @generated
   * @ordered
   */
  GIS(5, "GIS", "GIS"),

  /**
   * The '<em><b>MESH3D</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MESH3D_VALUE
   * @generated
   * @ordered
   */
  MESH3D(6, "MESH3D", "MESH3D"),

  /**
   * The '<em><b>CONTINUOUS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONTINUOUS_VALUE
   * @generated
   * @ordered
   */
  CONTINUOUS(7, "CONTINUOUS", "CONTINUOUS");

  /**
   * The '<em><b>GRID</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GRID</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GRID
   * @model
   * @generated
   * @ordered
   */
  public static final int GRID_VALUE = 0;

  /**
   * The '<em><b>TORUS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TORUS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TORUS
   * @model
   * @generated
   * @ordered
   */
  public static final int TORUS_VALUE = 1;

  /**
   * The '<em><b>BOUND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BOUND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BOUND
   * @model
   * @generated
   * @ordered
   */
  public static final int BOUND_VALUE = 2;

  /**
   * The '<em><b>GRAPH</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GRAPH</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GRAPH
   * @model
   * @generated
   * @ordered
   */
  public static final int GRAPH_VALUE = 3;

  /**
   * The '<em><b>NETWORK</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NETWORK</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NETWORK
   * @model
   * @generated
   * @ordered
   */
  public static final int NETWORK_VALUE = 4;

  /**
   * The '<em><b>GIS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GIS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GIS
   * @model
   * @generated
   * @ordered
   */
  public static final int GIS_VALUE = 5;

  /**
   * The '<em><b>MESH3D</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MESH3D</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MESH3D
   * @model
   * @generated
   * @ordered
   */
  public static final int MESH3D_VALUE = 6;

  /**
   * The '<em><b>CONTINUOUS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONTINUOUS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONTINUOUS
   * @model
   * @generated
   * @ordered
   */
  public static final int CONTINUOUS_VALUE = 7;

  /**
   * An array of all the '<em><b>Layout Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final LayoutType[] VALUES_ARRAY =
    new LayoutType[]
    {
      GRID,
      TORUS,
      BOUND,
      GRAPH,
      NETWORK,
      GIS,
      MESH3D,
      CONTINUOUS,
    };

  /**
   * A public read-only list of all the '<em><b>Layout Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<LayoutType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Layout Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static LayoutType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      LayoutType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Layout Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static LayoutType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      LayoutType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Layout Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static LayoutType get(int value)
  {
    switch (value)
    {
      case GRID_VALUE: return GRID;
      case TORUS_VALUE: return TORUS;
      case BOUND_VALUE: return BOUND;
      case GRAPH_VALUE: return GRAPH;
      case NETWORK_VALUE: return NETWORK;
      case GIS_VALUE: return GIS;
      case MESH3D_VALUE: return MESH3D;
      case CONTINUOUS_VALUE: return CONTINUOUS;
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
  private LayoutType(int value, String name, String literal)
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
  
} //LayoutType
