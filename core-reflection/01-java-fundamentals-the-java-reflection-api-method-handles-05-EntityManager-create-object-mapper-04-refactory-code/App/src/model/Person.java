package model;

import annotation.Column;
import annotation.PrimaryKey;


public class Person {
	
	
	@PrimaryKey
	private int id;
		
	@Column
	private String name;
	
	@Column
	private int age;

	
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

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	
	
}