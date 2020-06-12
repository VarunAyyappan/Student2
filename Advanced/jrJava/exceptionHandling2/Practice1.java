package jrJava.exceptionHandling2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Practice1 {

	
	public static void main(String[] args) throws Exception {
		accessFile();
	}

	
	private static void accessFile() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in the file name:");
		String typedFileName = scanner.next();
		
		System.out.println("Type in the pause time");
		int pauseTime = scanner.nextInt();
		
		while(pauseTime < 0) {
			System.out.println("Please choose a number that is non-negative.");
			pauseTime = scanner.nextInt();
		}
		
		readFile(typedFileName, pauseTime);
	}
	
	
	
	private static void readFile(String fileName, int pauseTime) throws Exception {
		try { Thread.currentThread().sleep(pauseTime); }
		catch(InterruptedException e) { e.printStackTrace(); }
		
		String filePath = "jrJava/exceptionHandling2/" + fileName;
		
		File file = new File(filePath);
		Scanner scanner;
		String line;
		
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				line = scanner.nextLine();
				System.out.println(line);
			}
		}
		catch(FileNotFoundException e) { e.printStackTrace(); }
	}
	
}













