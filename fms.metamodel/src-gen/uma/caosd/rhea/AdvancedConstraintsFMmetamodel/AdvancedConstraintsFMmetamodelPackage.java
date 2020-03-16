/**
 */
package uma.caosd.rhea.AdvancedConstraintsFMmetamodel;

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
 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface AdvancedConstraintsFMmetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "AdvancedConstraintsFMmetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://caosd.lcc.uma.es/AdvancedConstraintsFMmetamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "AdvancedConstraintsFMmetamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AdvancedConstraintsFMmetamodelPackage eINSTANCE = uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintsFMmetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintImpl <em>Advanced Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintImpl
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintsFMmetamodelPackageImpl#getAdvancedConstraint()
	 * @generated
	 */
	int ADVANCED_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_CONSTRAINT__ID = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_CONSTRAINT__TERM = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Advanced Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_CONSTRAINT_FEATURE_COUNT = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Advanced Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_CONSTRAINT_OPERATION_COUNT = BasicFMmetamodelPackage.CROSS_TREE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.TermImpl
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintsFMmetamodelPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__OPERANDS = 1;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__FEATURE = 2;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.TermType <em>Term Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.TermType
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintsFMmetamodelPackageImpl#getTermType()
	 * @generated
	 */
	int TERM_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint <em>Advanced Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advanced Constraint</em>'.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint
	 * @generated
	 */
	EClass getAdvancedConstraint();

	/**
	 * Returns the meta object for the attribute '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint#getId()
	 * @see #getAdvancedConstraint()
	 * @generated
	 */
	EAttribute getAdvancedConstraint_Id();

	/**
	 * Returns the meta object for the containment reference '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint#getTerm()
	 * @see #getAdvancedConstraint()
	 * @generated
	 */
	EReference getAdvancedConstraint_Term();

	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for the attribute '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getType()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getOperands()
	 * @see #getTerm()
	 * @generated
	 */
	EReference getTerm_Operands();

	/**
	 * Returns the meta object for the reference '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term#getFeature()
	 * @see #getTerm()
	 * @generated
	 */
	EReference getTerm_Feature();

	/**
	 * Returns the meta object for enum '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.TermType <em>Term Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Term Type</em>'.
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.TermType
	 * @generated
	 */
	EEnum getTermType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AdvancedConstraintsFMmetamodelFactory getAdvancedConstraintsFMmetamodelFactory();

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
		 * The meta object literal for the '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintImpl <em>Advanced Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintImpl
		 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintsFMmetamodelPackageImpl#getAdvancedConstraint()
		 * @generated
		 */
		EClass ADVANCED_CONSTRAINT = eINSTANCE.getAdvancedConstraint();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADVANCED_CONSTRAINT__ID = eINSTANCE.getAdvancedConstraint_Id();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_CONSTRAINT__TERM = eINSTANCE.getAdvancedConstraint_Term();

		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.TermImpl
		 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintsFMmetamodelPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__TYPE = eINSTANCE.getTerm_Type();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM__OPERANDS = eINSTANCE.getTerm_Operands();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM__FEATURE = eINSTANCE.getTerm_Feature();

		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.AdvancedConstraintsFMmetamodel.TermType <em>Term Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.TermType
		 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl.AdvancedConstraintsFMmetamodelPackageImpl#getTermType()
		 * @generated
		 */
		EEnum TERM_TYPE = eINSTANCE.getTermType();

	}

} //AdvancedConstraintsFMmetamodelPackage
