/**
 */
package uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraint;
import uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelFactory;
import uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelPackage;
import uma.caosd.rhea.AdvancedConstraintsFMmetamodel.Term;
import uma.caosd.rhea.AdvancedConstraintsFMmetamodel.TermType;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AdvancedConstraintsFMmetamodelPackageImpl extends EPackageImpl implements AdvancedConstraintsFMmetamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass advancedConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum termTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see uma.caosd.rhea.AdvancedConstraintsFMmetamodel.AdvancedConstraintsFMmetamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AdvancedConstraintsFMmetamodelPackageImpl() {
		super(eNS_URI, AdvancedConstraintsFMmetamodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link AdvancedConstraintsFMmetamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AdvancedConstraintsFMmetamodelPackage init() {
		if (isInited) return (AdvancedConstraintsFMmetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(AdvancedConstraintsFMmetamodelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAdvancedConstraintsFMmetamodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AdvancedConstraintsFMmetamodelPackageImpl theAdvancedConstraintsFMmetamodelPackage = registeredAdvancedConstraintsFMmetamodelPackage instanceof AdvancedConstraintsFMmetamodelPackageImpl ? (AdvancedConstraintsFMmetamodelPackageImpl)registeredAdvancedConstraintsFMmetamodelPackage : new AdvancedConstraintsFMmetamodelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasicFMmetamodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAdvancedConstraintsFMmetamodelPackage.createPackageContents();

		// Initialize created meta-data
		theAdvancedConstraintsFMmetamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAdvancedConstraintsFMmetamodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AdvancedConstraintsFMmetamodelPackage.eNS_URI, theAdvancedConstraintsFMmetamodelPackage);
		return theAdvancedConstraintsFMmetamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdvancedConstraint() {
		return advancedConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdvancedConstraint_Id() {
		return (EAttribute)advancedConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdvancedConstraint_Term() {
		return (EReference)advancedConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerm_Type() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerm_Operands() {
		return (EReference)termEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerm_Feature() {
		return (EReference)termEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTermType() {
		return termTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedConstraintsFMmetamodelFactory getAdvancedConstraintsFMmetamodelFactory() {
		return (AdvancedConstraintsFMmetamodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		advancedConstraintEClass = createEClass(ADVANCED_CONSTRAINT);
		createEAttribute(advancedConstraintEClass, ADVANCED_CONSTRAINT__ID);
		createEReference(advancedConstraintEClass, ADVANCED_CONSTRAINT__TERM);

		termEClass = createEClass(TERM);
		createEAttribute(termEClass, TERM__TYPE);
		createEReference(termEClass, TERM__OPERANDS);
		createEReference(termEClass, TERM__FEATURE);

		// Create enums
		termTypeEEnum = createEEnum(TERM_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BasicFMmetamodelPackage theBasicFMmetamodelPackage = (BasicFMmetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(BasicFMmetamodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		advancedConstraintEClass.getESuperTypes().add(theBasicFMmetamodelPackage.getCrossTreeConstraint());

		// Initialize classes, features, and operations; add parameters
		initEClass(advancedConstraintEClass, AdvancedConstraint.class, "AdvancedConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdvancedConstraint_Id(), ecorePackage.getEString(), "id", null, 0, 1, AdvancedConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdvancedConstraint_Term(), this.getTerm(), null, "term", null, 1, 1, AdvancedConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(termEClass, Term.class, "Term", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerm_Type(), this.getTermType(), "type", "feature", 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerm_Operands(), this.getTerm(), null, "operands", null, 0, -1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerm_Feature(), theBasicFMmetamodelPackage.getFeature(), null, "feature", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(termTypeEEnum, TermType.class, "TermType");
		addEEnumLiteral(termTypeEEnum, TermType.NOT);
		addEEnumLiteral(termTypeEEnum, TermType.EQUIV);
		addEEnumLiteral(termTypeEEnum, TermType.EXCLUDES);
		addEEnumLiteral(termTypeEEnum, TermType.IMPLIES);
		addEEnumLiteral(termTypeEEnum, TermType.AND);
		addEEnumLiteral(termTypeEEnum, TermType.OR);
		addEEnumLiteral(termTypeEEnum, TermType.XOR);
		addEEnumLiteral(termTypeEEnum, TermType.FEATURE);

		// Create resource
		createResource(eNS_URI);
	}

} //AdvancedConstraintsFMmetamodelPackageImpl
