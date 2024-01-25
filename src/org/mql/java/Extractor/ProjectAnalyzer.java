package org.mql.java.Extractor;
import java.io.File;

import org.mql.java.complements.Customloader;
import org.mql.java.complements.MyClass;
import org.mql.java.complements.MyPackage;
import org.mql.java.complements.Project;

public class ProjectAnalyzer {

	private String filePath;
	private Project projet;



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
}

