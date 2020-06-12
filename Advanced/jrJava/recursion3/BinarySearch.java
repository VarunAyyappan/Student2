package jrJava.recursion3;

public class BinarySearch {

	public static void main(String[] args) {
		int[] data = {1, 1, 2, 3, 5, 8, 11, 13, 15, 15, 17, 22, 23, 24, 24, 29, 30, 31, 31, 33, 36, 38, 40, 46, 47, 49, 55, 56, 59, 60, 61, 63, 65, 79, 81, 85, 92, 98};
		System.out.println(binarySearch(data, 29));
		System.out.println(binarySearchRec(data, 29, 0, data.length-1));
	}
	
	public static int binarySearch(int[] data, int key) {
		int low = 0;
		int mid = data.length/2;
		int high = data.length -1; 
		
		while (low<=high) {
			mid = (low+high)/2;
			
			if(key==data[mid])
				return mid;
			else if(key>data[mid])
				low = mid+1;
			else
				high = mid-1;
		}
		
		return -1;
	}
	
	public static int binarySearchRec(int[] data, int key, int low, int high) {
		int mid = (low+high)/2;
		
		if(low>high)
			return -1;
		
		if(key==data[mid])
			return mid;
		else if (key>data[mid])
			return binarySearchRec(data, key, mid+1, high);
		else
			return binarySearchRec(data, key, low, mid-1); 
	}
	
}
