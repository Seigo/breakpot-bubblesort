package com.osawaseigo.breakpot.bubblesort;

public class Person {

	private String name;
	private int age;
	
	public Person(int index) {
		this.name = "p" + index;
		this.age = (int) Math.floor((Math.random() * 130));
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
