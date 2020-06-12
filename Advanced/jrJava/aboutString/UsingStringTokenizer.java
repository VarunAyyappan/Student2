package jrJava.aboutString;

import java.util.StringTokenizer;

public class UsingStringTokenizer {

	public static void main(String[] args) {
		
		String diary = ",   I  was ; at ::  Alcatraz , ;   earlier  ;  today. :;  They  , gave:me ; a green wrist   band with   prison ID.  I totally felt at home.  ";

		// java.util.StringTokeinzer will do tokenizing job for you in a very efficient way.
		// If you know what will be the separators (called delimiters, such as space, comma, semicolon, colon, etc.),
		// this StringTokenizer object will walk through the string and substring all words 
		// separated by the delimiters you specify.
		// It uses two cursors to keep track of each token in the string. 
		// It works in an interactive mode with you. If it points at the beginning of a token, 
		// if you ask hasMoreToken(), it will return true. If you call nextToken() method, it will
		// find the end of the token and substring it, and returns the reference of the substring object.
		// It will repeat this iteration pattern. See the example code below:
		
		StringTokenizer st = new StringTokenizer(diary, " :,;"); // The second parameter specifies all the delimiters it uses.

		String token;
		while(st.hasMoreTokens()){
			token = st.nextToken();
			System.out.println(token);
		}
		
	}

}

