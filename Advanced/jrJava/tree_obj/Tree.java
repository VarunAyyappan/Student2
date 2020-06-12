package jrJava.tree_obj;

import java.util.Stack;

public class Tree<E extends Comparable<E>> {

	private Node<E> root;
	
	public Tree(){
		root = null;
	}
	
	
	public Node<E> find(E obj){
		
		if(root==null) return null;
		
		Node<E> current = root;
		
		while(current.getValue().compareTo(obj)!=0){
			if(obj.compareTo(current.getValue())<0) current = current.getLeft();
			else  current = current.getRight();
			
			if(current==null) return null;
		}
		
		return current;
	}
	
	
	
	public void insert(E obj){
		
		Node<E> node = new Node<E>(obj);
		
		if(root==null){
			root = node;
			return;
		}
		
		Node<E> current = root;
		Node<E> parent; 
		
		while(true){
			
			parent = current;
			if(obj.compareTo(current.getValue())<0){
				current = current.getLeft();
				if(current==null){
					parent.setLeft(node);
					return;
				}
			}
			else {
				current = current.getRight();
				if(current==null){
					parent.setRight(node);
					return;
				}
			}
			
		}
	}
	
	
	public boolean delete(E obj){
		
		if(root==null) return false;
		
		// let's locate the delete-node.
		// maintain the parent and also left/right direction.
		
		Node<E> current = root;
		Node<E> parent = root;
		boolean isLeftChild = false; // is deleteNode its parent's leftChild?
		
		while(current.getValue().compareTo(obj)!=0){
			parent = current;
			if(current.getValue().compareTo(obj)>0){
				current = current.getLeft();
				isLeftChild = true;
			}
			else {
				current = current.getRight();
				isLeftChild = false;
			}
			
			if(current==null) return false;
		}
		
		// Case 1: It has no children.
		if(current.getLeft()==null && current.getRight()==null){
			if(current==root) root = null;
			else if(isLeftChild) parent.setLeft(null);
			else parent.setRight(null);
		}
		
		// Case 2: It has only one child and it is its left child.
		else if(current.getRight()==null){
			if(current==root) root = current.getLeft();
			else if(isLeftChild) parent.setLeft(current.getLeft());
			else parent.setRight(current.getLeft());
		}
		
		// Case 3: It has only one child and it is its right child.
		else if(current.getLeft()==null){
			if(current==root) root = current.getRight();
			else if(isLeftChild) parent.setLeft(current.getRight());
			else parent.setRight(current.getRight());
		}
		
		// Case 4: It has both children.
		else {
			Node<E> successor = getSuccessor(current);
			
			if(current==root) root = successor;
			else if(isLeftChild) parent.setLeft(successor);
			else parent.setRight(successor);
			
			successor.setLeft(current.getLeft());
		}
		
		return true;
	}
	
	
	
	private Node<E> getSuccessor(Node<E> deleteNode){
		Node<E> current = deleteNode.getRight();
		Node<E> successor = deleteNode.getRight();
		Node<E> successorParent = deleteNode.getRight();
		
		while(current!=null){
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		
		if(successor!=deleteNode.getRight()){
			successorParent.setLeft(successor.getRight());
			successor.setRight(deleteNode.getRight());
		}
		
		return successor;
	}
	
	
	public void traverse(){
		traverse(root);
	}
	
	
	private void traverse(Node<E> node){
		if(node==null) return;
		traverse(node.getLeft());
		System.out.println(node);
		traverse(node.getRight());
	}
	
	
	
	public void traverseTopToBottom(){
		Stack<Node<E>> stack = new Stack<Node<E>>();
		stack.push(root);
		int ns = 64;
		boolean isRowEmpty = false;
		
		while(!isRowEmpty){
			
			Stack<Node<E>> eachStack = new Stack<Node<E>>();
			isRowEmpty = true;
			for(int i=0; i<ns; i++) System.out.print(' ');
			
			while(!stack.isEmpty()){
				Node<E> each = stack.pop();
				if(each!=null){
					System.out.print(each);
					eachStack.push(each.getLeft());
					eachStack.push(each.getRight());
					if(each.getLeft()!=null || each.getRight()!=null) isRowEmpty = false;
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
	
	
	
	
	
	public Node<E> minimum(){
		
		if(root==null) return null;
		Node<E> current = root;
		while(current.getLeft()!=null){
			current = current.getLeft();
		}
		return current;
	}
	
	
	public Node<E> maximum(){
		
		if(root==null) return null;
		Node<E> current = root;
		while(current.getRight()!=null){
			current = current.getRight();
		}
		return current;
	}
	
	
}




























