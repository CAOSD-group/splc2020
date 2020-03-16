/**
 */
package uma.caosd.rhea.BasicConstraintsFMmetamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
	 * The meta object id for the '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintImpl <em>Basic Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintImpl
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintsFMmetamodelPackageImpl#getBasicConstraint()
	 * @generated
	 */
	int BASIC_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT__TYPE = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT__RIGHT_FEATURE = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Left Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT__LEFT_FEATURE = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Basic Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT_FEATURE_COUNT = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Basic Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT_OPERATION_COUNT = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_OPERATION_COUNT + 0;

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
	 * Returns the meta object for class '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraint <em>Basic Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Constraint</em>'.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraint
	 * @generated
	 */
	EClass getBasicConstraint();

	/**
	 * Returns the meta object for the attribute '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraint#getType()
	 * @see #getBasicConstraint()
	 * @generated
	 */
	EAttribute getBasicConstraint_Type();

	/**
	 * Returns the meta object for the reference '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraint#getRightFeature <em>Right Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Feature</em>'.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraint#getRightFeature()
	 * @see #getBasicConstraint()
	 * @generated
	 */
	EReference getBasicConstraint_RightFeature();

	/**
	 * Returns the meta object for the reference '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraint#getLeftFeature <em>Left Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Feature</em>'.
	 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.BasicConstraint#getLeftFeature()
	 * @see #getBasicConstraint()
	 * @generated
	 */
	EReference getBasicConstraint_LeftFeature();

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
		 * The meta object literal for the '{@link uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintImpl <em>Basic Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintImpl
		 * @see uma.caosd.rhea.BasicConstraintsFMmetamodel.impl.BasicConstraintsFMmetamodelPackageImpl#getBasicConstraint()
		 * @generated
		 */
		EClass BASIC_CONSTRAINT = eINSTANCE.getBasicConstraint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_CONSTRAINT__TYPE = eINSTANCE.getBasicConstraint_Type();

		/**
		 * The meta object literal for the '<em><b>Right Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_CONSTRAINT__RIGHT_FEATURE = eINSTANCE.getBasicConstraint_RightFeature();

		/**
		 * The meta object literal for the '<em><b>Left Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_CONSTRAINT__LEFT_FEATURE = eINSTANCE.getBasicConstraint_LeftFeature();

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
