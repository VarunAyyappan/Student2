package jrJava.linkedList3;

import java.util.Iterator;

public class IteratorTest {

	
	public static void main(String[] args) {
		
		LinkedList<Student> list = new LinkedList<Student>();

		for(int i=0; i<10; i++) list.insertAtBeginning( new Student(101 + i, (int)(Math.random()*200 + 200)/100.0) ); 
		System.out.println(list);
		
		Iterator<Student> iter = list.iterator();
		double sum = 0;
		int count = 0;
		while(iter.hasNext()){
			sum += iter.next().getGPA();
			count++;
		}
		double average = sum/count;
		System.out.println("average="+average); 
		
		
		iter = list.iterator();
		Student each;
		while(iter.hasNext()){
			each = iter.next();
			if(each.getGPA()>average+0.5) each.setHonor(true);
			else if(each.getGPA()<average-0.3) each.setExpelled(true);
		}
		System.out.println(list); 
		
		/*
		iter = list.iterator();
		while(iter.hasNext()){
			if(iter.next().getExpelled()) iter.remove();
		}
		System.out.println(list);
		*/
		
		iter = list.iterator();
		LinkedList<Student> honors = new LinkedList<Student>();
		LinkedList<Student> expels = new LinkedList<Student>();
		while(iter.hasNext()){
			each = iter.next();
			if(each.getHonor()){
				honors.insertAtBeginning(each);
				iter.remove();
			}
			else if(each.getExpelled()){
				expels.insertAtBeginning(each);
				iter.remove();
			}
		}
		
		System.out.println(list);
		System.out.println(honors);
		System.out.println(expels); 
		
	}

}
  











