/**
 */
package uma.caosd.rhea.CardinalityBasedFMmetamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.CardinalityBasedFMmetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface CardinalityBasedFMmetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "CardinalityBasedFMmetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://caosd.lcc.uma.es/CardinalityBasedFMmetamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CardinalityBasedFMmetamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CardinalityBasedFMmetamodelPackage eINSTANCE = uma.caosd.rhea.CardinalityBasedFMmetamodel.impl.CardinalityBasedFMmetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.CardinalityBasedFMmetamodel.impl.GroupFeatureImpl <em>Group Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.impl.GroupFeatureImpl
	 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.impl.CardinalityBasedFMmetamodelPackageImpl#getGroupFeature()
	 * @generated
	 */
	int GROUP_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE__ID = BasicFMmetamodelPackage.FEATURE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE__NAME = BasicFMmetamodelPackage.FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE__MANDATORY = BasicFMmetamodelPackage.FEATURE__MANDATORY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE__CHILDREN = BasicFMmetamodelPackage.FEATURE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE__PARENT = BasicFMmetamodelPackage.FEATURE__PARENT;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE__LOWER = BasicFMmetamodelPackage.FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE__UPPER = BasicFMmetamodelPackage.FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Group Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_FEATURE_COUNT = BasicFMmetamodelPackage.FEATURE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE___IS_LEAF = BasicFMmetamodelPackage.FEATURE___IS_LEAF;

	/**
	 * The operation id for the '<em>Is Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE___IS_ROOT = BasicFMmetamodelPackage.FEATURE___IS_ROOT;

	/**
	 * The number of operations of the '<em>Group Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_OPERATION_COUNT = BasicFMmetamodelPackage.FEATURE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature <em>Group Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Feature</em>'.
	 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature
	 * @generated
	 */
	EClass getGroupFeature();

	/**
	 * Returns the meta object for the attribute '{@link uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature#getLower()
	 * @see #getGroupFeature()
	 * @generated
	 */
	EAttribute getGroupFeature_Lower();

	/**
	 * Returns the meta object for the attribute '{@link uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature#getUpper()
	 * @see #getGroupFeature()
	 * @generated
	 */
	EAttribute getGroupFeature_Upper();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CardinalityBasedFMmetamodelFactory getCardinalityBasedFMmetamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.CardinalityBasedFMmetamodel.impl.GroupFeatureImpl <em>Group Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.impl.GroupFeatureImpl
		 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.impl.CardinalityBasedFMmetamodelPackageImpl#getGroupFeature()
		 * @generated
		 */
		EClass GROUP_FEATURE = eINSTANCE.getGroupFeature();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_FEATURE__LOWER = eINSTANCE.getGroupFeature_Lower();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_FEATURE__UPPER = eINSTANCE.getGroupFeature_Upper();

	}

} //CardinalityBasedFMmetamodelPackage
