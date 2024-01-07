package org.mql.java.Extractor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProjectAnalyzer {

	public static void TraverseProject ( File file) {

		if(file.isDirectory()) {

			File[] files = file.listFiles();
			if(files != null) {
				for (File file2 : files) {
					TraverseProject(file2);
				}
			}
			
 
}
		else {
			if(file.getName().endsWith(".java")) {
				processJavaFile(file);
			}
			
		}
	
}
	public static void processJavaFile (File javaFile) {
		
		System.out.println("File :" + javaFile.getAbsolutePath());
		
		String packageName = extractPackageName(javaFile);
		System.out.println("Package :" +packageName);
		List<String> classNames = new ArrayList<>();
		 extractClassName(javaFile, classNames);
		System.out.println("Classes :");
		
		//afficher les noms des classes separes
		for( String className : classNames) {
			System.out.println(className + " |");
		}
		
		
	}
	
	private static String extractPackageName(File javaFile) {
	    // Obtient le chemin absolu du fichier Java
	    String filePath = javaFile.getAbsolutePath();

	    // Obtient le chemin absolu du répertoire src
	    String srcPath = new File(javaFile.getParentFile(), "src").getAbsolutePath();

	    // Supprime le chemin du répertoire src du chemin absolu du fichier Java
	    String relativePath = filePath.substring(srcPath.length() + 1); // +1 pour éviter le séparateur initial

	    // Remplace les séparateurs de fichiers par des points pour obtenir le nom du package
	    String packageName = relativePath.replace(File.separator, ".");

	    // Supprime l'extension .java
	    packageName = packageName.substring(0, packageName.length() - ".java".length());

	    return packageName;
	}



	private static String extractClassName(File javaFile, List<String> classNames) {
	    // Obtient le nom du fichier Java sans le chemin absolu
	    String fileName = javaFile.getName();

	    // Supprime l'extension .java pour obtenir le nom de la classe
	    String className = fileName.substring(0, fileName.length() - ".java".length());

	    classNames.add(className);
	    return className;
	}

}	
	
 