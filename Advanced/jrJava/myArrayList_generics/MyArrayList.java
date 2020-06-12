package jrJava.myArrayList_generics;


public class MyArrayList<E> {

	private E[] objects;
	private int currentSize; // length of array
	private int lastElementIndex; // indicates number of elements.
	private int sizeIncrement;
	
	public MyArrayList(){
		// default 10
		this(10);
	}
	
	
	public MyArrayList(int size){
		currentSize = size;
		sizeIncrement = size;
		objects = (E[]) new Object[currentSize];
		lastElementIndex = -1;
	}
	
	
	public int size(){
		return lastElementIndex + 1;
	}
	
	
	public E get(int index){
		if(index<0 || index>lastElementIndex) throw new IndexOutOfBoundsException();
		return objects[index];
	}
	
	
	public void add(E obj){
		add(lastElementIndex+1, obj);
	}
	
	
	
	public void add(int index, E obj){
		if(index<0 || index>lastElementIndex+1) throw new IndexOutOfBoundsException(); 
		
		if(lastElementIndex==objects.length-1){
			currentSize += sizeIncrement;
			E[] objects2 = (E[]) new Object[currentSize];
			for(int i=0; i<=lastElementIndex; i++) objects2[i] = objects[i];
			objects = objects2;
			System.out.println("Size has increased to " + currentSize); 
		}
		
		for(int i=lastElementIndex; i>=index; i--)  objects[i+1] = objects[i]; 
		objects[index] = obj;
		lastElementIndex++;
	}
	
	
	
	public E remove(int index){
		if(index<0 || index>lastElementIndex) throw new IndexOutOfBoundsException();
		
		E toReturn = objects[index];
		for(int i=index; i<=lastElementIndex-1; i++) objects[i] = objects[i+1];
		objects[lastElementIndex] = null;
		lastElementIndex--;
		
		if(size()>0 && size()<=currentSize-sizeIncrement){
			currentSize -= sizeIncrement;
			E[] objects2 = (E[]) new Object[currentSize];
			for(int i=0; i<=lastElementIndex; i++) objects2[i] = objects[i];
			objects = objects2;
			System.out.println("Size has decreased to " + currentSize); 
		}
		
		return toReturn;
	}
	
	
	
	public boolean remove(Object obj){
		for(int i=0; i<=lastElementIndex; i++){
			if(obj.equals(objects[i])){
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder("MyArrayList: ");
		for(int i=0; i<=lastElementIndex; i++){
			if(objects[i]!=null) sb.append(objects[i].toString());
			else sb.append("null");
			sb.append("  ");
		}
		return sb.toString();
	}
	
	
	// We should delete this method once it is tested.
	public void printAll(){
		for(int i=0; i<objects.length; i++){
			if(objects[i]!=null) System.out.print(objects[i].toString() + "  ");
			else System.out.print("null  ");
		}
		System.out.println();
	}
	
}











