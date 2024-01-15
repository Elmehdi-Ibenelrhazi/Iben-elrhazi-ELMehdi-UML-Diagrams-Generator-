package org.mql.java.Extractor;

import java.io.File;

import org.mql.java.complements.MyEnums;
import org.mql.java.Extractor.ProjectAnalyzer;

public class ProcessJavaFile {

	public ProcessJavaFile() {
		// TODO Auto-generated constructor stub
	}
	public void traverseProject(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    traverseProject(subFile);
                }
            }
        } else {
            // Traitez le fichier ici
            if (file.getName().endsWith(".java")) {
                ProcessJavaFile.processJavaFile(file);
            }
        }
    }

	public static void processJavaFile(File javaFile) {
        String packageName = ProjectAnalyzer.extractPackageName(javaFile);

        // Vérifie si le package a déjà été traité
        if (!ProjectAnalyzer.processedPackages.contains(packageName)) {
            // Nouveau package, affiche le package
            System.out.println("File: " + javaFile.getAbsolutePath());
            System.out.println("Package: " + packageName);
            ProjectAnalyzer.processedPackages.add(packageName);
        }

        // Affiche le nom de la classe
        String className = ProjectAnalyzer.extractClassName(javaFile);
        System.out.println("Class: " + className);
        String interfaceName = ProjectAnalyzer.extractInterfaceName(javaFile);
        if(interfaceName != null) {
        	System.out.println("Interface :" + interfaceName);
        }
        
        String annotationName = ProjectAnalyzer.extractAnnotation(javaFile);
        if(annotationName != null) {
        	System.out.println("Annotation : "+annotationName);
        }
        String enumName = MyEnums.extractEnumName(javaFile);
        if (enumName != null) {
            System.out.println("Enum: " + enumName);
        }
    }
    

}
