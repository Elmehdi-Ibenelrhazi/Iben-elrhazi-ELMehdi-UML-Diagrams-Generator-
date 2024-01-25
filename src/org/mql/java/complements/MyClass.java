package org.mql.java.complements;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class MyClass {

	private Class<?> cls ;
	private String type;
	private List<Method> methods;
	private List<Field> fields;

	public MyClass(Class<?> cls) {
		super();
		this.cls = cls;
		if(cls.isInterface()) {
			type="interface";
		}
		else if(cls.isAnnotation()) {
			type="annotation";

		}else {
			type="classe";
		}

	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getClasseName() {
		return cls.getSimpleName();
	}

	public Field[] getAttributes() {
		return cls.getDeclaredFields();
	}

	public Method[] getMethods() {
		return cls.getDeclaredMethods();
	}







}
