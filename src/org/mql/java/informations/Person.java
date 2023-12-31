package org.mql.java.informations;

public class Person implements Statistics {

	private int CIN;
	private int age;
	public Person(int CIN, int age) {
		this.age = age;
		this.CIN = CIN;
		
		
		
		
	}
	public int getCIN() {
		return CIN;
	}
	public void setCIN(int cIN) {
		CIN = cIN;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
