package jrJava.stack3;

import java.util.ArrayList;

import jrJava.stack2.Stack;

public class Calculator {

	private final String ALL_OPS;
	private String expression;
	private Stack<String> opStack, oprndStck;

	public Calculator(String expression) {
		this.expression = expression;
		opStack = new Stack<String>();
		oprndStck = new Stack<String>();
		ALL_OPS = "()^*/%+-";
	}

	public ArrayList<String> tokenizer() {
		ArrayList<String> tokens = new ArrayList<String>();
		int pos1 = 0, pos2 = 0;
		char ch;
		String operand; 

		for(int i=0; i<expression.length(); i++) {
			ch = expression.charAt(i);

			if(ALL_OPS.indexOf(ch)>=0) {
				pos2 = i;
				operand = expression.substring(pos1, pos2).trim();

				if(operand.length()>0)
					tokens.add(operand);

				tokens.add(String.valueOf(ch));
				pos1 = pos2+1;
			}
			else if(i==expression.length()-1) {
				operand = expression.substring(pos1).trim();

				if(operand.length()>0)
					tokens.add(operand);
			}
		}

		return tokens;
	}

	public static void main(String[] args) {
		String exp = "3.5152 * (14.1+2.1*(25.9-11.9/12) + 4.2^2%4 + 0.001) + 100.0";
		Calculator cal = new Calculator(exp);
	}

}
