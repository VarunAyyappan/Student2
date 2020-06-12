package jrJava.aboutString;

public class Practice3 {

	public static void main(String[] args) {
		
		// indexOf(), substring(), replace(), etc.
		
		String text = "Half of summer is gone!";
		
		//int index1 = text.indexOf('z');
		//System.out.println(index1);
		
		int index1 = text.indexOf('o');
		System.out.println(index1);
				
		text.indexOf('o', index1+1);
		
		String oddText = "Tomato tomato potato potato";
		
		int index = 0;
		while(true){
			index = oddText.indexOf('o', index);
			System.out.println(index);
			if(index<0) break;
			index++;
		}
		
	}

}
