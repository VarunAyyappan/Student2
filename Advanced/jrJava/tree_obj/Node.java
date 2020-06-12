package jrJava.tree_obj;

public class Node<E extends Comparable<E>> {

	private E obj;
	private Node<E> left;
	private Node<E> right;
	
	public Node(E obj){
		this.obj = obj;
	}
	
	public E getValue(){ return obj; }
	public Node<E> getLeft(){ return left; }
	public Node<E> getRight(){ return right; }
	
	public void setLeft(Node<E> left){ this.left = left; }
	public void setRight(Node<E> right){ this.right = right; }
	
	public String toString(){
		return obj.toString();
	}
	
}
