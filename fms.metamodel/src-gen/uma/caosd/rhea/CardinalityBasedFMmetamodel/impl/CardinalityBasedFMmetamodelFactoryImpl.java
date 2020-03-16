/**
 */
package uma.caosd.rhea.CardinalityBasedFMmetamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uma.caosd.rhea.CardinalityBasedFMmetamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CardinalityBasedFMmetamodelFactoryImpl extends EFactoryImpl implements CardinalityBasedFMmetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CardinalityBasedFMmetamodelFactory init() {
		try {
			CardinalityBasedFMmetamodelFactory theCardinalityBasedFMmetamodelFactory = (CardinalityBasedFMmetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(CardinalityBasedFMmetamodelPackage.eNS_URI);
			if (theCardinalityBasedFMmetamodelFactory != null) {
				return theCardinalityBasedFMmetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CardinalityBasedFMmetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityBasedFMmetamodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CardinalityBasedFMmetamodelPackage.GROUP_FEATURE: return createGroupFeature();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupFeature createGroupFeature() {
		GroupFeatureImpl groupFeature = new GroupFeatureImpl();
		return groupFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityBasedFMmetamodelPackage getCardinalityBasedFMmetamodelPackage() {
		return (CardinalityBasedFMmetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CardinalityBasedFMmetamodelPackage getPackage() {
		return CardinalityBasedFMmetamodelPackage.eINSTANCE;
	}

} //CardinalityBasedFMmetamodelFactoryImpl
