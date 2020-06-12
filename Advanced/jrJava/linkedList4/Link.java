package jrJava.linkedList4;
/**
 * Wrong implementation of Link
 * 
 * @author Richard Luo
 * @since January 6, 2018
 */
public class Link<E extends Comparable<E>> {

	/**
	 * Holds the reference of the next Link. If no such Link exists, this is a null-pointer.
	 */
	private Link<E> next;
	private E obj;

	/**
	 * Creates a new Link holding the specified type.
	 * @param obj		The object type this Link will contain.
	 */
	public Link(E obj) {
		this.obj = obj;
	}

	public Link<E> getNext() { return next; }
	public E getObject() { return obj; }
	public void setNext(Link<E> next) { this.next = next; }
	public void setObject(E obj) { this.obj = obj; }
	
	/**
	 * Returns the object's toString
	 */
	@Override
	public String toString() {
		return "{" + obj.toString()+ "}";
	}

	/**
	 * Determines whether the object that this Link contains is equal to the specified object
	 * @param o			The object to be compared to
	 */
	@Override
	public boolean equals(Object o) {
		return o.equals(obj);
	}
}