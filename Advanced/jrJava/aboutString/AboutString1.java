package jrJava.aboutString;

public class AboutString1 {

	
	public static void main(String[] args) {
		
		// length() returns the length of the string.
		// The starting index is 0 and the ending index is length()-1.
		String text = "I have a book.";
		int len = text.length();
		System.out.println(len);
		
		// charAt(index) will return the character at that index.
		char c0 = text.charAt(0);
		System.out.println(c0);
		char c1 = text.charAt(1);
		System.out.println(c1);
		char cn = text.charAt(text.length()-1);
		System.out.println(cn);
		
		// for invalid index, it will throw IndexOutOfBoundsException.
		text.charAt(text.length());
		
		// use method below:
		showChars(text);
	}

	
	// develop a method that will print all character in the string
	public static void showChars(String text){
		char each;
		for(int i=0; i<text.length(); i++){
			each = text.charAt(i);
			System.out.println("i="+i+"  char="+each);
		}
	}
}
