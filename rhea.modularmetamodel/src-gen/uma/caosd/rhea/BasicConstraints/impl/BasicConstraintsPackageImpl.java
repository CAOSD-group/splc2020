/**
 */
package uma.caosd.rhea.BasicConstraints.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uma.caosd.rhea.BasicConstraints.BasicConstraint;
import uma.caosd.rhea.BasicConstraints.BasicConstraintsFactory;
import uma.caosd.rhea.BasicConstraints.BasicConstraintsPackage;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasicConstraintsPackageImpl extends EPackageImpl implements BasicConstraintsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiresEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass excludesEClass = null;

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
	 * @see uma.caosd.rhea.BasicConstraints.BasicConstraintsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BasicConstraintsPackageImpl() {
		super(eNS_URI, BasicConstraintsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BasicConstraintsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BasicConstraintsPackage init() {
		if (isInited) return (BasicConstraintsPackage)EPackage.Registry.INSTANCE.getEPackage(BasicConstraintsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBasicConstraintsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BasicConstraintsPackageImpl theBasicConstraintsPackage = registeredBasicConstraintsPackage instanceof BasicConstraintsPackageImpl ? (BasicConstraintsPackageImpl)registeredBasicConstraintsPackage : new BasicConstraintsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasicFMmetamodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBasicConstraintsPackage.createPackageContents();

		// Initialize created meta-data
		theBasicConstraintsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBasicConstraintsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BasicConstraintsPackage.eNS_URI, theBasicConstraintsPackage);
		return theBasicConstraintsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicConstraint() {
		return basicConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicConstraint_LeftFeature() {
		return (EReference)basicConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicConstraint_RightFeature() {
		return (EReference)basicConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getREQUIRES() {
		return requiresEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEXCLUDES() {
		return excludesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicConstraintsFactory getBasicConstraintsFactory() {
		return (BasicConstraintsFactory)getEFactoryInstance();
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
		basicConstraintEClass = createEClass(BASIC_CONSTRAINT);
		createEReference(basicConstraintEClass, BASIC_CONSTRAINT__LEFT_FEATURE);
		createEReference(basicConstraintEClass, BASIC_CONSTRAINT__RIGHT_FEATURE);

		requiresEClass = createEClass(REQUIRES);

		excludesEClass = createEClass(EXCLUDES);
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
		basicConstraintEClass.getESuperTypes().add(theBasicFMmetamodelPackage.getCrossTreeConstraint());
		requiresEClass.getESuperTypes().add(this.getBasicConstraint());
		excludesEClass.getESuperTypes().add(this.getBasicConstraint());

		// Initialize classes, features, and operations; add parameters
		initEClass(basicConstraintEClass, BasicConstraint.class, "BasicConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicConstraint_LeftFeature(), theBasicFMmetamodelPackage.getFeature(), null, "leftFeature", null, 1, 1, BasicConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicConstraint_RightFeature(), theBasicFMmetamodelPackage.getFeature(), null, "rightFeature", null, 1, 1, BasicConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requiresEClass, uma.caosd.rhea.BasicConstraints.REQUIRES.class, "REQUIRES", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(excludesEClass, uma.caosd.rhea.BasicConstraints.EXCLUDES.class, "EXCLUDES", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BasicConstraintsPackageImpl
