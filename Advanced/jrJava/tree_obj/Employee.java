package jrJava.tree_obj;

import java.util.StringTokenizer;

public class Employee implements Comparable<Employee> {

	private String firstName, lastName;
	private int id;
	private String title;
	private int hiredYear, salary;
	private int dobYY, dobMM, dobDD;
	private char gender;
	private int height, weight;

	public Employee(int idIn) {
		id = idIn;
	}

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
	
	public int getId() { return id; }
	public void setId(int idIn) { id = idIn; }
	
	public String toString() {
		return String.valueOf(id);
	}
	
	public int compareTo(Employee o) {
		if(id>o.id)
			return 1;
		else if(id<o.id)
			return -1;
		else
			return 0;
	}
}
