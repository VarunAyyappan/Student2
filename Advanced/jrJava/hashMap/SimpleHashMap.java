package jrJava.hashMap;


public class SimpleHashMap<K, V> {

	private Object[] objs;


	public SimpleHashMap(int size){
		objs = new Object[size];
	}


	public V put(K key, V value){
		Pair<K, V> pair = new Pair<K, V>(key, value);
		int index = key.hashCode()%objs.length;
		Pair<K, V> p = (Pair<K, V>) objs[index];

		if(p==null){
			objs[index] = pair;
			return null;
		}
		else if(p.key.equals(key)){
			pair.next = p.next;
			objs[index] = pair;
			return p.value;
		}

		Pair<K, V> c = p.next;
		while(c!=null){
			if(c.key.equals(key)){
				pair.next = c.next;
				p.next = pair;
				return c.value;
			}
			p = c;
			c = c.next;
		}

		p.next = pair;
		return null;
	}



	public V get(K key){
		int index = key.hashCode()%objs.length;
		Pair<K, V> c = (Pair<K, V>) objs[index];
		while(c!=null){
			if(c.key.equals(key)) return c.value;
			c = c.next;
		}
		return null;
	}



	public void printAll(){
		Pair<K, V> p, c;
		for(int i=0; i<objs.length; i++){
			p = (Pair<K, V>) objs[i];
			System.out.print(p);

			if(p!=null){
				c = (Pair<K, V>) p.next;
				while(c!=null){
					System.out.print("-->" + c);
					c = c.next;
				}
			}
			System.out.println(); 
		}
		System.out.println();
	}





	private static class Pair<K, V> {
		public K key;
		public V value;
		public Pair<K, V> next;

		public Pair(K key, V value){
			this.key = key;
			this.value = value;
		}

		public String toString(){
			return "[" + key + ", " + value + "]";
		}
	}

}


