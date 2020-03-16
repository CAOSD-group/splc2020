/**
 */
package uma.caosd.rhea.BasicConstraintsFMmetamodel;

import org.eclipse.emf.ecore.EObject;

import uma.caosd.rhea.BasicFMmetamodel.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cross Tree Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getType <em>Type</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getRightFeature <em>Right Feature</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getLeftFeature <em>Left Feature</em>}</li>
 * </ul>
 *
 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraintsFMmetamodelPackage#getCrossTreeConstraint()
 * @model
 * @generated
 */
public interface CrossTreeConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraintType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraintType
	 * @see #setType(CrossTreeConstraintType)
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraintsFMmetamodelPackage#getCrossTreeConstraint_Type()
	 * @model required="true"
	 * @generated
	 */
	CrossTreeConstraintType getType();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraintType
	 * @see #getType()
	 * @generated
	 */
	void setType(CrossTreeConstraintType value);

	/**
	 * Returns the value of the '<em><b>Right Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Feature</em>' reference.
	 * @see #setRightFeature(Feature)
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraintsFMmetamodelPackage#getCrossTreeConstraint_RightFeature()
	 * @model required="true"
	 * @generated
	 */
	Feature getRightFeature();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getRightFeature <em>Right Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Feature</em>' reference.
	 * @see #getRightFeature()
	 * @generated
	 */
	void setRightFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Left Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Feature</em>' reference.
	 * @see #setLeftFeature(Feature)
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraintsFMmetamodelPackage#getCrossTreeConstraint_LeftFeature()
	 * @model required="true"
	 * @generated
	 */
	Feature getLeftFeature();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getLeftFeature <em>Left Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Feature</em>' reference.
	 * @see #getLeftFeature()
	 * @generated
	 */
	void setLeftFeature(Feature value);

} // CrossTreeConstraint
