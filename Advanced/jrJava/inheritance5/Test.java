package jrJava.inheritance5;

public class Test {

	public static void main(String[] args) {
		// new A(); <---- A is abstract so this line wouldn't compile.

		A ref = new B();
		ref.m1();
		ref.m2();
		//ref.m3(); <----- Declared as A type, won't compile
	}

}
