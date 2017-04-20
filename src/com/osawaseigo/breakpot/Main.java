package com.osawaseigo.breakpot;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.Duration;

public class Main {

	public static void main(String args[]) {
		System.out.println("Hello BreakPot BubbleSort!");
		new Main().run();
	}
	
	private void run() {
		System.out.println("Given a hard-coded Person array..");
		List<Person> hardcodedPeople = new ArrayList<Person>();
		hardcodedPeople.add(new Person(0)); hardcodedPeople.get(0).setAge(5);
		hardcodedPeople.add(new Person(1)); hardcodedPeople.get(1).setAge(16);
		hardcodedPeople.add(new Person(2)); hardcodedPeople.get(2).setAge(1);
		hardcodedPeople.add(new Person(3)); hardcodedPeople.get(3).setAge(120);
		printPeopleArray(hardcodedPeople);
		System.out.println("Sorting the array..");
		long timestamp = System.currentTimeMillis();
		bubbleSort(hardcodedPeople);
		printPeopleArray(hardcodedPeople);
		System.out.println("Sorted in " + ((System.currentTimeMillis() - timestamp) / 1000) + " seconds.\n");
		
		System.out.println("Initializing a random Person array..");
		List<Person> people = new ArrayList<Person>();
		fillPeopleArray(people, 10000);
		printPeopleArray(people);
		System.out.println("Sorting the array..");
		timestamp = System.currentTimeMillis();
		bubbleSort(people);
		printPeopleArray(people);
		System.out.println("Sorted in " + ((System.currentTimeMillis() - timestamp) / 1000) + " seconds.\n");
	}
	
	private void bubbleSort(List<Person> people) {
		while (!isSortedByAge(people)) {
			for (int i = 0; i < people.size() - 1; i++) {
				if (people.get(i).getAge() > people.get(i + 1).getAge()) {
					switchPlaces(people, i, i + 1);
				}
			}
		}
	}
	
	private void switchPlaces(List<Person> people, int i1, int i2) {
		Person tmp = people.remove(i1);
		people.add(i2, tmp);
	}
	
	private boolean isSortedByAge(List<Person> people) {
		for (int i = 0; i < people.size() - 1; i++) {
			if (people.get(i).getAge() > people.get(i + 1).getAge()) {
				return false;
			}
		}
		return true;
	}
	
	private void fillPeopleArray(List<Person> people, int maxNumOfPeople) {
		int numOfPeople = (int) Math.floor(Math.random() * maxNumOfPeople) + 1;
		System.out.println("Generating " + numOfPeople + " people..");
		for (int i = 0; i < numOfPeople; i++) {
			people.add(new Person(i));
		}
	}
	
	private void printPeopleArray(List<Person> people) {
		System.out.print("Printing array: ");
		for (int i = 0; i < people.size(); i++) {
			//System.out.print("[" + people.get(i).getName() + ", " + people.get(i).getAge() + "]");
			System.out.print("|"+people.get(i).getAge());
		}
		System.out.print("\n");
	}
}
