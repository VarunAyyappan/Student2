package jrJava.linkedList2;

public class Test4 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtEnd(5, 0.5);
		list.insertAtEnd(7, 0.7);
		list.insertAtEnd(9, 0.9);
		list.insertAtEnd(11, 0.11);
		list.insertAtEnd(8, 0.8);
		list.insertAtEnd(3, 0.3);
		list.insertAtEnd(7, 0.7);
		list.insertAtEnd(4, 0.4);
		list.insertAtEnd(2, 0.2);
		list.insertAtEnd(1, 0.1);

		while(true){
			if(list.hasNext()){
				System.out.print(list.next().id + " ");
				System.out.println();
			}
			else {
				break;
			}
		}
	}

}
