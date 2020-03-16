/**
 */
package uma.caosd.rhea.AdvancedConstraintsFMmetamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelPackage
 * @generated
 */
public interface AdvancedConstraintsFMmetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AdvancedConstraintsFMmetamodelFactory eINSTANCE = uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintsFMmetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Advanced Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Advanced Constraint</em>'.
	 * @generated
	 */
	AdvancedConstraint createAdvancedConstraint();

	/**
	 * Returns a new object of class '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Term</em>'.
	 * @generated
	 */
	Term createTerm();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AdvancedConstraintsFMmetamodelPackage getAdvancedConstraintsFMmetamodelPackage();

} //AdvancedConstraintsFMmetamodelFactory
