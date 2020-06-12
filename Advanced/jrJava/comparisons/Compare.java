package jrJava.comparisons;

import jrJava.mergeAlgorithm.MergeSort;
import jrJava.quickSorting.QuickSort;

public class Compare {

	public static void main(String[] args) {
		
		int[] dataA = createIntArray(300000);
		int[] dataB = dataA.clone();
		int[] dataC = dataA.clone();
		
		long t = System.currentTimeMillis();
		MergeSort.mergeSort(dataA);
		System.out.println(System.currentTimeMillis() - t); 
		
		t = System.currentTimeMillis();
		QuickSort.quickSort(dataB, 0, dataB.length-1);
		System.out.println(System.currentTimeMillis() - t); 
		
		t = System.currentTimeMillis();
		Sorter.selectSort(dataC);
		System.out.println(System.currentTimeMillis() - t); 
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
	
}
