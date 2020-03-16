/**
 */
package uma.caosd.rhea.BasicFMmetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.Feature#getId <em>Id</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.Feature#getName <em>Name</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.Feature#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.Feature#getChildren <em>Children</em>}</li>
 *   <li>{@link uma.caosd.rhea.BasicFMmetamodel.Feature#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeature_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.BasicFMmetamodel.Feature#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeature_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.BasicFMmetamodel.Feature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mandatory</em>' attribute.
	 * @see #setMandatory(boolean)
	 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeature_Mandatory()
	 * @model required="true"
	 * @generated
	 */
	boolean isMandatory();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.BasicFMmetamodel.Feature#isMandatory <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mandatory</em>' attribute.
	 * @see #isMandatory()
	 * @generated
	 */
	void setMandatory(boolean value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link uma.caosd.rhea.BasicFMmetamodel.Feature}.
	 * It is bidirectional and its opposite is '{@link uma.caosd.rhea.BasicFMmetamodel.Feature#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeature_Children()
	 * @see uma.caosd.rhea.BasicFMmetamodel.Feature#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Feature> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link uma.caosd.rhea.BasicFMmetamodel.Feature#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Feature)
	 * @see uma.caosd.rhea.BasicFMmetamodel.BasicFMmetamodelPackage#getFeature_Parent()
	 * @see uma.caosd.rhea.BasicFMmetamodel.Feature#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	Feature getParent();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.BasicFMmetamodel.Feature#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Feature value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isLeaf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isRoot();

} // Feature
