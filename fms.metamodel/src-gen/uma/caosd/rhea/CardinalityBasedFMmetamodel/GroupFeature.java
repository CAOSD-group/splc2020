/**
 */
package uma.caosd.rhea.CardinalityBasedFMmetamodel;

import uma.caosd.rhea.BasicFMmetamodel.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature#getLower <em>Lower</em>}</li>
 *   <li>{@link uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature#getUpper <em>Upper</em>}</li>
 * </ul>
 *
 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.CardinalityBasedFMmetamodelPackage#getGroupFeature()
 * @model
 * @generated
 */
public interface GroupFeature extends Feature {
	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.CardinalityBasedFMmetamodelPackage#getGroupFeature_Lower()
	 * @model
	 * @generated
	 */
	int getLower();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(int value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(int)
	 * @see uma.caosd.rhea.CardinalityBasedFMmetamodel.CardinalityBasedFMmetamodelPackage#getGroupFeature_Upper()
	 * @model
	 * @generated
	 */
	int getUpper();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.CardinalityBasedFMmetamodel.GroupFeature#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(int value);

} // GroupFeature
