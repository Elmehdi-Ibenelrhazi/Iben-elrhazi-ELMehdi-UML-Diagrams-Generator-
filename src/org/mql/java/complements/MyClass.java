package org.mql.java.complements;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyClass {

	private Class<?> cls ;
	private String type;
	

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
