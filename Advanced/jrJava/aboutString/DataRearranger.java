package jrJava.aboutString;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataRearranger {

	
	public static void main(String[] args) throws Exception {
		
		// Read in line by line from the file:
		Scanner scanner = new Scanner(new File("jrJava/aboutString/employeeData.txt"));
		
		String each;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		boolean notFirstData = false;
		String[] fields = new String[2];
		
		while(scanner.hasNextLine()){
			each = scanner.nextLine();
			if(notFirstData){
				sb1.append(',');
				sb2.append(',');
			}
			else{
				notFirstData = true;
			}
			getFields(each, fields);
			sb1.append(fields[0]);
			sb2.append(fields[1]);
		}
		
		String lastNames = sb1.toString();
		System.out.println(lastNames);
		String salaries = sb2.toString();
		System.out.println(salaries);
	}

	
	
	private static void getFields(String line, String[] fields){
		
		fields[0] = "N/A";
		fields[1] = "N/A";
		
		// StringTokenize the line using ',' as the delimiter.
		StringTokenizer st = new StringTokenizer(line, ",");
		
		// iterate thru, trim(), and find out the token that starts with "name".
		String each;
		int pos;
		while(st.hasMoreTokens()){
			each = st.nextToken().trim();
			if(each.startsWith("name")){
				// substring the string after the '=' sign. trim()
				pos = each.indexOf('=');
				each = each.substring(pos+1).trim();
				//find the last index of ' ' and substring after it.
				pos = each.indexOf(' ');
				each = each.substring(pos+1);
				fields[0] = each;
			}
			else if(each.startsWith("salary")){
				// substring the string after the '=' sign. trim()
				pos = each.indexOf('=');
				each = each.substring(pos+1).trim();
				fields[1] = each;
			}
		}
		
	}
	
	
}













