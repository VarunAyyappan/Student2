package jrJava.linkedList3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> {

	
	private Link<E> first;
	
	public LinkedList(){
		first = null; // redundant
	}
	
	
	public Iterator<E> iterator(){
		return new MyIterator();
	}
	
	
	public boolean isEmpty(){
		return first==null;
	}

	public Link<E> getFirst(){
		return first;
	}
	
	public int size(){
		int count = 0;
		Link<E> current = first;
		while(current!=null){
			count++;
			current = current.next;
		}
		return count;
	}
	
	
	public void insertAtBeginning(E obj){
		Link<E> toInsert = new Link(obj);
		toInsert.next = first;
		first = toInsert;
	}
	
	
	public E removeFirst(){
		Link<E> toRemove = first;
		if(first!=null) first = first.next;
		return toRemove.obj;
	}
	
	
	public String toString(){
		
		if(isEmpty()) return "{empty}";
		
		StringBuilder sb = new StringBuilder();
		
		Link<E> current = first;
		while(current!=null){
			sb.append(current.toString());
			current = current.next;
		}
		
		return sb.toString();
	}
	
	
	
	private class MyIterator implements Iterator<E> {

		private Link<E> current, previous;
		
		public void reset(){
			current = null;
			previous = null;
		}
		
		public boolean hasNext(){
			if(current==null && previous==null) return getFirst()!=null;
			return current.next!=null;
		}
		
		public E next(){
			if(current==null && previous==null){
				current = getFirst();
			}
			else {
				previous = current;
				current = current.next;
			}
			return current.obj;
		}
		
		
		public void remove(){
			if(current==null) throw new NoSuchElementException();
			
			if(previous==null){
				first = current.next;
				reset();
			}
			else {
				previous.next = current.next;
				current = previous;
			}
		}
		
	}
	
	
	
	private static class Link<E> {  //Static member class.

		public Link<E> next;
		public E obj;
		
		public Link(E obj){
			this.obj = obj;
		}
		
		public String toString(){
			return "{" + obj.toString() + "} ";
		}
		
		public boolean equals(Object o){
			Link<E> other = (Link<E>) o;
			return obj.equals(other.obj);
		}
		
	}

}









