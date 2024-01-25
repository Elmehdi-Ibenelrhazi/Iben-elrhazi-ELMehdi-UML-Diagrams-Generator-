package org.mql.java.examples;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.mql.java.Extractor.ClassInfo;
//import org.mql.java.Extractor.ClassInfo;

import org.mql.java.Extractor.ProjectAnalyzer;
import org.mql.java.XML.XMLNode;
import org.mql.java.XML.XMLWriter;
import org.mql.java.complements.Project;
import org.mql.java.ui.Form;
import org.w3c.dom.Document;

public class Examples extends JFrame{

	public Examples() {
		exp03();
	}

	void exp01() {
		/*String projectLocation = "C:\\Users\\hp\\eclipse-workspace\\P03_AnnotationsAndReflection";
		ProjectAnalyzer projectAnalyzer = new ProjectAnalyzer();
		ProcessJavaFile processJavaFile = new ProcessJavaFile();

		processJavaFile.traverseProject(new File(projectLocation), projectAnalyzer);
		try {
			Document doc = ProjectAnalyzer.createXmlDocument(ProjectAnalyzer.processedPackages);
			ProjectAnalyzer.saveXmlDocument(doc, "project_info.xml");
			System.out.println("Project information saved to project_info.xml");
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
			System.out.println("probleme vient d'ici");
		}
		for (ClassInfo classInfo : ProjectAnalyzer.getClassInfoList()) {
			classInfo.displayClassInfo();
		}*/

	}


	void exp02() {
		String projectLocation = "C:\\Users\\hp\\eclipse-workspace\\P03_AnnotationsAndReflection";
		ProjectAnalyzer projectAnalyzer = new ProjectAnalyzer(projectLocation);

		Project projet = projectAnalyzer.traverseProject();

		XMLWriter writer = new XMLWriter(projet);
		writer.createXmlDocument();


	}
	void exp03() {
		setContentPane(new Form());
		pack();
		setTitle("UML Diagrams Generator");
		setLocationRelativeTo(null);
		setSize(new Dimension(500,500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setVisible(true);


	}


	public static void main(String[] args) {
		new Examples();
	}}
