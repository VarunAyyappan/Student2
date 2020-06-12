package jrJava.linkedList2;


public class Link {

	public Link next;
	public int id;
	public double value;
	
	public Link(int id, double value){
		this.id = id;
		this.value = value;
	}
	
	public String toString(){
		return "{" + id +", " + value + "}";
	}
	
	public boolean equals(Object o){
		Link other = (Link) o;
		if(id==other.id && value==other.value) return true;
		return false;
	}
	
}
