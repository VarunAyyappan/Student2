package jrJava.stack2;

public class EnclosureChecker {

	private String expression;
	private Stack<Character> stack;

	public EnclosureChecker(String expression) {
		this.expression = expression;
		stack = new Stack<Character>();
	}

	public void check() {
		char cur = ' ', popped = ' ';
		boolean errorHappned = false;
		
		for(int i=0; i<expression.length(); i++) {
			cur = expression.charAt(i);

			if(cur == '(' || cur == '[' || cur == '{')
				stack.push(cur);
			else if(cur == ')' || cur == ']' || cur == '}'){
				if(!stack.isEmpty()) {
					popped = stack.pop();
					if((cur==')' && popped != '(') || (cur==']' && popped != '[') || (cur=='}' && popped != '{')) {
						System.out.println("Mismatch at i=" + i + " with " + cur);
						errorHappned = true;
					}
				}
				else {
					System.out.println("More closing than the opening at i=" + i);
					errorHappned = true;
				}
			}
			/*else if(cur == ')' && stack.peek() != '(') {
				System.out.println("Wrong at " + i + " position: " + cur + "should be )." );
				return;
			}
			else if(cur == ']' && stack.peek() != '['){
				System.out.println("Wrong at " + i + " position: " + cur + "should be ]." );
				return;
			}
			else if(cur == '}' && stack.peek() != '{'){
				System.out.println("Wrong at " + i + " position: " + cur + "should be }." );
				return;
			}
			else if(cur == ')' || cur == ']' || cur == '}')
				stack.pop();*/
		}

		if(!stack.isEmpty())
			System.out.println("Expression is not properly closed.");
		else if(!errorHappned)
			System.out.println("It's a good expression.");
	}

	public static void main(String[] args) {
		EnclosureChecker ec1 = new EnclosureChecker("a+2*{(b-c)*4) + 2}");
		EnclosureChecker ec2 = new EnclosureChecker("{ [() () {}] () }");
		ec1.check();
		System.out.println();
		ec2.check();
	}

}
