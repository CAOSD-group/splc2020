/**
 */
package uma.caosd.rhea.CardinalityBasedFMmetamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.CardinalityBasedFMmetamodelPackage
 * @generated
 */
public interface CardinalityBasedFMmetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CardinalityBasedFMmetamodelFactory eINSTANCE = uma.caosd.rhea.CardinalityBasedFMmetamodel.impl.CardinalityBasedFMmetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Group Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group Feature</em>'.
	 * @generated
	 */
	GroupFeature createGroupFeature();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CardinalityBasedFMmetamodelPackage getCardinalityBasedFMmetamodelPackage();

} //CardinalityBasedFMmetamodelFactory
