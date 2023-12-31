package org.mql.java.Extractor;
import java.util.ArrayList;

import java.util.List;

public class MyClass {
    private String name;
    private List<MyField> fields;
    private List<MyMethod> methods;
    private List<MyAnnotation> annotations;

    public MyClass(String name) {
        this.name = name;
        this.fields = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.annotations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<MyField> getFields() {
        return fields;
    }

    public List<MyMethod> getMethods() {
        return methods;
    }

    public List<MyAnnotation> getAnnotations() {
        return annotations;
    }
}
