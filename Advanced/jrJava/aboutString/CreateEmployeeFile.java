package jrJava.aboutString;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreateEmployeeFile {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(new File("jrJava/aboutString/employee.txt"));
		String each;
		
		while(scanner.hasNextLine()){
			each = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(each, " ");
			System.out.print("name="+st.nextToken()+" "+st.nextToken()+",");
			System.out.print(" id="+st.nextToken()+",");
			System.out.print(" title="+st.nextToken()+",");
			System.out.print(" hiringDate="+st.nextToken()+",");
			System.out.print(" salary="+st.nextToken()+",");
			System.out.print(" dobYear="+st.nextToken()+",");
			System.out.print(" dobMonth="+st.nextToken()+",");
			System.out.print(" dobDate="+st.nextToken()+",");
			System.out.print(" gender="+st.nextToken()+",");
			System.out.print(" height="+st.nextToken()+",");
			System.out.print(" weight="+st.nextToken()+"\n");
		}
	}

}
