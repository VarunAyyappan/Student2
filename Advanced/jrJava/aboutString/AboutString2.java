package jrJava.aboutString;

public class AboutString2 {

	
	public static void main(String[] args) {
		// indexOf() methods overloaded:   
		// indexOf(char) will return the index of the first occurrence of the character.
		// indexOf(char, fromIndex) will return the index of the first occurrence of the character, starting from the fromIndex.
		
		String text = "I have many potatoes, tomatoes, pears, and apples.";
		
		int index1 = text.indexOf('a'); // first occurrence of 'a'.
		System.out.println(index1);
		
		int index2 = text.indexOf('a', index1+1); // the next occurrence of 'a'.
		System.out.println(index2);
		
		// If the string does not contain the sought character, it will return -1.
		int index3 = text.indexOf('z'); 
		System.out.println(index3);
		
		// use the method below:
		findChar(text, 'a');
	}
	

	// develop a method that will print out all indices at which the character occurs
	public static void findChar(String text, char key){
		int pos = -1; // 'pos' points at the index of the key char.
		while(true){
			pos = text.indexOf(key, pos+1); // search the key starting right after the previous found index of the key.
			if(pos<0) break; // if -1 returns, there is no more key in the string. Break out.
			System.out.println(pos);
		}
	}
}
