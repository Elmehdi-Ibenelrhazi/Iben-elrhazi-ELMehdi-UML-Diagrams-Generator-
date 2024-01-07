package org.mql.java.examples;

import java.io.File;

import org.mql.java.Extractor.ProjectAnalyzer;

public class Examples {

	public static void main(String[] args) {
		String projectLocation ="C:\\Users\\hp\\eclipse-workspace\\IBEN_EL_RHAZI_EL_MEHDI_JUnit";
		ProjectAnalyzer.TraverseProject(new File(projectLocation));

	}

}
