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
	 public ArrayList<E> bfsOrder = new ArrayList<E>();

  public static void main(String[]args){
	BinaryTree myTree = new BinaryTree<Integer>();
	Node<Integer> z = new Node<Integer>(4);
	Node<Integer> x = new Node<Integer>(5);
	Node<Integer> c = new Node<Integer>(6);
	myTree.root=z;
	myTree.root.left = c;
	myTree.root.right = x;
	myTree.root.right.right=c;
	System.out.println(myTree.numInternal());
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
  //Jimmys Methods
  public ArrayList<E> getAllDescendant (E item){
	return new ArrayList<E>();
  }

  public E getMax() {
	if(root.right==null){
		return (E)root.data;
	}
	return getMax(root);
  }
  private E getMax(Node root){
	if(root.right==null){
		return (E)root.data;
	}
	return getMax(root.right);
  }
  public int getHeight(){
	return 0;
  }

  public int getLevel(E item){
	return 0;
  }
  //end of Jimmys methods

  public void inOrder(){
	  //find leftmost local root
	  //print localroot.left
	  //print localroot
	  //print localroot.right
	  if(root == null) {
		  return;
	  }
	  else {
		  inOrder(root);
	  }
  }
  
  public void inOrder(Node<E> node) {
	  if(node == null) {
		  return;
	  }
	  inOrder(node.left);
	  System.out.println(node.data);
	  inOrder(node.right);
  }
  
  public void preOrder(){
	  //print root
	  //print root.left until the left most root
	  //then step up 
	  //then print the right subtree, left always first
	  if(root == null) {
		  return;
	  }
	  else {
		  preOrder(root);
	  }
  }
  public void preOrder(Node<E> node) {
	  if(node == null) {
		  return;
	  }
	  else {
		  System.out.println(node.data);
		  inOrder(node.left);
		  inOrder(node.right);
	  }
  }

  public void postOrder(){
	  //find leftmost local root
	  //print localroot.left
	  //print localroot.right
	  //print localroot
	  if(root == null) {
		  return;
	  }
	  else {
		  postOrder(root);
	  }

  }
  public void postOrder(Node<E> node) {
	  if(node == null) {
		  return;
	  }
	  else {
		  postOrder(node.left);
		  postOrder(node.right);
		  System.out.println(node.data);
	  }
  }
  
  public ArrayList<E> bfs(){
	  //Print out tree level by level(top to bottom, left to right)
	  //print root
	  //print root.left and root.right
	  

	  if(root == null) {
		  return null;
	  }
	  else {
		  bfs(bfsOrder, root);
	  }
		return new ArrayList<E>();
  }
  
  public ArrayList<E> bfs(ArrayList<E> bfsOrder, Node<E> node){
	  if(node == null) {
		  return null;
	  }
	  else {
		  bfsOrder.add(node.data);
		  bfsOrder.add((E) node.left.data);
		  bfsOrder.add((E) node.right.data);
		  
			return bfsOrder;

	  }
	  
  }

  //Code by: Thomas Powis
  //Order of N: 
  //Is it recursive?: 
  public boolean isIdentical(Node<E> anotherTree){
	return true;
  }
  
  //Code by: Thomas Powis
  //Order of N: 
  //Is it recursive?:  Yes
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
  //Is it recursive?: yes
  public int numInternal(){
	return countInternals(root);
  }
  
  //Helper method for numInternal
  private static int countInternals(Node node) {
	  if (node == null || (node.left == null && node.right == null)) {
	        return 0;
	    }
	  return 1 + countInternals(node.left) + countInternals(node.right);
  }
  
  //Code by: Thomas Powis
  //Order of N: O(1) 
  //Is it recursive?: No
  public void clear(){
	  //Set the root to null
	  root = null;
	  //Set the node count (n) to 0, making the tree empty
	  n = 0;
  }
}


