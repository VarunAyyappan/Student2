package jrJava.hashMap;

public class Test {

	public static void main(String[] args) {
		SimpleHashMap<Thing, String> map = new SimpleHashMap<Thing, String>(5);
		
		map.put(new Thing(1, 2, 3), "123");
		map.put(new Thing(2, 1, 3), "213");
		map.put(new Thing(3, 2, 1), "321");
		
		map.printAll();
		
		String tossedOut = map.put(new Thing(2, 1, 3), "000");
		map.printAll();
		System.out.println(tossedOut);
		
		String value = map.get(new Thing(3, 2, 1));
		System.out.println(value);
	}

}
 