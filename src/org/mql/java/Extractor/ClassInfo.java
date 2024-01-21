package org.mql.java.Extractor;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.mql.java.complements.MyClass;

public class ClassInfo {
    private String className;
    private List<Method> methods;
    private List<Field> attributes;

    public ClassInfo(String className) {
    	try {
    		Class<?> cls = Class.forName(className);
    		this.className = className;
    		this.methods = getMethods(cls);
    	    this.attributes = getFields(cls);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        
    }

    public static List<Field> getFields(Class<?> c) {
		Field fields [] =c.getDeclaredFields();
		if(fields.length != 0) {
			List<Field> listFields = new Vector<Field>();
			for (Field field : fields) {
				listFields.add(field);
			}
			return listFields;
		}
		return null; 
	}
	   
    
    public static List<Method> getMethods(Class<?> c) {
		Method methods [] = c.getDeclaredMethods();
		if(methods.length != 0) {
			List<Method> listMethod = new Vector<Method>();
			for (Method method : methods) {
				listMethod.add(method);
			}
			return listMethod;
		}
		 return null; 
		}
    
    public static  String getConstructors(Class<?> cls) {
		Constructor<?> constructors [] = cls.getDeclaredConstructors();
		String string =""; 
		for (Constructor<?> constructor : constructors) {
			string += " "+constructor.getName()+"("+getArguments(constructor)+");\n"; 
		}
		
		return string ; 
	}
   
    private static String getArguments(Constructor<?> constructor) {
		String string =""; 
		Parameter parametors[] = constructor.getParameters();
		if(parametors.length != 0) {
			for(int i = 0 ; i < parametors.length-1 ; i++) {
				string += parametors[i].getType().getTypeName()+", ";
			}
			string += parametors[parametors.length - 1].getType().getTypeName();
			
		}
		return string;
	}
    

    
    public void displayClassInfo() {
        System.out.println("Class: " + className);
        System.out.println("Methods: " );
        for (Method method : methods) {
        	System.out.println(" " + method);
        }
        System.out.println("Attributes: " );
        for (Field attribute : attributes) {
        	System.out.println(" " + attribute);
        }
        System.out.println();
    
}
}

