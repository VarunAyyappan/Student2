package jrJava.hashCodes;


public class Thing {

	private int a;
	private int b;
	private int c;
	
	
	public Thing(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	
	public String toString(){
		return getClass() + ", a=" + a + ", b=" + b + ", c=" + c;
	}
	
	
	public boolean equals(Object o){
		if(!(o instanceof Thing)) return false;
		Thing other = (Thing) o;
		return a==other.a && b==other.b && c==other.c;
	}
	
	
	public int hashCode(){
		return a + b + c;
	}
	
}






