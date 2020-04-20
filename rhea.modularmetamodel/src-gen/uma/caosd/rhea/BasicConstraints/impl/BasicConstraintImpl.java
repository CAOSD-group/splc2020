/**
 */
package uma.caosd.rhea.BasicConstraints.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uma.caosd.rhea.BasicConstraints.BasicConstraint;
import uma.caosd.rhea.BasicConstraints.BasicConstraintsPackage;

import uma.caosd.rhea.BasicFMmetamodel.Feature;

import uma.caosd.rhea.BasicFMmetamodel.impl.CrossTreeConstraintImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.BasicConstraints.impl.BasicConstraintImpl#getLeftFeature <em>Left Feature</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicConstraints.impl.BasicConstraintImpl#getRightFeature <em>Right Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BasicConstraintImpl extends CrossTreeConstraintImpl implements BasicConstraint {
	/**
	 * The cached value of the '{@link #getLeftFeature() <em>Left Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature leftFeature;

	/**
	 * The cached value of the '{@link #getRightFeature() <em>Right Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature rightFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasicConstraintsPackage.Literals.BASIC_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getLeftFeature() {
		if (leftFeature != null && leftFeature.eIsProxy()) {
			InternalEObject oldLeftFeature = (InternalEObject)leftFeature;
			leftFeature = (Feature)eResolveProxy(oldLeftFeature);
			if (leftFeature != oldLeftFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BasicConstraintsPackage.BASIC_CONSTRAINT__LEFT_FEATURE, oldLeftFeature, leftFeature));
			}
		}
		return leftFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetLeftFeature() {
		return leftFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftFeature(Feature newLeftFeature) {
		Feature oldLeftFeature = leftFeature;
		leftFeature = newLeftFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasicConstraintsPackage.BASIC_CONSTRAINT__LEFT_FEATURE, oldLeftFeature, leftFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getRightFeature() {
		if (rightFeature != null && rightFeature.eIsProxy()) {
			InternalEObject oldRightFeature = (InternalEObject)rightFeature;
			rightFeature = (Feature)eResolveProxy(oldRightFeature);
			if (rightFeature != oldRightFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BasicConstraintsPackage.BASIC_CONSTRAINT__RIGHT_FEATURE, oldRightFeature, rightFeature));
			}
		}
		return rightFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetRightFeature() {
		return rightFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightFeature(Feature newRightFeature) {
		Feature oldRightFeature = rightFeature;
		rightFeature = newRightFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasicConstraintsPackage.BASIC_CONSTRAINT__RIGHT_FEATURE, oldRightFeature, rightFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasicConstraintsPackage.BASIC_CONSTRAINT__LEFT_FEATURE:
				if (resolve) return getLeftFeature();
				return basicGetLeftFeature();
			case BasicConstraintsPackage.BASIC_CONSTRAINT__RIGHT_FEATURE:
				if (resolve) return getRightFeature();
				return basicGetRightFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BasicConstraintsPackage.BASIC_CONSTRAINT__LEFT_FEATURE:
				setLeftFeature((Feature)newValue);
				return;
			case BasicConstraintsPackage.BASIC_CONSTRAINT__RIGHT_FEATURE:
				setRightFeature((Feature)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BasicConstraintsPackage.BASIC_CONSTRAINT__LEFT_FEATURE:
				setLeftFeature((Feature)null);
				return;
			case BasicConstraintsPackage.BASIC_CONSTRAINT__RIGHT_FEATURE:
				setRightFeature((Feature)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BasicConstraintsPackage.BASIC_CONSTRAINT__LEFT_FEATURE:
				return leftFeature != null;
			case BasicConstraintsPackage.BASIC_CONSTRAINT__RIGHT_FEATURE:
				return rightFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //BasicConstraintImpl
