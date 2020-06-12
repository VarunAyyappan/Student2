package jrJava.quickSorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] sample = createIntArray(40);
		printIntArray(sample);
		quickSort(sample);
		printIntArray(sample);
	}

	public static void quickSort(int[]values) {
		quickSort(values, 0, values.length-1);
	}

	public static void quickSort(int[] values, int low, int high) {
		if(low>=high) return;
		
		int pivot = values[(low + high)/2];     // This looks good, but that's all there is to it.
		
		int i=low, j=high, temp;

		while (i<=j) {
			while (values[i]<pivot) i++;
			while (values[j]>pivot) j--;

			if(i<=j) {
				temp = values[i];
				values[i] = values[j];
				values[j] = temp;
				i++;
				j--;
			}
		}
	
		quickSort(values, low, j);
		quickSort(values, i, high);
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
