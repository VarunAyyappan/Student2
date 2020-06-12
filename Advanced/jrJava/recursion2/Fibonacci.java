package jrJava.recursion2;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacci(110));
		System.out.println(fibonacciRecursion(50));
	}
	
	public static long fibonacci(int n) {
		if (n==1 || n==2) return 1;
		
		long first = 1;
		long second = 1;
		long third = 0;
		
		for(int i=3; i<=n; i++) {
			third = second + first;
			first = second;
			second = third;
		}
		
		return third;
	}
	
	public static long fibonacciRecursion(int n) {
		if(n==1 || n==2)
			return 1;
		else
			return fibonacciRecursion(n-1)+fibonacciRecursion(n-2);
	}
	
}
