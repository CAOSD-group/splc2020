/**
 */
package uma.caosd.rhea.BasicConstraints;

import org.eclipse.emf.ecore.EClass;
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
 * @see uma.caosd.rhea.BasicConstraints.BasicConstraintsFactory
 * @model kind="package"
 * @generated
 */
public interface BasicConstraintsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "BasicConstraints";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://caosd.lcc.uma.es/BasicConstraints";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "BasicConstraints";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasicConstraintsPackage eINSTANCE = uma.caosd.rhea.BasicConstraints.impl.BasicConstraintsPackageImpl.init();

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.BasicConstraints.impl.BasicConstraintImpl <em>Basic Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.BasicConstraints.impl.BasicConstraintImpl
	 * @see uma.caosd.rhea.BasicConstraints.impl.BasicConstraintsPackageImpl#getBasicConstraint()
	 * @generated
	 */
	int BASIC_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Left Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT__LEFT_FEATURE = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT__RIGHT_FEATURE = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Basic Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT_FEATURE_COUNT = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Basic Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT_OPERATION_COUNT = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.BasicConstraints.impl.REQUIRESImpl <em>REQUIRES</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.BasicConstraints.impl.REQUIRESImpl
	 * @see uma.caosd.rhea.BasicConstraints.impl.BasicConstraintsPackageImpl#getREQUIRES()
	 * @generated
	 */
	int REQUIRES = 1;

	/**
	 * The feature id for the '<em><b>Left Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES__LEFT_FEATURE = BASIC_CONSTRAINT__LEFT_FEATURE;

	/**
	 * The feature id for the '<em><b>Right Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES__RIGHT_FEATURE = BASIC_CONSTRAINT__RIGHT_FEATURE;

	/**
	 * The number of structural features of the '<em>REQUIRES</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_FEATURE_COUNT = BASIC_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>REQUIRES</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_OPERATION_COUNT = BASIC_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.BasicConstraints.impl.EXCLUDESImpl <em>EXCLUDES</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.BasicConstraints.impl.EXCLUDESImpl
	 * @see uma.caosd.rhea.BasicConstraints.impl.BasicConstraintsPackageImpl#getEXCLUDES()
	 * @generated
	 */
	int EXCLUDES = 2;

	/**
	 * The feature id for the '<em><b>Left Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES__LEFT_FEATURE = BASIC_CONSTRAINT__LEFT_FEATURE;

	/**
	 * The feature id for the '<em><b>Right Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES__RIGHT_FEATURE = BASIC_CONSTRAINT__RIGHT_FEATURE;

	/**
	 * The number of structural features of the '<em>EXCLUDES</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES_FEATURE_COUNT = BASIC_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>EXCLUDES</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES_OPERATION_COUNT = BASIC_CONSTRAINT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.BasicConstraints.BasicConstraint <em>Basic Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Constraint</em>'.
	 * @see uma.caosd.rhea.BasicConstraints.BasicConstraint
	 * @generated
	 */
	EClass getBasicConstraint();

	/**
	 * Returns the meta object for the reference '{@link uma.caosd.rhea.BasicConstraints.BasicConstraint#getLeftFeature <em>Left Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Feature</em>'.
	 * @see uma.caosd.rhea.BasicConstraints.BasicConstraint#getLeftFeature()
	 * @see #getBasicConstraint()
	 * @generated
	 */
	EReference getBasicConstraint_LeftFeature();

	/**
	 * Returns the meta object for the reference '{@link uma.caosd.rhea.BasicConstraints.BasicConstraint#getRightFeature <em>Right Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Feature</em>'.
	 * @see uma.caosd.rhea.BasicConstraints.BasicConstraint#getRightFeature()
	 * @see #getBasicConstraint()
	 * @generated
	 */
	EReference getBasicConstraint_RightFeature();

	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.BasicConstraints.REQUIRES <em>REQUIRES</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>REQUIRES</em>'.
	 * @see uma.caosd.rhea.BasicConstraints.REQUIRES
	 * @generated
	 */
	EClass getREQUIRES();

	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.BasicConstraints.EXCLUDES <em>EXCLUDES</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EXCLUDES</em>'.
	 * @see uma.caosd.rhea.BasicConstraints.EXCLUDES
	 * @generated
	 */
	EClass getEXCLUDES();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BasicConstraintsFactory getBasicConstraintsFactory();

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
		 * The meta object literal for the '{@link uma.caosd.rhea.BasicConstraints.impl.BasicConstraintImpl <em>Basic Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.BasicConstraints.impl.BasicConstraintImpl
		 * @see uma.caosd.rhea.BasicConstraints.impl.BasicConstraintsPackageImpl#getBasicConstraint()
		 * @generated
		 */
		EClass BASIC_CONSTRAINT = eINSTANCE.getBasicConstraint();

		/**
		 * The meta object literal for the '<em><b>Left Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_CONSTRAINT__LEFT_FEATURE = eINSTANCE.getBasicConstraint_LeftFeature();

		/**
		 * The meta object literal for the '<em><b>Right Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_CONSTRAINT__RIGHT_FEATURE = eINSTANCE.getBasicConstraint_RightFeature();

		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.BasicConstraints.impl.REQUIRESImpl <em>REQUIRES</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.BasicConstraints.impl.REQUIRESImpl
		 * @see uma.caosd.rhea.BasicConstraints.impl.BasicConstraintsPackageImpl#getREQUIRES()
		 * @generated
		 */
		EClass REQUIRES = eINSTANCE.getREQUIRES();

		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.BasicConstraints.impl.EXCLUDESImpl <em>EXCLUDES</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.BasicConstraints.impl.EXCLUDESImpl
		 * @see uma.caosd.rhea.BasicConstraints.impl.BasicConstraintsPackageImpl#getEXCLUDES()
		 * @generated
		 */
		EClass EXCLUDES = eINSTANCE.getEXCLUDES();

	}

} //BasicConstraintsPackage
