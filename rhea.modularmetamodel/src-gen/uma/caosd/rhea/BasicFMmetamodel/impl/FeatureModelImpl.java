/**
 */
package uma.caosd.rhea.BasicFMmetamodel.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage;
import uma.caosd.rhea.BasicFMmetamodel.CrossTreeConstraint;
import uma.caosd.rhea.BasicFMmetamodel.Feature;
import uma.caosd.rhea.BasicFMmetamodel.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.impl.FeatureModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.impl.FeatureModelImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.impl.FeatureModelImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.impl.FeatureModelImpl#getCrossTreeConstraints <em>Cross Tree Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureModelImpl extends MinimalEObjectImpl.Container implements FeatureModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected Feature root;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * The cached value of the '{@link #getCrossTreeConstraints() <em>Cross Tree Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCrossTreeConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<CrossTreeConstraint> crossTreeConstraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasicFMmetamodelPackage.Literals.FEATURE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasicFMmetamodelPackage.FEATURE_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoot(Feature newRoot, NotificationChain msgs) {
		Feature oldRoot = root;
		root = newRoot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BasicFMmetamodelPackage.FEATURE_MODEL__ROOT, oldRoot, newRoot);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(Feature newRoot) {
		if (newRoot != root) {
			NotificationChain msgs = null;
			if (root != null)
				msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BasicFMmetamodelPackage.FEATURE_MODEL__ROOT, null, msgs);
			if (newRoot != null)
				msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BasicFMmetamodelPackage.FEATURE_MODEL__ROOT, null, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasicFMmetamodelPackage.FEATURE_MODEL__ROOT, newRoot, newRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectResolvingEList<Feature>(Feature.class, this, BasicFMmetamodelPackage.FEATURE_MODEL__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CrossTreeConstraint> getCrossTreeConstraints() {
		if (crossTreeConstraints == null) {
			crossTreeConstraints = new EObjectContainmentEList<CrossTreeConstraint>(CrossTreeConstraint.class, this, BasicFMmetamodelPackage.FEATURE_MODEL__CROSS_TREE_CONSTRAINTS);
		}
		return crossTreeConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Feature getFeature(String id) {
		Optional<Feature> o = getFeatures().stream().filter(f -> f.getId().equals(id)).findFirst();
		return o.isPresent() ? o.get() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasicFMmetamodelPackage.FEATURE_MODEL__ROOT:
				return basicSetRoot(null, msgs);
			case BasicFMmetamodelPackage.FEATURE_MODEL__CROSS_TREE_CONSTRAINTS:
				return ((InternalEList<?>)getCrossTreeConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasicFMmetamodelPackage.FEATURE_MODEL__NAME:
				return getName();
			case BasicFMmetamodelPackage.FEATURE_MODEL__ROOT:
				return getRoot();
			case BasicFMmetamodelPackage.FEATURE_MODEL__FEATURES:
				return getFeatures();
			case BasicFMmetamodelPackage.FEATURE_MODEL__CROSS_TREE_CONSTRAINTS:
				return getCrossTreeConstraints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BasicFMmetamodelPackage.FEATURE_MODEL__NAME:
				setName((String)newValue);
				return;
			case BasicFMmetamodelPackage.FEATURE_MODEL__ROOT:
				setRoot((Feature)newValue);
				return;
			case BasicFMmetamodelPackage.FEATURE_MODEL__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case BasicFMmetamodelPackage.FEATURE_MODEL__CROSS_TREE_CONSTRAINTS:
				getCrossTreeConstraints().clear();
				getCrossTreeConstraints().addAll((Collection<? extends CrossTreeConstraint>)newValue);
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
			case BasicFMmetamodelPackage.FEATURE_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BasicFMmetamodelPackage.FEATURE_MODEL__ROOT:
				setRoot((Feature)null);
				return;
			case BasicFMmetamodelPackage.FEATURE_MODEL__FEATURES:
				getFeatures().clear();
				return;
			case BasicFMmetamodelPackage.FEATURE_MODEL__CROSS_TREE_CONSTRAINTS:
				getCrossTreeConstraints().clear();
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
			case BasicFMmetamodelPackage.FEATURE_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BasicFMmetamodelPackage.FEATURE_MODEL__ROOT:
				return root != null;
			case BasicFMmetamodelPackage.FEATURE_MODEL__FEATURES:
				return features != null && !features.isEmpty();
			case BasicFMmetamodelPackage.FEATURE_MODEL__CROSS_TREE_CONSTRAINTS:
				return crossTreeConstraints != null && !crossTreeConstraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BasicFMmetamodelPackage.FEATURE_MODEL___GET_FEATURE__STRING:
				return getFeature((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //FeatureModelImpl
