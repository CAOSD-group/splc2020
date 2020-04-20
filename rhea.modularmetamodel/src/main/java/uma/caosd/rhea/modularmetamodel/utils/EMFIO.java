package uma.caosd.rhea.modularmetamodel.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


/**
 * Input/ouput (serialization) for EMF models (.xmi) and metamodels (.ecore).
 * 
 * @author Jose Miguel Horcas
 */
public class EMFIO {

	public static void saveModel(EObject model, List<EPackage> metamodels, String filepath) throws IOException {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// Register the appropriate resource factory to handle all file extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		// Register the package to make it available during loading.
		for (EPackage mm : metamodels) {
			resourceSet.getPackageRegistry().put(mm.getNsURI(), mm);
		}
		
		// Create a new empty resource.
		Resource resource = resourceSet.createResource(URI.createFileURI(filepath));		
		
		// Set options for the resource
		((XMIResource) resource).getDefaultSaveOptions().put(XMIResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
		((XMIResource) resource).getDefaultSaveOptions().put(XMIResource.OPTION_ENCODING, "UTF-8");
		HashMap<String, Object> opts = new HashMap<String, Object>();
		opts.put(XMIResource.OPTION_SCHEMA_LOCATION, true);
		
		// Add the root object to a resource and save it.
		resource.getContents().add(model);
		resource.save(opts);
	}
	
	public static EObject loadModel(List<EPackage> metamodels, String filepath) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// Register the appropriate resource factory to handle all file extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
				
		// Register the package to make it available during loading.
		for (EPackage mm : metamodels) {
			resourceSet.getPackageRegistry().put(mm.getNsURI(), mm);
		}
		
		// Demand load the resource into the resource set.
		Resource resource = resourceSet.getResource(URI.createFileURI(filepath), true);
				
		// Extract the root object from the resource.
		EObject model = resource.getContents().get(0);
		
		return model;
	}
	
	public static void saveMetamodel(EObject metamodel, String filepath) throws IOException {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();
			
		// Create a new empty resource.
		Resource resource = resourceSet.createResource(URI.createFileURI(filepath));
		
		// Register the appropriate resource factory to handle all file extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		
		// Register the package to make it available during loading.
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
				
		// Set options for the resource
		((XMIResource) resource).getDefaultSaveOptions().put(XMIResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
		((XMIResource) resource).getDefaultSaveOptions().put(XMIResource.OPTION_ENCODING, "UTF-8");
		
		
		
		// Add the root object to a resource and save it.
		resource.getContents().add(metamodel);
		
		EcoreUtil.resolveAll(resourceSet);
		resource.save(null);
	}
	
	public static EObject loadMetamodel(String filepath) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();
		// Register the appropriate resource factory to handle all file extensions. Resource.Factory.Registry.DEFAULT_EXTENSION
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		
		// Register the package to make it available during loading.
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
		// Demand load the resource into the resource set.
		Resource resource = resourceSet.getResource(URI.createFileURI(filepath), true);
		
		// Extract the root object from the resource.
		EObject model = resource.getContents().get(0);
		
		EcoreUtil.resolveAll(resourceSet);
		return model;
	}
}
