/**
 */
package uma.caosd.rhea.BasicConstraintsFMmetamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uma.caosd.rhea.BasicConstraintsFMmetamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasicConstraintsFMmetamodelFactoryImpl extends EFactoryImpl implements BasicConstraintsFMmetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicConstraintsFMmetamodelFactory init() {
		try {
			BasicConstraintsFMmetamodelFactory theBasicConstraintsFMmetamodelFactory = (BasicConstraintsFMmetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(BasicConstraintsFMmetamodelPackage.eNS_URI);
			if (theBasicConstraintsFMmetamodelFactory != null) {
				return theBasicConstraintsFMmetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BasicConstraintsFMmetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicConstraintsFMmetamodelFactoryImpl() {
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
			case BasicConstraintsFMmetamodelPackage.CROSS_TREE_CONSTRAINT: return createCrossTreeConstraint();
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
			case BasicConstraintsFMmetamodelPackage.CROSS_TREE_CONSTRAINT_TYPE:
				return createCrossTreeConstraintTypeFromString(eDataType, initialValue);
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
			case BasicConstraintsFMmetamodelPackage.CROSS_TREE_CONSTRAINT_TYPE:
				return convertCrossTreeConstraintTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrossTreeConstraint createCrossTreeConstraint() {
		CrossTreeConstraintImpl crossTreeConstraint = new CrossTreeConstraintImpl();
		return crossTreeConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrossTreeConstraintType createCrossTreeConstraintTypeFromString(EDataType eDataType, String initialValue) {
		CrossTreeConstraintType result = CrossTreeConstraintType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCrossTreeConstraintTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicConstraintsFMmetamodelPackage getBasicConstraintsFMmetamodelPackage() {
		return (BasicConstraintsFMmetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BasicConstraintsFMmetamodelPackage getPackage() {
		return BasicConstraintsFMmetamodelPackage.eINSTANCE;
	}

} //BasicConstraintsFMmetamodelFactoryImpl
