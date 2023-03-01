package lab6;

import java.util.ArrayList;

//tree implementation
public class BinaryTree<E>{
	int n=0;
	Node root=null;  
	static class Node<E>{
		E data;
		Node right;
		Node left;
		public Node(E val){
			data=val;
		}
	{
		
	}
  }
  public static void main(String[]args){
	BinaryTree myTree = new BinaryTree<Integer>();
	Node<Integer> z = new Node<Integer>(4);
	myTree.root=z;
	System.out.println(myTree.root.data);
  }

  public boolean add(E item){
	return true;
  }

  public E remove(E item){
	return item;
  }

  public boolean find(E item){
	return true;
  }

  public E getParent(E item){
	return item;
  }

  public ArrayList<E> getAllDescendant (E item){
	return new ArrayList<E>();
  }

  public E getMax() {
	E item =null;
	return item;
  }

  public int getHeight(){
	return 0;
  }

  public int getLevel(E item){
	return 0;
  }

  public void inOrder(){

  }

  public void preOrder(){

  }

  public void postOrder(){

  }
  public ArrayList<E> bfs(){
	return new ArrayList<E>();
  }

  public boolean isIdentical(Node<E> anotherTree){
	return true;
  }

  public int numLeaves(){
	return 0;
  }

  public int numInternal(){
	return 0;
  }
  
  public void clear(){

  }

}


