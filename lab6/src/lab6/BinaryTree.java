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
	Node<Integer> x = new Node<Integer>(5);
	Node<Integer> c = new Node<Integer>(5);
	myTree.root=z;
	myTree.root.right = x;
	myTree.root.left = c;
	System.out.println(myTree.root.data);
	System.out.println(myTree.numLeaves());
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

  //Code by: Thomas Powis
  //Order of N: 
  //Is it recursive?: 
  public boolean isIdentical(Node<E> anotherTree){
	return true;
  }
  
  //Code by: Thomas Powis
  //Order of N: 
  //Is it recursive?: 
  public int numLeaves(){
	  return countLeaves(root);
  }
  
  //Helper method for numLeaves
  private static int countLeaves(Node node) {
  if(node == null) {
		return 0;
	}
	if(node.left == null && node.right == null) {
		return 1;
	} else
	  return countLeaves(node.left) + countLeaves(node.right);
	}
  //Code by: Thomas Powis
  //Order of N: 
  //Is it recursive?: 
  public int numInternal(){
	return 0;
  }
  
  //Code by: Thomas Powis
  //Order of N: 
  //Is it recursive?: 
  public void clear(){
  }

}


