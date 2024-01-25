package org.mql.java.complements;

import java.util.List;
import java.util.Vector;

public class Project {
	private String javaPath;
	private List<MyPackage> listePackages;
	private List<MyClass> listeClasses;


	public Project(String javaPath) {
		super();
		this.javaPath = javaPath;
		this.listeClasses = new Vector<MyClass>();
		this.listePackages = new Vector<MyPackage>();
	}

	public void addPackage(MyPackage pack) {
		listePackages.add(pack);
	}

	public void addClasse(MyClass cls) {
		listeClasses.add(cls);
	}

	public List<MyPackage> getListePackages() {
		return listePackages;
	}
	public List<MyClass> getListeClasses() {
		return listeClasses;
	}








}
