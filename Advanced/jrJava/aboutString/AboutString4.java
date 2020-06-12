package jrJava.aboutString;

public class AboutString4 {

	
	public static void main(String[] args) {
		
		// trim(): will trim the preceding and trailing spaces (But, the ones in the middle)
		// replace(): will replace old with new one.
		// Both operations will create new String objects. So, they are expensive ops.
		
		String text = "  Hel lo "; // has two preceding spaces and one trailing space.
		String trimmed = text.trim();
		System.out.println(trimmed);
		
		String replaced = trimmed.replace(" ", "");
		System.out.println(replaced);
		
		// Do more of your own experiments.
		
		// You can chain the method calls as followings.
		// Each method call will return newly created String object.
		// So, the whole operating is expensive. The following will create
		// total of three string objects.
		
		text = text.trim().replace(" ", "").substring(2);
		System.out.println(text);
	}

}
