package jrJava.exceptionHandling;

import java.util.Scanner;

public class Practice1 {

	
	public static void main(String[] args) /*throws InterruptedException*/ {
		
		System.out.println("Type in time in ms:");
		Scanner scanner = new Scanner(System.in);
		int sleepTime;
		
		while(true){
			sleepTime = scanner.nextInt();
			if(sleepTime>=0 && sleepTime<10000) break;
			System.out.println("YOU #$%$#% %^$%^$^%! Type in a number [0, 10000].");
		}
		
		//Thread.currentThread().sleep(5);
		
		try{
			Thread.currentThread().sleep(sleepTime);
		}
		catch(InterruptedException ie){
			long start = System.currentTimeMillis();
			while(true){
				if(System.currentTimeMillis()>start+5) break;
			}
		}
		
	
		
		System.out.println("Goodbye");
	}

}
