package jrJava.quickSorting;

public class ObjectQuickSorter {

	private Comparable[] values;

	public void quickSort(Comparable[]values) {
		this.values = values;
		quickSort(0, values.length-1);
	}

	private void quickSort(int low, int high) {
		if(low>=high) return;
		
		Comparable pivot = values[(low + high)/2];     // This looks good, but that's all there is to it.
		
		int i=low, j=high; 
		Comparable temp;

		while (i<=j) {
			while (values[i].compareTo(pivot)<0) i++;
			while (values[j].compareTo(pivot)>0) j--;

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
