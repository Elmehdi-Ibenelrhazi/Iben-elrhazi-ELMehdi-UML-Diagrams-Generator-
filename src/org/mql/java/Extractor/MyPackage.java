package org.mql.java.Extractor;
import java.util.ArrayList;
import java.util.List;

public class MyPackage {
    private String name;
    private List<MyClass> classes;
    private List<MyPackage> subPackages;

    public MyPackage(String name) {
        this.name = name;
        this.classes = new ArrayList<>();
        this.subPackages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<MyClass> getClasses() {
        return classes;
    }

    public List<MyPackage> getSubPackages() {
        return subPackages;
    }
}
