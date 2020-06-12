package jrJava.tree1;

import javax.swing.SortingFocusTraversalPolicy;

public class Test {

	public static void main(String[] args) {
		
		Tree tree = new Tree();

		tree.insert(51, 0.51);
		tree.insert(24, 0.24);
		tree.insert(37, 0.37);
		tree.insert(41, 0.41);
		tree.insert(31, 0.31);
		tree.insert(28, 0.36);
		tree.insert(43, 0.43);
		tree.insert(39, 0.39);
		tree.insert(12, 0.12);
		tree.insert(27, 0.27);
		tree.insert(79, 0.79);
		tree.insert(65, 0.65);
		tree.insert(59, 0.59);
		tree.insert(91, 0.91);
		tree.insert(75, 0.75);
		tree.insert(77, 0.77);
		tree.insert(76, 0.76);
		tree.insert(78, 0.78);
		tree.insert(61, 0.61);
		tree.insert(60, 0.60);
		tree.insert(62, 0.62);
		
		//tree.traverse();
		
		//System.out.println("Min: " + tree.minimum());
		//System.out.println("Max: " + tree.maximum());
		
		//System.out.println();
		//System.out.println();
		
		tree.traverseTopToBottom(); 
		
		//tree.insert(58,  0.58);
		//System.out.println("\n\n\n");
		
		//tree.traverseTopToBottom(); 
		System.out.println(tree.delete(59));
		System.out.println();
		tree.traverseTopToBottom(); 
		
	}

} 





