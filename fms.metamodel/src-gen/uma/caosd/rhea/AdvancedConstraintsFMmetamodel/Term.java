/**
 */
package uma.caosd.rhea.AdvancedConstraintsFMmetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import uma.caosd.rhea.BasicFMmetamodel.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getType <em>Type</em>}</li>
 *   <li>{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getOperands <em>Operands</em>}</li>
 *   <li>{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"feature"</code>.
	 * The literals are from the enumeration {@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.TermType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.TermType
	 * @see #setType(TermType)
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelPackage#getTerm_Type()
	 * @model default="feature"
	 * @generated
	 */
	TermType getType();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.TermType
	 * @see #getType()
	 * @generated
	 */
	void setType(TermType value);

	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelPackage#getTerm_Operands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Term> getOperands();

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(Feature)
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelPackage#getTerm_Feature()
	 * @model
	 * @generated
	 */
	Feature getFeature();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(Feature value);

} // Term
