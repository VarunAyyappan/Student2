package jrJava.inheritance3;

public class B extends A {

	public B() {
		System.out.println("B()");
	}

	public B(int e) {
		super(e+50);
		System.out.println("B(int e)");
	}

}
