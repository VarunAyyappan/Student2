package jrJava.recursion2;

public class Sum {

	public static void main(String[] args) {
		System.out.println(sum(10));
	}
	
	//
	public static int sum(int n) {
		if(n==1) return 1;
		else return sum(n-1) + n ;
	}
	
}
