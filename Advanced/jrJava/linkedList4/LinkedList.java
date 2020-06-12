package jrJava.linkedList4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The wrong implementation of LinkedList. {@code <E extends Comparable<E>>} Forces generic 
 * type to be E type, but Comparable is also generic. This is a recursive generic.
 * 
 * @author Richard Luo
 * @since January 6, 2018
 */
public class LinkedList<E extends Comparable<E>> {

	private Link<E> first;

	/**
	 * Creates an empty LinkedList
	 */
	public LinkedList() {
		first = null; //Redundant
	}

	/**
	 * Creates a new Iterator and returns it.
	 * @see Cursor
	 * 
	 * @return		A new Iterator
	 */
	public Iterator<E> getIterator() {
		return new Cursor();
	}
	
	/**
	 * The LinkedList is only empty if the first Link is null.
	 * @return		True if the LinkedList is empty; false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the reference of the first Link.
	 * @return		Reference of the first Link.
	 */
	private Link<E> getFirst() {
		return first;
	}

	/**
	 * Inserts the Link in sorted order. The method keeps jumping from the first Link 
	 * until it finds a Link greater than it. <p>There are four cases: <br>
	 * Case 1: Normal case (somewhere in the middle of the LinkedList)<br>
	 * Case 2: Empty (LinkedList has no elements)<br>
	 * Case 3: Least case (Link belongs at the beginning)<br>
	 * Case 4: Max case (Link belongs at the end)<br>
	 * 
	 * @param obj		The reference of the Object
	 */
	public void insert(E obj) {
		Link<E> toInsert = new Link<E>(obj);

		Link<E> current = first, previous = null;
		while(current != null && current.getObject().compareTo(obj) < 0) {
			previous = current;
			current = current.getNext();
		}

		if(previous == null) {
			if(first != null) toInsert.setNext(current);
			first = toInsert;
		}
		else {
			toInsert.setNext(current);
			previous.setNext(toInsert);
		}
	}

	/**
	 * Returns the {@code toString()} of all the Links in the LinkedList.
	 */
	@Override
	public String toString() {
		if(isEmpty()) return "{Empty}";

		StringBuilder sb = new StringBuilder();
		sb.append('[');

		Link<E> current = first;
		while(current != null) {
			sb.append(current.toString());
			current = current.getNext();
		}

		sb.append(']');
		return sb.toString();
	}
	
	/**
	 * Renamed version of IteratorImpl (jrJava's original code). Contains the proper methods and fields
	 * that an iterator should have.
	 * 
	 * @author Richard Luo
	 * @since December 26, 2017
	 */
	public class Cursor implements Iterator<E> {

		private Link<E> current, previous;
		/**
		 * Iterator pattern. Returns whether there is still a next.
		 * @return		True if next is not null; false otherwise
		 */
		@Override
		public boolean hasNext() {
			if(current == null && previous == null) return getFirst() != null;
			return current.getNext() != null;
		}

		/**
		 * Returns the next Link in the LinkedList. 
		 */
		@Override
		public E next() {
			if(current == null && previous == null) {
				current = getFirst();
			}
			else {
				previous = current;
				current = current.getNext();
			}
			
			return current.getObject();
		}
		
		public void remove() {
			if(current==null) throw new NoSuchElementException();
			
			if(previous==null) {
				first = current.getNext();
				reset();
			}
			else {
				previous.setNext(current.getNext());
				current = previous;
			}
		}
		
		/**
		 * Resets the current state of this Cursor. Changes {@code current} and {@code previous} to null.
		 */
		public void reset() {
			current = null;
			previous = null;
		}
	}
}
