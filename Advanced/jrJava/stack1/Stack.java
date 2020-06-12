package jrJava.stack1;

import java.util.EmptyStackException;

public class Stack {

	private char[] array;
	private int top;

	public Stack(int size) {
		array = new char[size];
		top = -1;
	}

	public void push(char toAdd) {
		if(top == array.length-1) return;   // Right thing would be to change array to bigger size
		array[++top] = toAdd;
	}

	public char pop() {
		if(isEmpty()) throw new EmptyStackException();
		return array[top--];
	}

	public char peek() {
		if(isEmpty()) throw new EmptyStackException();
		return array[top];
	}

	public boolean isEmpty() {
		return top<0;
	}

}
