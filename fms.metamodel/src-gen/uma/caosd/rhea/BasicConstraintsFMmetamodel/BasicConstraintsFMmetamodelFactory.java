/**
 */
package uma.caosd.rhea.BasicConstraintsFMmetamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraintsFMmetamodelPackage
 * @generated
 */
public interface BasicConstraintsFMmetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasicConstraintsFMmetamodelFactory eINSTANCE = uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintsFMmetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Cross Tree Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cross Tree Constraint</em>'.
	 * @generated
	 */
	CrossTreeConstraint createCrossTreeConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BasicConstraintsFMmetamodelPackage getBasicConstraintsFMmetamodelPackage();

} //BasicConstraintsFMmetamodelFactory
