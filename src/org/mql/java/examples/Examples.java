package org.mql.java.examples;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.mql.java.Extractor.ProjectAnalyzer;
import org.mql.java.XML.XMLWriter;
import org.mql.java.complements.Project;
import org.mql.java.ui.Form;

public class Examples extends JFrame{

	
	private static final long serialVersionUID = 1L;


	public Examples() {
		exp02();
	}

	


	void exp01() {
		String projectLocation = "C:\\Users\\hp\\eclipse-workspace\\P03_AnnotationsAndReflection";
		ProjectAnalyzer projectAnalyzer = new ProjectAnalyzer(projectLocation);

		Project projet = projectAnalyzer.traverseProject();

		XMLWriter writer = new XMLWriter(projet);
		writer.createXmlDocument();


	}
	void exp02() {
		setContentPane(new Form());
		pack();
		setTitle("UML Diagrams Generator");
		setLocationRelativeTo(null);
		setSize(new Dimension(300,100));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		ImageIcon icon = new ImageIcon("resource\\uml-f.png");
		setIconImage(icon.getImage());
		setVisible(true);
		setResizable(false);


	}


	public static void main(String[] args) {
		new Examples();
	}}
