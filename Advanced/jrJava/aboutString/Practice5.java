package jrJava.aboutString;

public class Practice5 {

	public static void main(String[] args) {

		String diary = "I was Alcatraz earlier today. They gave me a green wrist band with Prison ID. I totally felt at home.";
		
		int end = 0;
		for(int i=0; i<diary.length(); i++) {
			if(diary.indexOf('.', i) < diary.indexOf(' ', i))
				end = diary.indexOf('.', i);
			else
				end = diary.indexOf(' ', i);

			if(end<0) {
				end = diary.length() -1;
			}

			System.out.println(diary.subSequence(i, end));
			i = end;
		}

	}

}
