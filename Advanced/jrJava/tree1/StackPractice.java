package jrJava.tree1;

import java.util.Stack;

public class StackPractice {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
		stack.push("ddd");
		stack.push("eee");
		
		System.out.println(stack);
		
		
		/*
		//System.out.println(stack.peek());
		//System.out.println(stack.peek());
		System.out.println(stack);
		
		String removed;
		while(!stack.isEmpty()){
			removed = stack.pop();
			System.out.println(removed);
		}
		*/
		
		Stack<String> stack2 = new Stack<String>();
		while(!stack.isEmpty()){
			stack2.push(stack.pop());
		}
		
		System.out.println(stack2);
	}

} 
  






