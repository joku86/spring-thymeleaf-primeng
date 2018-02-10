package de.jk.model;

public class Employee {
	public Employee(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
	}
	private String name;
	private String vorname;
	private String a;
	private String b;
	public Employee(String name, String vorname, String a, String b) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.a = a;
		this.b = b;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}
