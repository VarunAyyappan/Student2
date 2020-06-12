package jrJava.tree_obj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) throws IOException {
		Tree<Employee> tree = new Tree<Employee>();

		//Load data from data file using InputStreamReader/Scanner
		/*
		Scanner in = new Scanner(new File("jrJava/linkedList4/employee.txt"));
		String line;
		while(in.hasNextLine()) {
			line = in.nextLine();
			if(line.trim().length() != 0) tree.insert(new Employee(line));
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
			tree.insert(new Employee(line));
		}
		
		Employee charlie = new Employee("Charlie Yi	50	CEO	2018	900000	2002	1	30	M	170	270");
		tree.insert(charlie);
		
		tree.traverseTopToBottom();
		br.close();
		
		Employee toChange = tree.find(new Employee(25)).getValue();
		tree.delete(toChange);
		toChange.setId(98);
		tree.insert(toChange);
		tree.traverseTopToBottom();
		
		/*Iterator<Employee> iterator = tree.getIterator();
		Employee current;
		while(iterator.hasNext()) {
			current = iterator.next();
			if(current.getSalary() < 100000) current.setSalary((int)(current.getSalary() * 1.3));
			else if(current.getSalary() > 300000) iterator.remove();
		}
		
		System.out.println(tree);*/
	}

}