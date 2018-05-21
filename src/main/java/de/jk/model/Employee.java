package de.jk.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Employee {
	public Employee() {
		
	}
	public Employee(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
	}
	  @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;

	private String name;
	private String vorname;
	 @JsonFormat(pattern="yyyy-MM-dd hh:mm:sss")
	private Date birthday;
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}
	private String zip;
	public Employee(String name, String vorname, Date birthday, String zip) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.birthday = birthday;
		this.zip = zip;
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
