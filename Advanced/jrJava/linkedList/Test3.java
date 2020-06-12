package jrJava.linkedList;

public class Test3 {

	
	public static void main(String[] args) {
		
		int[] aaa = {5, 7, 9, 6, 8, 3, 7, 4, 2, 1};
		
		/*
		for(int i=0; i<aaa.length; i++){
			System.out.print(aaa[i] + " ");
		}
		System.out.println();
		*/
		
		for(int i=0; i<aaa.length; i++){
			for(int j=0; j<aaa.length; j++){
				System.out.print("{"+aaa[i]+"."+aaa[j]+"} ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		LinkedList list = new LinkedList();
		list.insertAtEnd(5, 0.5);
		list.insertAtEnd(7, 0.7);
		list.insertAtEnd(9, 0.9);
		list.insertAtEnd(6, 0.6);
		list.insertAtEnd(8, 0.8);
		list.insertAtEnd(3, 0.3);
		list.insertAtEnd(7, 0.7);
		list.insertAtEnd(4, 0.4);
		list.insertAtEnd(2, 0.2);
		list.insertAtEnd(1, 0.1);
		
		list.reset();
		while(list.hasNext()){
			Link a = list.next();
			
			list.reset();
			while(list.hasNext()){
				Link b = list.next();
				System.out.print("{"+a.id+","+b.id+"} ");
			}
			System.out.println();
		}
		
		
		/*
		int size = list.size();
		for(int i=0; i<size; i++){
			System.out.print(list.get(i).id + " ");
		}
		System.out.println();
		*/
		 
		/*
		list.reset();
		while(list.hasNext()){
			Link each = list.next();
			System.out.println(each.id);
		}
		*/
	}

	
}







