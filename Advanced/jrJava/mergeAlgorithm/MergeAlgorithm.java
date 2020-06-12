package jrJava.mergeAlgorithm;

public class MergeAlgorithm {

	public static void main(String[] args) {
		
		// Already sorted
		int a[] = {1,4,5,5,9,12,16,18};
		int b[] = {2,3,5,8,9,11};
		
		int c[] = merge(a, b);
		printIntArray(c);
		
	}

	private static int[] merge(int[] a, int[] b) {
		int c[] = new int[a.length + b.length];
		
		int aInd = a.length-1;
		int bInd = b.length-1;
		
		for(int i=c.length-1; i>=0; i--) {
			if(bInd>=0 && b[bInd]>=a[aInd]) {
				c[i] = b[bInd];
				bInd--;
			}
			else if(aInd>=0) {
				c[i] = a[aInd];
				aInd--;
			}
		}
		
		return c;
	}
	
	private static void printIntArray(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
	}

}
