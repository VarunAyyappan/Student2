package jrJava.queue2;


public class Queue<E> {

	private E[] values;
	private int top; // front
	
	public Queue(int size){
		values = (E[]) new Object[size];
		top = -1;
	}
	
	
	public void enqueue(E value){
		if(top==values.length-1) throw new IndexOutOfBoundsException();
		values[++top] = value;
	}
	
	
	public E dequeue(){
		if(top==-1) throw new IndexOutOfBoundsException();
		E toReturn = values[0];
		for(int i=1; i<=top; i++) values[i-1] = values[i];
		top--;
		return toReturn;
	}
	
	
	public E peek(){
		if(top==-1) throw new IndexOutOfBoundsException();
		return values[0];
	}
	
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	
	public void display(){
		for(int i=0; i<=top; i++) System.out.print(values[i] + " ");
		System.out.println();
	}
	
}








