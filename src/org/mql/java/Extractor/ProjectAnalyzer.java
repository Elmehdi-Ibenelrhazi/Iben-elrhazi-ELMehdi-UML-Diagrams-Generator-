package org.mql.java.Extractor;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.mql.java.complements.*;

public class ProjectAnalyzer {

    public static Set<String> processedPackages = new HashSet<>();

    

    public void processFileList(File fileList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileList))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ProcessJavaFile.processJavaFile(new File(line.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer les exceptions
        }
    }

    
    

  

	public static String extractPackageName(File javaFile) {
        // Obtient le chemin absolu du fichier Java
        String filePath = javaFile.getAbsolutePath();

        // Obtient le chemin absolu du répertoire src
        String srcPath = new File(javaFile.getParentFile().getParent(), "src").getAbsolutePath();

        // Supprime le chemin du répertoire src du chemin absolu du fichier Java
        String relativePath = filePath.substring(srcPath.length() -3); // +1 pour éviter le séparateur initial

        // Remplace les séparateurs de fichiers par des points pour obtenir le nom du package
       return relativePath.substring(0, relativePath.lastIndexOf(File.separator)).replace(File.separator, ".");
    }

    public static String extractClassName(File javaFile) {
        // Obtient le nom du fichier Java sans le chemin absolu
        String fileName = javaFile.getName();

        // Supprime l'extension .java pour obtenir le nom de la classe
        return fileName.substring(0, fileName.length() - ".java".length());
    }  
    
    
    public static String extractInterfaceName(File javaFile) {
		String filename = javaFile.getName();
		 if (MyInterfaces.isInterfaceFile(javaFile)) {
			return filename.substring(0, filename.length() - ".java".length() );
			
			
		}else {
			return null;
		}
		
	}
    
    public static String extractAnnotation(File javaFile) {
    	String filename = javaFile.getName();
    	if(MyAnnotations.hasAnnotations(javaFile)) {
    		return filename.substring(0, filename.length() - ".java".length());
    	}else 
    		return null;
    }
    
  
    
}
