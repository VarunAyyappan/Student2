package jrJava.hashCodes;

public class Test {

	
	public static void main(String[] args) {
		
		//Object thing1 = new Thing(1, 2, 3);
		
		//Class c = thing1.getClass();
		//System.out.println(c); 
		
		//System.out.println(thing1.toString()); 
		
		Thing thing1 = new Thing(1, 1, 3);
		Thing thing2 = new Thing(1, 1, 3);
		
		//System.out.println(thing1.equals(thing2));
		System.out.println(thing1.toString());
		System.out.println(Integer.toHexString(thing1.hashCode()));

	}

}
 