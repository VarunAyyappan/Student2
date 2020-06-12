package jrJava.queue3;

public class Queue<E> {

	private E[] values;
	private int front, rear, size;
	
	
	public Queue(int n){
		values = (E[]) new Object[n];
		front = 0;
		rear = -1;
		size = 0;
	} 
	
	
	public void enqueue(E value){
		if(size==values.length) throw new IndexOutOfBoundsException();
		rear++;
		if(rear==values.length) rear = 0;
		values[rear] = value;
		size++;
	}
	
	
	public E dequeue(){
		if(size==0) throw new IndexOutOfBoundsException();
		E toReturn = values[front];
		values[front] = null;
		front++;
		if(front==values.length) front = 0;
		size--;
		return toReturn;
	}
	
	
	public E peek(){
		if(size==0) throw new IndexOutOfBoundsException();
		return values[front];
	}
	
	
	public boolean isEmpty(){
		return size==0;
	}
	
	
	public void display(){
		for(int i=0; i<values.length; i++){
			if(values[i]==null) System.out.print("null ");
			else System.out.print(values[i] + " ");
		}
		System.out.println();
	}
	
}













