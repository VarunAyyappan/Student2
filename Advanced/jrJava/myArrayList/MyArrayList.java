package jrJava.myArrayList;

public class MyArrayList {

	private Object[] objects;
	private int currentSize;  // array length
	private int lastElementIndex;
	private int sizeIncrement;

	public MyArrayList() {
		this(10);
	}

	public MyArrayList(int size) {
		currentSize = size;
		objects = new Object[currentSize];
		lastElementIndex = -1;
		sizeIncrement = size;
	}

	public int size() {
		return lastElementIndex+1;
	}

	public Object get(int index) {
		if(index<0 || index>lastElementIndex)
			throw new IndexOutOfBoundsException();
		else
			return objects[index];
	}

	public void add(Object obj) {
		add(lastElementIndex+1, obj);
	}

	public void add(int index, Object obj) {
		if(index<0 || index>lastElementIndex+1)
			throw new IndexOutOfBoundsException();

		if(lastElementIndex == currentSize-1)
		{
			currentSize += sizeIncrement;
			Object[] temp = new Object[currentSize];
			for(int i=0; i<=lastElementIndex; i++)	temp[i] = objects[i];
			objects = temp;
		}

		for(int i=lastElementIndex; i>=index; i++)
			objects[i+1] = objects[i];

		objects[index] = obj;
		lastElementIndex++;
	}

	public Object remove(int index) {
		if(index<0 || index>lastElementIndex)
			throw new IndexOutOfBoundsException();

		Object toReturn = objects[index];
		for(int i=index; i<lastElementIndex; i++)
			objects[i] = objects[i+1];

		objects[lastElementIndex] = null;
		lastElementIndex--;
		return toReturn;
	}

	public boolean remove(Object obj) {
		for(int i=0; i<lastElementIndex; i++) {
			if(objects[i]==obj) {
				remove(i);
				return true;
			}
		}

		return false;
	}

	public String toString() {
		StringBuilder description = new StringBuilder("My ArrayList: ");

		for(int i=0; i<lastElementIndex; i++) {
			if(objects[i] != null)
				description.append(objects[i].toString());
			else
				description.append("null");

			description.append(" ");
		}

		return description.toString();
	}

	// for testing only!
	protected void printAll() {
		for(int i=0; i<lastElementIndex; i++)
			System.out.println(objects[i] + " ");

		System.out.println();
	}
}
