package jrJava.aboutString;

import java.util.StringTokenizer;

public class UsingStringTokenizer2 {

	public static void main(String[] args) {
		
		String text = "	   	   I [::	have	    a ][	;;,   book.]";

		// Here, the example shows using special characters using escape sequence '\' 
		// such as '\t' (tab) as one of the delimiters.
		StringTokenizer st = new StringTokenizer(text, "\t[] :,;");

		String token;
		while(st.hasMoreTokens()){
			token = st.nextToken();
			System.out.println(token);
		}
		
	}

}
