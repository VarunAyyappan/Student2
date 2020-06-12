package jrJava.inheritance1_polymorphism;

public class B extends A {
	public int f = 20;
	public void m() { System.out.println("B's m(), f=" + f); }
	
	public static int sf= 200;
	public static void sm() { System.out.println("B's sm(), fs=" + sf); }
}
