package org.mql.java.complements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyInterfaces {

	public MyInterfaces() {
		// TODO Auto-generated constructor stub
	}
	public static boolean isInterfaceFile(File javaFile) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(javaFile))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // Vérifie si la ligne contient le mot-clé "interface"
	            if (line.contains("interface")) {
	                return true;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        // Gérer les exceptions
	    }
	    return false;
	}

}
