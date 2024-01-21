package org.mql.java.complements;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
/*
public class MyInterfaces {

    public static void extractAndPrintInterfaces(String projectPath) {
        try {
            Path projectRoot = Paths.get(projectPath);

            if (!Files.exists(projectRoot) || !Files.isDirectory(projectRoot)) {
                System.out.println("Le chemin du projet n'est pas valide : " + projectPath);
                return;
            }

            Files.walk(projectRoot)
                    .filter(path -> path.toString().endsWith(".class"))
                    .forEach(MyInterfaces::processClassFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processClassFile(Path classFilePath) {
        try {
            String className = extractClassName(classFilePath);
            Class<?> clazz = Class.forName(className);
            Class<?>[] interfaces = clazz.getInterfaces();

            if (interfaces.length > 0) {
                System.out.println("Interfaces pour la classe " + className + ":");
                for (Class<?> anInterface : interfaces) {
                    System.out.println("- " + anInterface.getName());
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String extractClassName(Path classFilePath) {
        String separator = File.separator;
        String path = classFilePath.toString();
        int start = path.lastIndexOf("classes" + separator) + 8;
        int end = path.length() - 6; // ".class".length() == 6
        return path.substring(start, end).replace(separator, ".");
    }

    public static void main(String[] args) {
        // Exemple d'utilisation
        extractAndPrintInterfaces("C:\\Users\\hp\\eclipse-workspace\\P04_XML_Parsers");
    }
}
*/