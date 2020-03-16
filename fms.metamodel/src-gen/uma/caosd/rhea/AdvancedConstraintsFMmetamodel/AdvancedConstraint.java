/**
 */
package uma.caosd.rhea.AdvancedConstraintsFMmetamodel;

import uma.caosd.rhea.BasicFMmetamodel.CrossTreeConstraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advanced Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint#getId <em>Id</em>}</li>
 *   <li>{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint#getTerm <em>Term</em>}</li>
 * </ul>
 *
 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelPackage#getAdvancedConstraint()
 * @model
 * @generated
 */
public interface AdvancedConstraint extends CrossTreeConstraint {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelPackage#getAdvancedConstraint_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' containment reference.
	 * @see #setTerm(Term)
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelPackage#getAdvancedConstraint_Term()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getTerm();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint#getTerm <em>Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' containment reference.
	 * @see #getTerm()
	 * @generated
	 */
	void setTerm(Term value);

} // AdvancedConstraint
