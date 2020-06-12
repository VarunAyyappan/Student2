package jrJava.generic;

public class Storage<E> {
	private E data;

	public void setData(E data) {
		this.data = data;
	}

	public E getData() {
		return data;
	}
}
