package jrJava.aboutString;

public class Practice2 {

	
	public static void main(String[] args) {
		
		// length(), charAt()
		
		String word = "I love you guys except Richard.";
		
		int len = word.length();
		
		char c1 = word.charAt(0);
		System.out.println(c1); 
		char cn = word.charAt(word.length()-1);
		System.out.println(cn);
		char cf = word.charAt(word.length()/2); 
		System.out.println(cf);
		System.out.println(word.length()/2);
		
		
		for(int i=0; i<word.length(); i++){
			System.out.println(i + " " + word.charAt(i)); 
		}
		
		
	}

}
