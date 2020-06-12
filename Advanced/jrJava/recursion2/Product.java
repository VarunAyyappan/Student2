package jrJava.recursion2;

public class Product {
	
	public static void main(String[] args) {
		System.out.println(product(1,10));
		System.out.println(product(1,10));
		System.out.println(factorial(10));
	}
	
	public static int product(int start, int end) {
		if(end == start) return end;
		
		int mid = (start+end)/2;
		return product(start, mid) * product(mid+1, end);
	}
	
	public static int product2(int start, int end) {
		if(start==end) return start;
		else return product2(start, end-1) * end;
	}
	
	public static int factorial(int n) {
		if(n==1 || n==0) return 1;
		else return n*factorial(n-1);
	}
	
}
