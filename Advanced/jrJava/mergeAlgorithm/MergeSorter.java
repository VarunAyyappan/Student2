package jrJava.mergeAlgorithm;

public class MergeSorter {

	private int[] values, temp;

	public void sort(int[] values) {
		this.values = values;
		temp = new int[values.length];
		mergeSort(0, values.length-1);
	}

	private void mergeSort(int low, int high) {
		if (low>=high) return; 

		int mid = (low+high)/2;
		mergeSort(low, mid);
		mergeSort(mid+1, high);

		temp = new int[values.length];

		for (int i=low; i<=high; i++) temp[i] = values[i];

		int i = low, j = mid+1, k = low;
		while(i<=mid && j<=high) {
			if(temp[i]<=temp[j]) values[k++] = temp[i++];
			else values[k++]= temp[j++];
		}

		while(i<=mid) values[k++] = temp[i++];
	}
	
}
