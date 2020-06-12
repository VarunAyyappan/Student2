package jrJava.quickSorting;

public class Partition {

	public static void main(String[] args) {
		int[] sample = createIntArray(40);
		printIntArray(sample);
		int pivot = 10;
		partition(sample, pivot);
		printIntArray(sample);
	}

	public static void partition(int[] values, int pivot) {
		int i=0, j=values.length-1, temp;
		
		while (i<j) {
			while (values[i]<=pivot) i++;
			while (values[j]>pivot) j--;
			
			if(i<j) {
				temp = values[i];
				values[i] = values[j];
				values[j] = temp;
			}
		}
	}

	public static int[] createIntArray (int length) {
		int[] values = new int[length];

		for(int i=0; i<length; i++) {
			values[i] = (int)(Math.random()*length/2);
		}

		return values;
	}

	public static void printIntArray(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}
	
}
