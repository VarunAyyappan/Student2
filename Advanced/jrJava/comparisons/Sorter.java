package jrJava.comparisons;

public class Sorter {

	
	public static void insertSort(int[] values){
		
		int i, j, temp;
		
		// i: ending index of the increasing window. Current window will be [0, i].
		// i will change from 1 to values.length-1.
		for(i=1; i<values.length; i++){
		
			// All elements up to (i-1) are inn sorted order. values[i] is the new guy.
			// We need to insert the new guy by using the insertion algorithm:
			
			temp = values[i];
			for(j=i-1; j>=0; j--){
				if(values[j]>temp)  values[j+1] = values[j];
				else break;
			}
			
			values[j+1] = temp;
		}
		
	}
	
	
	
	public static void selectSort(int[] values){
	
		int i, j, minIndex, temp;
		// We will use a variable, i, to indicate the start position of the 
		// shrinking window. So, i will change from 0 to values.length-2.
		
		for(i=0; i<values.length-1; i++){
		
			// The following will select the minIndex (index at which min is stored) in the window.
			// say, the window is [i, values.length-1].
			minIndex = i;
			for(j=i+1; j<values.length; j++){
				if(values[j]<values[minIndex])  minIndex = j;
			}
		
			// swap the value at minIndex with the values at the beginning of the window, at i.
			temp = values[i];
			values[i] = values[minIndex];
			values[minIndex] = temp;
		}
		
	}
	
	 
	
	
	
	public static void bubbleSort(int[] values){
		int i, temp; // temp is for swapping.
		boolean sorted = false; 
		
		while(!sorted){ // while(sorted==false){
			// We will slide a window of size 2. It will have head and tail.
			// If the head and tail are in wrong order, we will swap them.
			// We will keep track of position of the head using i.
			// It will start at i=0 and ends at i=values.length-2.
			// The element of the head is values[i] and the element in the tail is values[i+1]
			sorted = true; // It assumes that they are sorted.
			for(i=0; i<values.length-1; i++){
				
				if(values[i]>values[i+1]){ // They are wrong order. We will swap them.
					temp = values[i];
					values[i] = values[i+1];
					values[i+1] = temp;	
					sorted = false;  // The assumption is betrayed.
				}
			}
		}
	}
	
	
	private static void print(int[] values){
		for(int i=0; i<values.length; i++) System.out.print(values[i] + " ");
		System.out.println();
	}
	
	
	private static int[] createIntArray(int size){
		int[] values = new int[size];
		for(int i=0; i<values.length; i++){
			values[i] = (int)(Math.random()*size/2);
		}
		return values;
	}
	
	
	
	public static void main(String[] args) {
		
		int[] a = createIntArray(30);
		print(a);
		insertSort(a);
		print(a);
		
		
		//int[] a = createIntArray(200000);
		//long start = System.currentTimeMillis();
		//selectSort(a);
		//long end = System.currentTimeMillis();
		//System.out.println(end-start); 
		
		
		//int[] a = {11, 7, 1, 4, 20, 6, 15};
		//print(a);
		//bubbleSort(a);
		//print(a);
		//selectSort(a);
		//print(a);
	}

}









