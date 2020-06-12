package jrJava.queue3;

public class Test {

	public static void main(String[] args) {
		
		Queue<Integer> q = new Queue<Integer>(20);
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		
		for(int i=6; i<36; i++){
			q.enqueue(i);
			q.dequeue();
			
			q.display();
		}
	}
	
	

}
