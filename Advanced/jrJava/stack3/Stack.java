package jrJava.stack3;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<E> {

	private ArrayList<E> list;

	public Stack() {
		list = new ArrayList<E>();
	}

	public void push(E data) {
		list.add(data);
	}

	public E pop() {
		if(isEmpty()) throw new EmptyStackException();
		return list.remove(list.size()-1);
	}

	public E peek() {
		if(isEmpty()) throw new EmptyStackException();
		return list.get(list.size()-1);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

}
