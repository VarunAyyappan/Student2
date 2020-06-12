package jrJava.myArrayList_generics;


public class Square {

	private int x, y;
	private int size;
	
	public Square(int x, int y, int size){
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public String toString(){
		return "x="+x+" y="+y+" size="+size + " " + super.toString();
	}
	
	/* This is not an overriding. It is an overloading.
	public boolean equals(Square o){
		if(x==o.x && y==o.y && size==o.size) return true;
		return false;
	}
	*/
	
	public boolean equals(Object other){
		Square o = (Square) other;
		if(x==o.x && y==o.y && size==o.size) return true;
		return false;
	}
	
}
