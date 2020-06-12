package jrJava.linkedList3;

public class Student {

	private int id;
	private double GPA;
	private boolean honor;
	private boolean expelled;
	
	
	public Student(int id, double GPA){
		this.id = id;
		this.GPA = GPA;
	}
	
	
	public double getGPA(){ return GPA; }
	public void setHonor(boolean honor){ this.honor = honor; }
	public void setExpelled(boolean expelled){ this.expelled = expelled; }
	public boolean getHonor(){ return honor; }
	public boolean getExpelled(){ return expelled; }
	
	
	public String toString(){
		return id + ", " + GPA + ", " + honor + ", " + expelled;
	}
	
}
