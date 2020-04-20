/**
 */
package uma.caosd.rhea.BasicConstraints.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uma.caosd.rhea.BasicConstraints.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasicConstraintsFactoryImpl extends EFactoryImpl implements BasicConstraintsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicConstraintsFactory init() {
		try {
			BasicConstraintsFactory theBasicConstraintsFactory = (BasicConstraintsFactory)EPackage.Registry.INSTANCE.getEFactory(BasicConstraintsPackage.eNS_URI);
			if (theBasicConstraintsFactory != null) {
				return theBasicConstraintsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BasicConstraintsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicConstraintsFactoryImpl() {
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
			case BasicConstraintsPackage.REQUIRES: return createREQUIRES();
			case BasicConstraintsPackage.EXCLUDES: return createEXCLUDES();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public REQUIRES createREQUIRES() {
		REQUIRESImpl requires = new REQUIRESImpl();
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EXCLUDES createEXCLUDES() {
		EXCLUDESImpl excludes = new EXCLUDESImpl();
		return excludes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicConstraintsPackage getBasicConstraintsPackage() {
		return (BasicConstraintsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BasicConstraintsPackage getPackage() {
		return BasicConstraintsPackage.eINSTANCE;
	}

} //BasicConstraintsFactoryImpl
