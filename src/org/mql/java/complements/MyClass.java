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






























	public static List<Field> getFields(Class<?> c) {
        Field[] fields = c.getDeclaredFields();
        List<Field> listFields = new ArrayList<>();
        for (Field field : fields) {
            listFields.add(field);
        }
        return listFields;
    }

    public static List<Method> getMethods(Class<?> c) {
        Method[] methods = c.getDeclaredMethods();
        List<Method> listMethod = new ArrayList<>();
        for (Method method : methods) {
            listMethod.add(method);
        }
        return listMethod;
    }

    public static List<Constructor<?>> getConstructors(Class<?> cls) {
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        List<Constructor<?>> constructorList = new ArrayList<>();
        for (Constructor<?> constructor : constructors) {
            constructorList.add(constructor);
        }
        return constructorList;
    }

    public static String getArguments(Member member) {
        StringBuilder string = new StringBuilder();
        Parameter[] parameters = ((Executable) member).getParameters();
        if (parameters.length != 0) {
            for (int i = 0; i < parameters.length - 1; i++) {
                string.append(parameters[i].getType().getTypeName()).append(", ");
            }
            string.append(parameters[parameters.length - 1].getType().getTypeName());
        }
        return string.toString();
    }
}
