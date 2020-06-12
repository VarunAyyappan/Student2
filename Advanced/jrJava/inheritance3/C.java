package jrJava.inheritance3;

public class C extends B {

	public C() {
		super(10);
		System.out.println("C()");
	}

	public C(int e) {
		super(2*e-100);
		System.out.println("C(int e)");
	}

}
