package jrJava.hashSet;


public class SimpleHashSet<E> {

	
	private Object[] objs;
	
	public SimpleHashSet(int size){
		objs = new Object[size];
	}
	
	
	public E add(E obj){
		Entry<E> entry = new Entry<E>(obj);
		int index = obj.hashCode()%objs.length;
		
		Entry<E> p = (Entry<E>) objs[index];
		if(p==null){
			objs[index] = entry;
			return null;
		}
		else if(p.obj.equals(obj)){
			entry.next = p.next;
			objs[index] = entry;
			return p.obj;
		}
		
		Entry<E> c = p.next;
		while(c!=null){
			if(c.obj.equals(obj)){
				entry.next = c.next;
				p.next = entry;
				return c.obj;
			}
			p = c;
			c = c.next;
		}
		
		p.next = entry;
		return null;
	}
	
	
	
	public E get(E searchKey){
		int index = searchKey.hashCode()%objs.length;
		
		Entry<E> c = (Entry<E>) objs[index];
		while(c!=null){
			if(c.obj.equals(searchKey)) return c.obj;
			c = c.next;
		}
		return null;
	}
	
	
	public void printAll(){
		Entry<E> p, c;
		for(int i=0; i<objs.length; i++){
			p = (Entry<E>) objs[i];
			System.out.print(p);
			
			if(p!=null){
				c = (Entry<E>) p.next;
				while(c!=null){
					System.out.print("-->" + c);
					c = c.next;
				}
			}
			System.out.println(); 
		}
		System.out.println();
	}
	
	
	private static class Entry<E> {
		
		public E obj;
		public Entry<E> next;
	
		public Entry(E obj){
			this.obj = obj;
		}
		
		public String toString(){
			return "[" + obj + "]";
		}
	}
	
}








