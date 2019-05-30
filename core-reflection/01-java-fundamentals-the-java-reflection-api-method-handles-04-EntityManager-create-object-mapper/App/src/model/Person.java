package model;

import annotation.Column;
import annotation.PrimaryKey;

public class Person {
	
	@PrimaryKey
	private int id;
	
	@Column
	private int age;
	
	@Column
	private String name;
	
	public Person() {
		super();
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}
	


	public Person(String name, int age) {
		this.age = age;
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}