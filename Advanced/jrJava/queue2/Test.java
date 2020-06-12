package jrJava.queue2;

public class Test {

	public static void main(String[] args) {
		
		Queue q = new Queue(10);
		
		q.enqueue('a');
		q.display();
		q.enqueue('b');
		q.display();
		q.enqueue('c');
		q.display();
		q.enqueue('d');
		q.display();
		
		System.out.println(q.dequeue());
		q.display();
		System.out.println(q.dequeue());
		q.display();
		System.out.println(q.dequeue());
		q.display();
		System.out.println(q.dequeue());
		q.display();
		System.out.println(q.dequeue());
		q.display();
	}

}
