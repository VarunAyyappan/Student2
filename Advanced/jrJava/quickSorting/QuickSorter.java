package jrJava.quickSorting;

public class QuickSorter {

	private int[] values;

	public void quickSort(int[]values) {
		this.values = values;
		quickSort(0, values.length-1);
	}

	private void quickSort(int low, int high) {
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
	}

}
