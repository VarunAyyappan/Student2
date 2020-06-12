package jrJava.sorting_bubble;

public class BubbleSorter {

	public static void main(String[] args) {
		
		//int[] data = {45, 37, 25, 11, 5, 64, 77, 55, 88, 29, 91, 9};
		int[] data = Utility.createIntArray(200);
		Utility.print(data);
		
		sort(data);
		Utility.print(data);
	}

	
	// Performance:
	// 1. {2, 5, 6, 8, 11, 17} --> It will still have to scan once for confirmation.
	// 2. {2, 5, 8, 6, 11, 17} --> It will scan twice (one for ordering, one for confirmation.)
	// 3. {17, 2, 5, 6, 8, 11} --> It will scan twice (one for ordering (the 17 will be carried over all the way to the end), one for confirmation.)
	// 4. {5, 6, 8, 11, 17, 2} --> It will have to scan 6 times. (worst case)
	// 5. {17, 11, 8, 6, 5, 2} --> It will have to scan 6 times.  (worst case)
	// 6. If the length of array is 10, (w.c.s.) how many comparison needed? --> 10 scans. Each scan, 9 comparisons --> 10*9 --> 90. ~10*10.
	// 7. If the length of array is 100, (w.c.s.) how many comparison needed? --> 100 scans. Each scan, 99 comparisons --> 100*99 --> ~100*100.
	// 7. If the length of array is n, (w.c.s.) how many comparison needed? --> n scans. Each scan, (n-1) comparisons --> n*(n-1) --> ~n*n (quadratic).
	
	public static void sort(int[] values){
		int i, temp; // 'temp' is for swapping.
		boolean sorted = false;;
		
		while(!sorted){  // while(sorted==false){ 
			
			// We will scan the whole array. While we scan,
			// we compare the two consecutive elements, values[i] and values[i+1].
			// (so, the index 'i' will have the range of [0, len-2], not [0, len-1].
			// If the two elements are in incorrect order, we swap them.
			
			sorted = true; // Before we scan each time, we assume that the whole array is already sorted.
			
			for(i=0; i<values.length-1; i++){
				if(values[i]>values[i+1]){
					// Being inside here means, the two elements are in wrong order.
					// They need to be swapped.
					// Meaning, the assumption was wrong. We will have to scan again.
					sorted = false;
					temp = values[i];
					values[i] = values[i+1];
					values[i+1] = temp;
				}
			}
			
		}
	}
	
}





