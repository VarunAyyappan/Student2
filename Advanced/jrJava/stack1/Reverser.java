package jrJava.stack1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reverser {

	private String expression;
	private Stack stack;

	public Reverser(String expression) {
		setExpression(expression);
	}

	public void setExpression(String expression) {
		this.expression = expression;
		stack = new Stack(expression.length());;
	}

	public String reverse() {
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<expression.length(); i++)
			stack.push(expression.charAt(i));

		while(!stack.isEmpty())
			sb.append(stack.pop());

		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		/*Reverser r = new Reverser("Estoy cansado...");
		System.out.println(r.reverse());*/

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String expression;
		Reverser r = new Reverser("");

		while(true){
			System.out.println("Type in your expression (type nothing to exit):");
			expression = br.readLine();
			if(expression.trim().length()==0) break;
			r.setExpression(expression);
			System.out.println(r.reverse());
		}
	}

}
