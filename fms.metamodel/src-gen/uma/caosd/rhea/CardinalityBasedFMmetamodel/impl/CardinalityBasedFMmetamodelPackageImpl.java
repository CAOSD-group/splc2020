/**
 */
package uma.caosd.rhea.CardinalityBasedFMmetamodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;

import uma.caosd.rhea.CardinalityBasedFMmetamodel.CardinalityBasedFMmetamodelFactory;
import uma.caosd.rhea.CardinalityBasedFMmetamodel.CardinalityBasedFMmetamodelPackage;
import uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CardinalityBasedFMmetamodelPackageImpl extends EPackageImpl implements CardinalityBasedFMmetamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupFeatureEClass = null;

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
	 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.CardinalityBasedFMmetamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CardinalityBasedFMmetamodelPackageImpl() {
		super(eNS_URI, CardinalityBasedFMmetamodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CardinalityBasedFMmetamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CardinalityBasedFMmetamodelPackage init() {
		if (isInited) return (CardinalityBasedFMmetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(CardinalityBasedFMmetamodelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCardinalityBasedFMmetamodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CardinalityBasedFMmetamodelPackageImpl theCardinalityBasedFMmetamodelPackage = registeredCardinalityBasedFMmetamodelPackage instanceof CardinalityBasedFMmetamodelPackageImpl ? (CardinalityBasedFMmetamodelPackageImpl)registeredCardinalityBasedFMmetamodelPackage : new CardinalityBasedFMmetamodelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasicFMmetamodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCardinalityBasedFMmetamodelPackage.createPackageContents();

		// Initialize created meta-data
		theCardinalityBasedFMmetamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCardinalityBasedFMmetamodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CardinalityBasedFMmetamodelPackage.eNS_URI, theCardinalityBasedFMmetamodelPackage);
		return theCardinalityBasedFMmetamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupFeature() {
		return groupFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupFeature_Lower() {
		return (EAttribute)groupFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupFeature_Upper() {
		return (EAttribute)groupFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityBasedFMmetamodelFactory getCardinalityBasedFMmetamodelFactory() {
		return (CardinalityBasedFMmetamodelFactory)getEFactoryInstance();
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
		groupFeatureEClass = createEClass(GROUP_FEATURE);
		createEAttribute(groupFeatureEClass, GROUP_FEATURE__LOWER);
		createEAttribute(groupFeatureEClass, GROUP_FEATURE__UPPER);
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
		groupFeatureEClass.getESuperTypes().add(theBasicFMmetamodelPackage.getFeature());

		// Initialize classes, features, and operations; add parameters
		initEClass(groupFeatureEClass, GroupFeature.class, "GroupFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGroupFeature_Lower(), ecorePackage.getEInt(), "lower", null, 0, 1, GroupFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupFeature_Upper(), ecorePackage.getEInt(), "upper", null, 0, 1, GroupFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CardinalityBasedFMmetamodelPackageImpl
