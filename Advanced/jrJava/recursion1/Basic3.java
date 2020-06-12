package jrJava.recursion1;

public class Basic3 {

public static void main(String[] args) {
		mm(0);
	}

	
	public static void mm(int a){
		
		a++;
		System.out.println("a=" + a);
		
		if(a>=10) return;
		
		mm(a);
		
	}
	
	
}
