package jrJava.linkedList3;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		
		LinkedList<Student> list = new LinkedList<Student>();
		
		for(int i=0; i<10; i++) list.insertAtBeginning(new Student(101 + i, (int)(200+Math.random()*200)/100.0  ));
		System.out.println(list);
		
		Iterator<Student> iter = list.iterator();
		int count = 0;
		double sum = 0.0;
		while(iter.hasNext()){
			sum += iter.next().getGPA();
			count++;
		}
		double average = sum/count;
		System.out.println("average = " + average);
		
		
		iter = list.iterator();
		Student each;
		while(iter.hasNext()){
			each = iter.next();
			if(each.getGPA()>average+0.5) each.setHonor(true);
			else if(each.getGPA()<average-0.2) each.setExpelled(true);
		}
		System.out.println(list); 
		
		/*
		iter = list.iterator();
		while(iter.hasNext()){
			if(iter.next().getExpelled()) iter.remove();
		}
		System.out.println(list);
		*/
		
		LinkedList<Student> expelled = new LinkedList<Student>();
		LinkedList<Student> honors = new LinkedList<Student>();
		iter = list.iterator();
		Student stu;
		while(iter.hasNext()){
			stu = iter.next();
			if(stu.getExpelled()){
				expelled.insertAtBeginning(stu);
				iter.remove();
			}
			else if(stu.getHonor()){
				honors.insertAtBeginning(stu);
				iter.remove();
			}
		}
		System.out.println(list);
		System.out.println(honors);
		System.out.println(expelled);
	}  
 
}
 

 























