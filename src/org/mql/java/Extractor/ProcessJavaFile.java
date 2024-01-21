package org.mql.java.Extractor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class ProcessJavaFile {
	
	public ProcessJavaFile() {
		
	}
	
	
	public static void processJavaFile(File javaFile, ProjectAnalyzer projectAnalyzer) {
	    String packageName = ProjectAnalyzer.extractPackageName(javaFile);
	    
	    if (!ProjectAnalyzer.processedPackages.contains(packageName)) {
	        System.out.println("File: " + javaFile.getAbsolutePath());
	        System.out.println("Package: " + packageName);
	        ProjectAnalyzer.processedPackages.add(packageName);
	    }
	    
	    
	    String className = ProjectAnalyzer.extractClassName(javaFile);
	    System.out.println("Class: " + className);
	 // Ajouter la classe au package correspondant dans le Map
	       ProjectAnalyzer.addProcessedPackage(packageName);
	        ProjectAnalyzer.addPackageClass(packageName, className);
	        
	        try {
	            Class<?> cls = Class.forName(className);
	            if (cls != null) {
	                List<String> interfaces = ProjectAnalyzer.extractInterfaces(cls);
	                if (!interfaces.isEmpty()) {
	                    System.out.println("Interfaces:");
	                    for (String interfaceName : interfaces) {
	                        System.out.println(interfaceName);
	                    }
	                }

	                System.out.println();
	            }
	            
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	    
	    /*
	  //Extract interfaces
	    try {
	        Class<?> loadedClass = ProjectAnalyzer.loadClass(className);
	        // Now, you can use loadedClass as needed, for example, to get interfaces
	        projectAnalyzer.extractInterfaces(loadedClass).forEach(interfaceName ->
	            System.out.println("Interface: " + interfaceName)
	        );

	        // Continue processing as needed
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        // Handle the exception (e.g., log or take appropriate action)
	    
	    }
      //  ProjectAnalyzer.addProcessedClass(className);
       // System.out.println("ProcessJavaFile - Classe détectée : " + className);

	  */
	    
	 
        
	    
	}}
	    
	  //ProjectAnalyzer.extractInterfaceName(javaFile);

    
	
	
	     //   ProjectAnalyzer.addRelations(new Relation("Implements", className, interfaceName));
	    
/*
	    if (MyAnnotations.hasAnnotations(javaFile)) {
	        String annotationName = className;
	        System.out.println("Annotation: " + annotationName);
	      //  projectAnalyzer.addRelations(new Relation("Annotates", className, annotationName));
	    }

	    String enumName = MyEnums.extractEnumName(javaFile);
	    if (enumName != null) {
	        System.out.println("Enum: " + enumName);
	       // projectAnalyzer.addRelations(new Relation("HasEnum", className, enumName));
	    }*/
	

	/*public static void processJavaFile(File javaFile, ProjectAnalyzer projectAnalyzer) {
        String packageName = ProjectAnalyzer.extractPackageName(javaFile);
        if (!ProjectAnalyzer.processedPackages.contains(packageName)) {
            System.out.println("File: " + javaFile.getAbsolutePath());
            System.out.println("Package: " + packageName);
            ProjectAnalyzer.processedPackages.add(packageName);
        }
        String className = ProjectAnalyzer.extractClassName(javaFile);
        System.out.println("Class: " + className);
        String interfaceName = ProjectAnalyzer.extractInterfaceName(javaFile);
        if(interfaceName != null) {
        	System.out.println("Interface :" + interfaceName);
        	projectAnalyzer.addRelations(new Relation("Implements", className,interfaceName));
        }
        
        String annotationName = ProjectAnalyzer.extractAnnotation(javaFile);
        if(annotationName != null) {
        	System.out.println("Annotation : "+annotationName);
        	projectAnalyzer.addRelations(new Relation("Annotates", className,annotationName));
        }
        String enumName = MyEnums.extractEnumName(javaFile);
        if (enumName != null) {
            System.out.println("Enum: " + enumName);
            projectAnalyzer.addRelations(new Relation("HasEnum", className,enumName));
        }
        
        
    }
    

}
*/