package org.mql.java.Extractor;

import java.util.List;

public class Analyzer {

	public Analyzer() {
		
	}
	
	public Myproject analyserProject(String rootPackage) {

		Myproject project = new Myproject();
		analysepackage(rootPackage, project);
		return project;
	}
	
	public void analysepackage(String packageName,Myproject project) {
		 MyPackage pack = new MyPackage(packageName);
		 project.getPackages().add(pack);
		 
		 
		
		
	}

}
