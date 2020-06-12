package jrJava.aboutString;

public class AboutString3 {

	
	public static void main(String[] args) {
		
		// substring() overloaded:
		// substring(beginIndex) will substring from the begin index to the rest of the string.
		// substring(beginIndex, endIndex) will substring from the begin index to just ONE BEFORE THE END INDEX.
		// What these method will do is: They will create new String objects and return their references. It is EXPENSIVE OPS.
		
		String text = "I have many potatoes, tomatoes, pears, and apples.";
		
		String sub1 = text.substring(7);
		System.out.println(sub1);
		
		String sub2 = text.substring(7, 14); // the char at index 14 is 't'. But, 't' will not be part of the substring.
		                                     // It will cut off just one before the endIndex.
		System.out.println(sub2);
		
		// If the indices are invalid, it will IndexOutOfBoundsException.
		//text.substring(7, 100);
		
		// Use the method below:
		tokenize(text);
	}

	
	// develop a method that will print out all tokens(words) in the string.
	public static void tokenize(String text){
		
		int pos1, pos2 = -1; // 'pos1' points at the beginning of a word, 'pos2' points at the space right after the word.
		String each; 
		while(true){
			pos1 = pos2 + 1; // 'pos1' will points at the beginning of new word.
			pos2 = text.indexOf(' ', pos1); // finds the first space after the pos1.
			
			if(pos2<0){ // If it cannot find ' ', then this must be last word in the String. 
				each = text.substring(pos1); // Or, each = text.substring(pos1, text.length()); 
				System.out.println(each);
				break;
			}
			
			each = text.substring(pos1, pos2); // Remember, it cuts just before pos2.
			System.out.println(each);
		}
	}
}
