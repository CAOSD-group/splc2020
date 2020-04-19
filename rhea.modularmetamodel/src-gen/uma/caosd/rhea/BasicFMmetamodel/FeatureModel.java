/**
 */
package uma.caosd.rhea.BasicFMmetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.FeatureModel#getName <em>Name</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.FeatureModel#getRoot <em>Root</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.FeatureModel#getFeatures <em>Features</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.FeatureModel#getCrossTreeConstraints <em>Cross Tree Constraints</em>}</li>
 * </ul>
 *
 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeatureModel()
 * @model
 * @generated
 */
public interface FeatureModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeatureModel_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.BasicFMmetamodel.FeatureModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(Feature)
	 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeatureModel_Root()
	 * @model containment="true"
	 * @generated
	 */
	Feature getRoot();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.BasicFMmetamodel.FeatureModel#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Feature value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link uma.caosd.rhea.BasicFMmetamodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeatureModel_Features()
	 * @model
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Cross Tree Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link uma.caosd.rhea.BasicFMmetamodel.CrossTreeConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Tree Constraints</em>' containment reference list.
	 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeatureModel_CrossTreeConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<CrossTreeConstraint> getCrossTreeConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Feature getFeature(String id);

} // FeatureModel
