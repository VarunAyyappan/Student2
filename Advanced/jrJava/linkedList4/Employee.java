package jrJava.linkedList4;

import java.util.StringTokenizer;

public class Employee implements Comparable<Employee> {

	private String firstName, lastName;
	private int id;
	private String title;
	private int hiredYear, salary;
	private int dobYY, dobMM, dobDD;
	private char gender;
	private int height, weight;
	
	public Employee(String line) {
		StringTokenizer st = new StringTokenizer(line, " \t");
		firstName = st.nextToken();
		lastName = st.nextToken();
		id = Integer.parseInt(st.nextToken());
		title = st.nextToken();
		hiredYear = Integer.parseInt(st.nextToken());
		salary = Integer.parseInt(st.nextToken());
		dobYY = Integer.parseInt(st.nextToken());
		dobMM = Integer.parseInt(st.nextToken());
		dobDD = Integer.parseInt(st.nextToken());
		gender = st.nextToken().charAt(0);
		height = Integer.parseInt(st.nextToken());
		weight = Integer.parseInt(st.nextToken());
	}
	
	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }
	
	public String toString() {
		return firstName + " " + lastName + " " + id + " " + salary;
	}
	
	public int compareTo(Employee o) {
		return firstName.compareTo(o.firstName);
	}
	
	/*
	@Override
	public int compareTo(Employee o) {
		if(salary > o.salary) return 1;
		else if(salary < o.salary) return -1;
		
		if(id > o.id) return 1;
		else if(id < o.id) return -1;
		
		return 0;
	}
	*/
	
	/*
	@Override
	public int compareTo(Employee o) {
		return id - o.id;
	}
	*/
}
