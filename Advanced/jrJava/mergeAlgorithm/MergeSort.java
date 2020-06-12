package jrJava.mergeAlgorithm;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = createIntArray(32);
		printIntArray(a);
		mergeSort(a);
		printIntArray(a);
	}
	
	public static void mergeSort(int[] values) {
		int[] temp = new int[values.length];
		mergeSort(values, 0, values.length-1, temp);
	}
	
	private static void mergeSort(int[] values, int low, int high, int[] temp) {
		if (low>=high) return; 
		
		int mid = (low+high)/2;
		mergeSort(values, low, mid, temp);
		mergeSort(values, mid+1, high, temp);
		
		temp = new int[values.length];
		
		for (int i=low; i<=high; i++) temp[i] = values[i];
		
		int i = low, j = mid+1, k = low;
		while(i<=mid && j<=high) {
			if(temp[i]<=temp[j]) values[k++] = temp[i++];
			else values[k++]= temp[j++];
		}
		
		while(i<=mid) values[k++] = temp[i++];
		//while(j<=high) values[k++] = temp[j++];   *Not needed!
		
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
