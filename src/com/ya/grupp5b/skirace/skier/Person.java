package com.ya.grupp5b.skirace.skier;

/**
 * Abstrakt klass som Skier ärver ifrån
 */

public abstract class Person {
	
	protected String firstName;
	protected String lastName;

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	

}
