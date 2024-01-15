package org.mql.java.complements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyEnums {

	public MyEnums() {
		// TODO Auto-generated constructor stub
	}
	public static String extractEnumName(File javaFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(javaFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Vérifie si la ligne contient le mot-clé "enum"
                if (line.contains("enum")) {
                    // Supprime l'extension .java pour obtenir le nom de l'énumération
                    return javaFile.getName().substring(0, javaFile.getName().length() - ".java".length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer les exceptions
        }
        return null;
    }
}