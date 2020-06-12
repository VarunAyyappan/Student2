package jrJava.recursion2;

public class Palindrome {

	public static void main(String[] args) {
		/*
		String sample = "I had a dinner.";
		System.out.println(sample.length());
		System.out.println("I had a dinner.".length());
		
		char first = sample.charAt(0);
		System.out.println(first);
		char last = sample.charAt(sample.length()-1);
		System.out.println(last);
		
		int pos1 = sample.indexOf('d');
		System.out.println(pos1);
		int pos2 = sample.indexOf("d", pos1);
		System.out.println(pos2);
		*/
		
		String phrase = "tacocat";
		System.out.println(isPalindrome(phrase, 0, phrase.length()-1));
	}
	
	public static boolean isPalindrome(String phrase, int start, int end) {
		if(start>=end)
			return true;
		else if(phrase.charAt(start)==phrase.charAt(end))
			 return isPalindrome(phrase, start+1, end-1);
		else
			return false;
	}

}
