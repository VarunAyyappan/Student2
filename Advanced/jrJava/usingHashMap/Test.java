package jrJava.hashSet;

public class Test {

	public static void main(String[] args) {
		
		SimpleHashSet<Member> set = new SimpleHashSet<Member>(5);
		
		set.add(new Member(4, 44, 444)); 
		set.add(new Member(1, 11, 111));
		set.add(new Member(6, 66, 666));
		set.add(new Member(3, 33, 333));
		set.add(new Member(11, 1111, 111111));
		
		set.printAll();
		
		Member tossedOut = set.add(new Member(6, 6666, 6666666));
		System.out.println("The tossed-out = " + tossedOut);
		
		set.printAll();
		 
		Member searchKey = new Member(11);
		Member found = set.get(searchKey);
		System.out.println(found); 
	}

}
