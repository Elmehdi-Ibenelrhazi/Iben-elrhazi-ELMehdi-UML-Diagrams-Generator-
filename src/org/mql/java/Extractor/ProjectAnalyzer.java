package org.mql.java.Extractor;
import java.io.BufferedReader;
import java.lang.reflect.Modifier;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mql.java.complements.Customloader;
import org.mql.java.complements.MyClass;
import org.mql.java.complements.MyPackage;
import org.mql.java.complements.Project;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ProjectAnalyzer {
	
	private String filePath;
	private Project projet;

    public static Set<String> processedPackages = new HashSet<>(); 
    
    public static Map<String, Set<String>> processedPackagesClasses = new HashMap<>();
    public static Set<String> processedClasses = new HashSet<>();
 // Ajouter une liste pour stocker les instances de ClassInfo
   /// private static List<ClassInfo> classInfoList = new ArrayList<>();
    
    public ProjectAnalyzer(String filePath) {
    	this.filePath = filePath + "\\bin";
    	
    	
    	
    }
    
    
    public Project traverseProject() {
    	File f = new File(filePath);
    	if(!f.exists()) {
    		return null;
    	}
    	projet = new Project(filePath);
        if (f.isDirectory()) {
            File[] files = f.listFiles();
                for (File subFile : files) {
                	if(subFile.isDirectory()) {
                    projet.addPackage(getPackage(subFile));
                }else if(subFile.getName().endsWith(".class")) {
                	projet.addClasse(getClasse(subFile));//changer vers une classe au lieu d'un fichier
                }
                	}
            }
        
		return projet; 
    }
    
    private MyPackage getPackage(File f) {
    	//System.out.println("Packages : " +f.getName());
    	MyPackage p = new MyPackage(f.getName());
    	File[] files = f.listFiles();
    	for (File file : files) {
			if(file.isDirectory()) {
				p.addPackage(getPackage(file));//recursevite
			}
			else if(file.getName().endsWith(".class")) {
				projet.addClasse(getClasse(file));
			}
		}
    	return p;
    }
    
    private MyClass getClasse(File f) {
    	String className = f.getPath().substring(filePath.length() + 1).replace("\\",".").replace(".class", "");
		Class<?> cls = Customloader.loadClass(filePath,className);
    	//System.out.println("Classe : " +cls.getName());
    	MyClass c = new MyClass(cls);
    	return c;
    }
    
	

    
    public void processFileList(File fileList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileList))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ProcessJavaFile.processJavaFile(new File(line.trim()),this);
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


 //extraction des interfaces 
    
    public static List<String> extractInterfaces(Class<?> c) {
		List<String> interfaceList = new LinkedList<String>();
		Class<?> interfaces[] = c.getInterfaces(); 
		if(interfaces.length != 0) {
			
			for(int i = 0 ; i < interfaces .length; i++) {
				interfaceList.add(interfaces[i].getSimpleName());
			}
		}
		return interfaceList;
	}
    /*
    public static Class<?> loadClass(String className) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return Class.forName(className, true, classLoader);
    }

   

    /*
   
    public static String extractInterfaceName(File javaFile) {
        try {
            String className = extractClassName(javaFile);
            Class<?> loadedClass = Class.forName(className);
            List<String> interfaces = MyInterfaces.getInterfaces(loadedClass);

            if (!interfaces.isEmpty()) {
                String interfaceName = className;
                System.out.println("Interface: " + interfaceName);
                return interfaceName;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Gérer l'exception si la classe n'est pas trouvée
        }
        return null;
    }
	
	
	
    
    public static String extractAnnotation(File javaFile) {
    	String filename = javaFile.getName();
    	if(MyAnnotations.hasAnnotations(javaFile)) {
    		return filename.substring(0, filename.length() - ".java".length());
    	}else 
    		return null;
    }
    */
public static Document createXmlDocument(Set<String> processedPackages) throws ParserConfigurationException {
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    Document doc = docBuilder.newDocument();

    Element rootElement = doc.createElement("ProjectInfo");
    doc.appendChild(rootElement);

    for (String packageName : processedPackages) {
        Element packageElement = doc.createElement("Package");
        packageElement.setAttribute("name", packageName);
        rootElement.appendChild(packageElement);
        
        // Récupérer les classes du package à partir du Map
        Set<String> packageClasses = processedPackagesClasses.get(packageName);

        // Vérifier si le package a des classes
        if (packageClasses != null) {
            for (String className : packageClasses) {
                Element classElement = doc.createElement("Class");
                classElement.setAttribute("name", className);
                packageElement.appendChild(classElement);
            }
        }
    }

    return doc;
}


public static void saveXmlDocument(Document doc, String filePath) throws TransformerException {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Ajoutez cette ligne pour activer l'indentation
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); // Nombre d'espaces pour l'indentation
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(new File("resource/Infos.xml"));
    transformer.transform(source, result);
}


public static void addProcessedPackage(String packageName) {
    processedPackages.add(packageName);
}

public static void addPackageClass(String packageName, String className) {
    processedPackagesClasses.computeIfAbsent(packageName, k -> new HashSet<>()).add(className);
}

private static List<ClassInfo> classInfoList = new ArrayList<>();


public static List<ClassInfo> getClassInfoList() {
	// TODO Auto-generated method stub
	return classInfoList;
}

public static void addClassInfo(ClassInfo classInfo) {
	classInfoList.add(classInfo);
	}
}
/*
public static List<ClassInfo> getClassInfoList() {
    return classInfoList;
}
/*public static void addProcessedClass(String className) {
    processedClasses.add(className);
    ClassInfo classInfo = new ClassInfo(className);
    classInfo.extractClassInfo();
    classInfoList.add(classInfo);
    System.out.println("ProjectAnalyzer - Classe ajoutée : " + className);
}

public static Set<String> getProcessedClasses() {
    return processedClasses;
}
}
    
/*
    public void addRelations(Relation relation) {
    	relations.add(relation);
    }
    
    public List<Relation> getRelations(){
    	return relations;
    }
    
    
    public static Set<Relation> extractRelations(String className){
    	Set<Relation> relations = new HashSet<>();
    	
    	//heritage
    	try {
    		Class<?> clazz = Class.forName(className);
    		Class<?> superClass = clazz.getSuperclass();
    	if(superClass != null) {
    		relations.add(new Relation("heritee ", className, superClass.getSimpleName()));
    	}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    
    	return relations;
    }
    
    public void printRelations() {
        System.out.println("Detected Relations:");
        for (Relation relation : relations) {
            System.out.println(relation.getType() + " - " + relation.getSource() + " to " + relation.getDestination());
        }
    }

    
  
    
}*/
