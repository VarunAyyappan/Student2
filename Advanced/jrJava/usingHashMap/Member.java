package jrJava.hashSet;

public class Member {

	private int id;
	private int field1;
	private int field2;
	
	public Member(int id){
		this.id = id;
	}
	
	public Member(int id, int field1, int field2){
		this.id = id;
		this.field1 = field1;
		this.field2 = field2;
	}
	
	
	public String toString(){ return id + ", " + field1 + ", " + field2; }
	
	
	public boolean equals(Object o){
		if(!(o instanceof Member)) return false;
		Member m = (Member) o;
		return id==m.id;
	}
	
	public int hashCode(){ return id; }
	
}
