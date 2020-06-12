package jrJava.linkedList;


public class LinkedList {

	
	// ----------------------------------------------------
	
	private Link current, previous;
	
	
	public void reset(){
		current = null;
		previous = null;
	}
	
	public boolean hasNext(){
		if(current==null && previous==null) return first!=null;
		return current.next!=null;
	}
	
	
	public Link next(){
		if(current==null && previous==null){
			current = first;
		}
		else {
			previous = current;
			current = current.next;
		}
		
		return current;
	}
	
	
	// ----------------------------------------------------
	
	
	private Link first;
	
	
	public LinkedList(){
		first = null; // redundant
	}
	
	
	
	public boolean isEmpty(){
		return first==null;
	}
	
	
	public Link getFirst(){
		return first;
	}
	
	
	public void insertAtBeginning(int id, double value){
		Link toInsert = new Link(id, value);
		toInsert.next = first;
		first = toInsert;
	}
	
	
	public void insertAtEnd(int id, double value){
		Link toInsert = new Link(id, value);
		
		if(first==null){
			first = toInsert;
			return;
		}
		
		Link current = first;
		while(current.next!=null){
			current = current.next;
		}
		current.next = toInsert;
	}
	
	
	public void insert(int id, double value){ // sorted by the id.
		Link toInsert = new Link(id, value);
		
		Link current = first;
		Link previous = null;
		
		while(current!=null && current.id<id){
			previous = current;
			current = current.next;
		}
		
		// case 1: Empty (previous==null)
		// case 2: Normal case (current.id>=id)
		// case 3: End (current==null, previous!=null)
		// case 4: First (current!=null, previous==null)
		
		if(previous==null){ // case 1 and case 4
			if(first!=null) toInsert.next = first;// case 4
			first = toInsert;
		}
		else { // case 2 and case 3
			previous.next = toInsert;
			toInsert.next = current;
		}
	}
	
	
	public Link remove(int id){
		
		if(first==null) return null;
		
		Link current = first;
		Link previous = null;
		
		while(current.id!=id){
			previous = current;
			current = current.next;
			if(current==null) return null; // reached the end.
		}
		
		if(previous==null) first = first.next; // The first happens to be the one to be removed.
		else previous.next = current.next;
		
		return current;
	}
	
	
	public Link find(int id){
		Link current = first;
		while(current!=null){
			if(current.id==id) return current;
			current = current.next;
		}
		return null;
	}
	
	
	public int size(){
		int count = 0;
		Link current = first;
		while(current!=null){
			count++;
			current = current.next;
		}
		return count;
	}
	
	
	public Link removeFirst(){
		Link toRemove = first;
		if(first!=null) first = first.next;
		return toRemove;
	}
	
	
	public Link removeEnd(){
	
		if(first==null) return null;
		
		Link current = first;
		Link previous = null;
		
		while(current.next!=null){
			previous = current;
			current = current.next;
		}
		
		if(previous==null) first = null;
		else previous.next = null;
		
		return current;
	}
	
	
	public Link get(int index){
		
		if(index<0 || index>size()) throw new IndexOutOfBoundsException();
		
		Link current = first;
		for(int i=0; i<=index; i++){
			if(i==index) return current;
			current = current.next;
		}
		return null;
	}
	
	
	
	public String toString(){
		
		if(isEmpty()) return "Empty";
		
		StringBuilder sb = new StringBuilder();
		
		Link current = first;
	
		while(current!=null){
			sb.append(current.toString());
			sb.append(" ");
			current = current.next;
		}
		
		return sb.toString();
	}
	
}











