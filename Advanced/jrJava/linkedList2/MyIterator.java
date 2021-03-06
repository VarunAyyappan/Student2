package jrJava.linkedList2;

public class MyIterator {
	private Link current, previous;
	private LinkedList list;

	public MyIterator(LinkedList list) {
		this.list = list;
	}
	
	public void reset(){
		current = null;
		previous = null;
	}
	
	public boolean hasNext(){
		if(current==null && previous==null) return list.getFirst()!=null;
		return current.next!=null;
	}
	
	
	public Link next(){
		if(current==null && previous==null){
			current = list.getFirst();
		}
		else {
			previous = current;
			current = current.next;
		}
		
		return current;
	}
}
