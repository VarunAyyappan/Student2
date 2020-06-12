package jrJava.linkedList4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) throws IOException {
		LinkedList<Employee> list = new LinkedList<Employee>();

		//Load data from data file using InputStreamReader/Scanner
		/*
		Scanner in = new Scanner(new File("jrJava/linkedList4/employee.txt"));
		String line;
		while(in.hasNextLine()) {
			line = in.nextLine();
			if(line.trim().length() != 0) list.insert(new Employee(line));
			System.out.println(line);
		}
		 */

		FileInputStream fis = new FileInputStream("jrJava/linkedList4/employee.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		String line;
		while(true) {
			line = br.readLine();

			if(line == null) break;
			if(line.trim().length() == 0) continue;

			System.out.println(line);
			list.insert(new Employee(line));
		}

		System.out.println(list);
		br.close();
		
		Iterator<Employee> iterator = list.getIterator();
		Employee current;
		while(iterator.hasNext()) {
			current = iterator.next();
			if(current.getSalary() < 100000) current.setSalary((int)(current.getSalary() * 1.3));
			else if(current.getSalary() > 300000) iterator.remove();
		}
		
		System.out.println(list);
	}

}