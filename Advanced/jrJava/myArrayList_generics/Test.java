package jrJava.myArrayList_generics;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		//ArrayList<Square> list = new ArrayList<Square>();
		MyArrayList<Square> list = new MyArrayList<Square>();
		
		Square s1 = new Square(1, 1, 1);
		System.out.println(s1);
		Square s2 = new Square(1, 1, 1);
		System.out.println(s2);
		
		list.add(s1);
		list.add(s2);
		System.out.println(list);
		
		list.remove(s2);
		System.out.println(list);
		
	}
 
}
 