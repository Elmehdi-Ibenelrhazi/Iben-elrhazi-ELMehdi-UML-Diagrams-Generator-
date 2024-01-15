package org.mql.java.examples;

import java.io.File;

import org.mql.java.Extractor.ProjectAnalyzer;

public class Examples {

    public static void main(String[] args) {
        String projectLocation = "C:\\Users\\hp\\eclipse-workspace\\P03_AnnotationsAndReflection";
        ProjectAnalyzer projectAnalyzer = new ProjectAnalyzer();
        projectAnalyzer.traverseProject(new File(projectLocation));
    }
}
