/**
 */
package uma.caosd.rhea.BasicConstraints;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see uma.caosd.rhea.BasicConstraints.BasicConstraintsPackage
 * @generated
 */
public interface BasicConstraintsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasicConstraintsFactory eINSTANCE = uma.caosd.rhea.BasicConstraints.impl.BasicConstraintsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>REQUIRES</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>REQUIRES</em>'.
	 * @generated
	 */
	REQUIRES createREQUIRES();

	/**
	 * Returns a new object of class '<em>EXCLUDES</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EXCLUDES</em>'.
	 * @generated
	 */
	EXCLUDES createEXCLUDES();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BasicConstraintsPackage getBasicConstraintsPackage();

} //BasicConstraintsFactory
