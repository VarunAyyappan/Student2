package jrJava.exceptionHandling;

import java.util.Scanner;

public class Practice3 {


	public static void main(String[] args) {

		System.out.println("At the beginning of the main()."); 

		int[] values = {13, 17, 14, 11};

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an integer [0, " + (values.length-1) + "]");
		int targetIndex = scanner.nextInt();
		
		try{
			reportValue(values, targetIndex);
		}
		catch(Exception e){}
		
		System.out.println("At the end of the main().");  
	}


	private static void reportValue(int[] array, int index)  {

		System.out.println("At the beginning of reportValue()");
		
		
			System.out.println(array[index]);
		
		System.out.println("At the end of reportValue()");  
	}
}








