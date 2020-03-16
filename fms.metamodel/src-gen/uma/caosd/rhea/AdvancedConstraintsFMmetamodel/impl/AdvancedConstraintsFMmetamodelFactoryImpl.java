/**
 */
package uma.caosd.rhea.AdvancedConstraintsFMmetamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uma.caosd.rhea.AdvancedConstraintsFMmetamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AdvancedConstraintsFMmetamodelFactoryImpl extends EFactoryImpl implements AdvancedConstraintsFMmetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AdvancedConstraintsFMmetamodelFactory init() {
		try {
			AdvancedConstraintsFMmetamodelFactory theAdvancedConstraintsFMmetamodelFactory = (AdvancedConstraintsFMmetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(AdvancedConstraintsFMmetamodelPackage.eNS_URI);
			if (theAdvancedConstraintsFMmetamodelFactory != null) {
				return theAdvancedConstraintsFMmetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AdvancedConstraintsFMmetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedConstraintsFMmetamodelFactoryImpl() {
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
			case AdvancedConstraintsFMmetamodelPackage.ADVANCED_CONSTRAINT: return createAdvancedConstraint();
			case AdvancedConstraintsFMmetamodelPackage.TERM: return createTerm();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case AdvancedConstraintsFMmetamodelPackage.TERM_TYPE:
				return createTermTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case AdvancedConstraintsFMmetamodelPackage.TERM_TYPE:
				return convertTermTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedConstraint createAdvancedConstraint() {
		AdvancedConstraintImpl advancedConstraint = new AdvancedConstraintImpl();
		return advancedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term createTerm() {
		TermImpl term = new TermImpl();
		return term;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermType createTermTypeFromString(EDataType eDataType, String initialValue) {
		TermType result = TermType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTermTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedConstraintsFMmetamodelPackage getAdvancedConstraintsFMmetamodelPackage() {
		return (AdvancedConstraintsFMmetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AdvancedConstraintsFMmetamodelPackage getPackage() {
		return AdvancedConstraintsFMmetamodelPackage.eINSTANCE;
	}

} //AdvancedConstraintsFMmetamodelFactoryImpl
