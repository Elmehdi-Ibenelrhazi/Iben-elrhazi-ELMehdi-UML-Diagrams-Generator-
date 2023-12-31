package org.mql.java.Extractor;

public class ProjectAnalyzer {

	public static void main(String[] args) {
	String rootPackage="org.mql.java.informations";
	ProjectAnalyzer analyse = new ProjectAnalyzer();
	Myproject project = analyse.analyserProject(rootPackage);
	ViewProject.afficher(project);
	
	}

}
