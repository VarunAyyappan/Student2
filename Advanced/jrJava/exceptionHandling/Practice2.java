package jrJava.exceptionHandling;

import java.util.Scanner;

public class Practice2 {


	public static void main(String[] args) {

		System.out.println("At the beginning of the main()."); 

		int[] values = {13, 17, 14, 11};

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an integer [0, " + (values.length-1) + "]");
		int targetIndex = scanner.nextInt();
		
		//int targetIndex = 0;
		//while(true){
		//	System.out.println("Enter an integer [0, " + (values.length-1) + "]");
		//	targetIndex = scanner.nextInt();
		//	if(targetIndex>=0 && targetIndex<values.length) break;
		//	System.out.println("DO IT AGAIN.");
		//}
		
		try{
			reportValue(values, targetIndex);
		}
		catch(RuntimeException re){
			
		}
		
		System.out.println("At the end of the main().");  
	}


	private static void reportValue(int[] array, int index) /*throws RuntimeException*/ {

		System.out.println("At the beginning of reportValue()");

		System.out.println(array[index]);
		
		//if(index>=0 && index<array.length){
		//	System.out.println(array[index]);
		//}
		//else {
		//	System.out.println("#$%$# ^&%^&^ !@#!");
		//}

		//try{
		//	System.out.println(array[index]);
		//}
		//catch(ArrayIndexOutOfBoundsException aiobe){
		//	System.out.println("Small blip happened. It is not a big deal. We will move on.");
		//}


		System.out.println("At the end of reportValue()");  
	}
}








