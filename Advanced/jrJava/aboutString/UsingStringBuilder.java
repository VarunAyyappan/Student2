package jrJava.aboutString;

public class UsingStringBuilder {

	public static void main(String[] args) {
		
		// Use of '+' is combining tokens is an expensive way of doing it.
		// It will chain
		
		
		String a = "I have a book." + " " + "You have a book." + " " + "He has a book." + " " + "She has a book." + " " + "We all have books.";
		String b = "I have a book.".concat(" ").concat("You have a book.").concat(" ").concat("He has a book.").concat(" ").concat("She has a book.").concat(" ").concat("We all have books.");
		
		System.out.println(a);
		System.out.println(b);
		
		StringBuilder sb = new StringBuilder();
		sb.append("I have a book.");
		sb.append(" ");
		sb.append("You have a book.");
		sb.append(" ");
		sb.append("He has a book.");
		sb.append(" ");
		sb.append("She has a book.");
		sb.append(" ");
		sb.append("We all have books.");
		
		String total = sb.toString();
		System.out.println(total);
		
		
		sb = new StringBuilder();
		sb.append('a');
		sb.append(5);
		sb.append(true);
		sb.append(" ");
		sb.append(7.77);
		sb.append(' ');
		sb.append("One");
		
		total = sb.toString();
		System.out.println(total);
		
	}

} 
 










