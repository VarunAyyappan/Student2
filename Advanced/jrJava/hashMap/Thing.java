package jrJava.hashMap;

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
		return "{" + a + ", " + b + ", " + c + "}";
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Thing)) return false;
		Thing t = (Thing) o;
		return a==t.a && b==t.b && c==t.c;
	}
	
	public int hashCode(){
		return a + b + c; //a*10000 + b*100 + c;
	}
}







