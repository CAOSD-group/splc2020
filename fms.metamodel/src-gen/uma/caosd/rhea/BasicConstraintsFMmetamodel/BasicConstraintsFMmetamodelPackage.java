/**
 */
package uma.caosd.rhea.BasicConstraintsFMmetamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraintsFMmetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface BasicConstraintsFMmetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "BasicConstraintsFMmetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://caosd.lcc.uma.es/BasicConstraintsFMmetamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "BasicConstraintsFMmetamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasicConstraintsFMmetamodelPackage eINSTANCE = uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintsFMmetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.CrossTreeConstraintImpl <em>Cross Tree Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.CrossTreeConstraintImpl
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintsFMmetamodelPackageImpl#getCrossTreeConstraint()
	 * @generated
	 */
	int CROSS_TREE_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_TREE_CONSTRAINT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Right Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_TREE_CONSTRAINT__RIGHT_FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Left Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_TREE_CONSTRAINT__LEFT_FEATURE = 2;

	/**
	 * The number of structural features of the '<em>Cross Tree Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_TREE_CONSTRAINT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Cross Tree Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_TREE_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraintType <em>Cross Tree Constraint Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraintType
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintsFMmetamodelPackageImpl#getCrossTreeConstraintType()
	 * @generated
	 */
	int CROSS_TREE_CONSTRAINT_TYPE = 1;


	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint <em>Cross Tree Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Tree Constraint</em>'.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint
	 * @generated
	 */
	EClass getCrossTreeConstraint();

	/**
	 * Returns the meta object for the attribute '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getType()
	 * @see #getCrossTreeConstraint()
	 * @generated
	 */
	EAttribute getCrossTreeConstraint_Type();

	/**
	 * Returns the meta object for the reference '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getRightFeature <em>Right Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Feature</em>'.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getRightFeature()
	 * @see #getCrossTreeConstraint()
	 * @generated
	 */
	EReference getCrossTreeConstraint_RightFeature();

	/**
	 * Returns the meta object for the reference '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getLeftFeature <em>Left Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Feature</em>'.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraint#getLeftFeature()
	 * @see #getCrossTreeConstraint()
	 * @generated
	 */
	EReference getCrossTreeConstraint_LeftFeature();

	/**
	 * Returns the meta object for enum '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraintType <em>Cross Tree Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cross Tree Constraint Type</em>'.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraintType
	 * @generated
	 */
	EEnum getCrossTreeConstraintType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BasicConstraintsFMmetamodelFactory getBasicConstraintsFMmetamodelFactory();

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
		 * The meta object literal for the '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.CrossTreeConstraintImpl <em>Cross Tree Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.CrossTreeConstraintImpl
		 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintsFMmetamodelPackageImpl#getCrossTreeConstraint()
		 * @generated
		 */
		EClass CROSS_TREE_CONSTRAINT = eINSTANCE.getCrossTreeConstraint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSS_TREE_CONSTRAINT__TYPE = eINSTANCE.getCrossTreeConstraint_Type();

		/**
		 * The meta object literal for the '<em><b>Right Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSS_TREE_CONSTRAINT__RIGHT_FEATURE = eINSTANCE.getCrossTreeConstraint_RightFeature();

		/**
		 * The meta object literal for the '<em><b>Left Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSS_TREE_CONSTRAINT__LEFT_FEATURE = eINSTANCE.getCrossTreeConstraint_LeftFeature();

		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraintType <em>Cross Tree Constraint Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.CrossTreeConstraintType
		 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintsFMmetamodelPackageImpl#getCrossTreeConstraintType()
		 * @generated
		 */
		EEnum CROSS_TREE_CONSTRAINT_TYPE = eINSTANCE.getCrossTreeConstraintType();

	}

} //BasicConstraintsFMmetamodelPackage
