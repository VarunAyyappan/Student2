package jrJava.exceptionHandling2;

import java.util.Scanner;

public class Test {

	
	public static void main(String[] args) {
		System.out.println("Begin main()");
		
		int[] data = {13, 17, 14, 11};
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the index [0, " + (data.length-1) + "]:");
		int targetIndex = scanner.nextInt();
		
		
		reportValue(data, targetIndex);
		
		//try{
		//	reportValue(data, targetIndex);
		//}
		//catch(RuntimeException re){
		//	System.out.println("The reportValue() schmuck didn't handle it. So, I guess I am handling it.");
		//}
		
		System.out.println("End main()");
	}

	
	
	/*
	 * THings to remember: catch(){} order is important.
	 * 		catch(MoreSpecialException e){} followed by catch(MoreGeneralException e){} is fine.
	 *      But, 
	 *      catch(MoreGeneralException e){} followed by catch(MoreSpecialException e){} is will not work and will not compile.. 
	 *      The later becomes unreachable..
	 * 
	 * How about throwing null Exception? Will it be allowed? If so, Which catch() block will catch it?
	 * 		Well. You can put the code of throwing 'null'. 
	 * 		But, at run time, it will throw an exception because it can't throw null.
	 */
	
	
	private static void reportValue(int[] array, int index){
		
		System.out.println("Begin reportValue()");
		
		try{
			System.out.println(array[index]);
			if(2>1) throw null;
		}
		catch(ArrayIndexOutOfBoundsException re){
			System.out.println("Wow! ArrayIndexOutOfBoundsException.");
			
		}
		catch(IndexOutOfBoundsException re){
			System.out.println("Woooooow! IndexOutOfBoundsException.");
		}
		
		System.out.println("End reportValue()");
	}
	
	
}








