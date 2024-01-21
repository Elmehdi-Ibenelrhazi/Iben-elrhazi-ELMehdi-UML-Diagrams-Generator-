package org.mql.java.complements;

import java.util.List;
import java.util.Vector;

public class MyPackage {
	private List<MyPackage> listePackages;
	private String NamePackage;
	
	public MyPackage(String namePackage) {
		super();
		NamePackage = namePackage;
		this.listePackages = new Vector<MyPackage>();
	}
	
	public void addPackage(MyPackage pack) {
		listePackages.add(pack);
	}
	
	public List<MyPackage> getListePackages() {
		return listePackages;
	}
	
	public String getNamePackage() {
		return NamePackage;
	}
	

}
