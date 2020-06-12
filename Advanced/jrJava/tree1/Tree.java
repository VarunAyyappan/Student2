package jrJava.tree1;

import java.util.Stack;

public class Tree {

	private Node root;
	
	public Tree(){
		root = null;
	}
	
	
	public Node find(int id){
		
		if(root==null) return null;
		
		Node current = root;
		
		while(current.id!=id){
			if(id<current.id) current = current.leftChild;
			else  current = current.rightChild;
			
			if(current==null) return null;
		}
		
		return current;
	}
	
	
	
	public void insert(int id, double value){
		Node node = new Node(id, value);
		
		if(root==null){
			root = node;
			return;
		}
		
		Node current = root;
		Node parent; 
		
		while(true){
			
			parent = current;
			if(id<current.id){
				current = current.leftChild;
				if(current==null){
					parent.leftChild = node;
					return;
				}
			}
			else {
				current = current.rightChild;
				if(current==null){
					parent.rightChild = node;
					return;
				}
			}
			
		}
	}
	
	
	
	public boolean delete(int id){
		
		if(root==null) return false;
		
		// let's locate the delete-node.
		// maintain the parent and also left/right direction.
		
		Node current = root;
		Node parent = root;
		boolean isLeftChild = false; // is deleteNode its parent's leftChild?
		
		while(current.id!=id){
			parent = current;
			if(id<current.id){
				current = current.leftChild;
				isLeftChild = true;
			}
			else {
				current = current.rightChild;
				isLeftChild = false;
			}
			
			if(current==null) return false;
		}
		
		// Case 1: It has no children.
		if(current.leftChild==null && current.rightChild==null){
			if(current==root) root = null;
			else if(isLeftChild) parent.leftChild = null;
			else parent.rightChild = null;
		}
		
		// Case 2: It has only one child and it is its left child.
		else if(current.rightChild==null){
			if(current==root) root = current.leftChild;
			else if(isLeftChild) parent.leftChild = current.leftChild;
			else parent.rightChild = current.leftChild;
		}
		
		// Case 3: It has only one child and it is its right child.
		else if(current.leftChild==null){
			if(current==root) root = current.rightChild;
			else if(isLeftChild) parent.leftChild = current.rightChild;
			else parent.rightChild = current.rightChild;
		}
		
		// Case 4: It has both children.
		else {
			Node successor = getSuccessor(current);
			
			if(current==root) root = successor;
			else if(isLeftChild) parent.leftChild = successor;
			else parent.rightChild = successor;
			
			successor.leftChild = current.leftChild;
		}
		
		return true;
	}
	
	
	
	private Node getSuccessor(Node deleteNode){
		Node current = deleteNode.rightChild;
		Node successor = deleteNode.rightChild;
		Node successorParent = deleteNode.rightChild;
		
		while(current!=null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor!=deleteNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = deleteNode.rightChild;
		}
		
		return successor;
	}
	
	
	
	public void traverse(){
		traverse(root);
	}
	
	
	private void traverse(Node node){
		if(node==null) return;
		traverse(node.leftChild);
		System.out.println(node);
		traverse(node.rightChild);
	}
	
	
	
	public void traverseTopToBottom(){
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		int ns = 64;
		boolean isRowEmpty = false;
		
		while(!isRowEmpty){
			
			Stack<Node> eachStack = new Stack<Node>();
			isRowEmpty = true;
			for(int i=0; i<ns; i++) System.out.print(' ');
			
			while(!stack.isEmpty()){
				Node each = stack.pop();
				if(each!=null){
					System.out.print(each.id);
					eachStack.push(each.leftChild);
					eachStack.push(each.rightChild);
					if(each.leftChild!=null || each.rightChild!=null) isRowEmpty = false;
				}
				else {
					System.out.print("--");
					eachStack.push(null);
					eachStack.push(null);
				}
				
				for(int i=0; i<2*ns-2; i++) System.out.print(' ');
			}
			System.out.println("\n"); 
			ns /= 2;
			
			while(!eachStack.isEmpty()) stack.push(eachStack.pop());
		}
	}
	
	
	
	
	
	public Node minimum(){
		
		if(root==null) return null;
		Node current = root;
		while(current.leftChild!=null){
			current = current.leftChild;
		}
		return current;
	}
	
	public Node maximum(){
		
		if(root==null) return null;
		Node current = root;
		while(current.rightChild!=null){
			current = current.rightChild;
		}
		return current;
	}
}




























