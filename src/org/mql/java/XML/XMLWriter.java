package org.mql.java.XML;

import org.mql.java.complements.MyClass;
import org.mql.java.complements.MyPackage;
import org.mql.java.complements.Project;

public class XMLWriter {
	private Project pr;
	private XMLNode document;

	public XMLWriter(Project p) {
		this.pr = p;
	}
	
	public void createXmlDocument() {
		document = new XMLNode();
		document.setDocumentElement("Project");
		WritePackages();
		WriteClasses();
		document.setTarget("resource/Diagramme.xml");
		document.save();
	
		
	}
	
	public void WritePackages() {
		for (MyPackage p : pr.getListePackages()) {
			document.appendChild(getPackageNode(p));
			
		}
		
	}
	
	public void WriteClasses() {
		for (MyClass p : pr.getListeClasses()) {
			document.appendChild(getClasseNode(p));
			
		}
		
	}
	
	
	private XMLNode getClasseNode(MyClass c) {
		XMLNode classeNode = document.createNode(c.getType());
		XMLNode name = document.createNode("Name");
		name.setValue(c.getClasseName());
		classeNode.appendChild(name);
		return classeNode;
		
	}

	private XMLNode getPackageNode(MyPackage p) {
		XMLNode packageNode = document.createNode("Package");
		XMLNode name = document.createNode("Name");
		name.setValue("" +p.getNamePackage());
		packageNode.appendChild(name);
		for (MyPackage pkg : p.getListePackages()) {
			packageNode.appendChild(getPackageNode(pkg));
			
		}
		return packageNode;
		
		
		
	}
	
	

}
