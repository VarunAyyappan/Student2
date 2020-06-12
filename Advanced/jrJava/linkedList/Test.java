package jrJava.linkedList;

public class Test {

	public static void main(String[] args) {
		/*
		LinkedList list = new LinkedList();
		System.out.println(list);
		System.out.println(list.size());
		
		list.insertAtBeginning(101, 1.1);
		list.insertAtBeginning(102, 2.2);
		list.insertAtBeginning(103, 3.3);
		list.insertAtBeginning(104, 4.4);
		
		System.out.println(list);
		System.out.println(list.size());
		
		Link removed;
		while(list.size()>0){
			removed = list.removeFirst();
			System.out.println("removed="+removed);
			System.out.println(list); 
		}
		*/
		LinkedList list = new LinkedList();
		list.insertAtEnd(101, 1.1); 
		list.insertAtEnd(102, 2.2); 
		list.insertAtEnd(103, 3.3); 
		System.out.println(list);
		
		list.removeEnd();
		System.out.println(list);
		list.removeEnd();
		System.out.println(list);
		list.removeEnd();
		System.out.println(list);
		list.removeEnd();
		System.out.println(list);
	}

} 
 
 

















