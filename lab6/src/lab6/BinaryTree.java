package lab6;

import java.util.ArrayList;

//tree implementation
public class BinaryTree<Integer>{
	int n=0;
	Node root=null;  
	static class Node<Integer>{
		Integer data;
		Node right;
		Node left;
		public Node(Integer val){
			data=val;
		}
	{
		
	}
  }
	 public ArrayList<Integer> bfsOrder = new ArrayList<Integer>();

  public static void main(String[]args){
	BinaryTree myTree = new BinaryTree();
	Node z = new Node(4);
	Node x = new Node<>(5);
	Node c = new Node(6);
	myTree.root=z;
	myTree.root.left = c;
	myTree.root.right = x;
	myTree.root.right.right=c;
	System.out.println(myTree.numInternal());
  }

  public boolean add(Integer item){
	return true;
  }

  public Integer remove(Integer item){
	return item;
  }

  public boolean find(Integer item){
	return true;
  }

  public Integer getParent(Integer item){
	return item;
  }
  //Jimmys Methods
  public ArrayList<Integer> getAllDescendant (Integer item){
	return new ArrayList<Integer>();
  }

  public Integer getMax() {
	if(root.right==null){
		return (Integer)root.data;
	}
	return getMax(root);
  }
  private Integer getMax(Node root){
	if(root.right==null){
		return (Integer)root.data;
	}
	return getMax(root.right);
  }
  public int getHeight(){
	return 0;
  }

  public int getLevel(Integer item){
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
  
  public void inOrder(Node<Integer> node) {
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
  public void preOrder(Node<Integer> node) {
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
  public void postOrder(Node<Integer> node) {
	  if(node == null) {
		  return;
	  }
	  else {
		  postOrder(node.left);
		  postOrder(node.right);
		  System.out.println(node.data);
	  }
  }
  
  public ArrayList<Integer> bfs(){
	  //Print out tree level by level(top to bottom, left to right)
	  //print root
	  //print root.left and root.right
	  

	  if(root == null) {
		  return null;
	  }
	  else {
		  bfs(bfsOrder, root);
	  }
		return new ArrayList<Integer>();
  }
  
  public ArrayList<Integer> bfs(ArrayList<Integer> bfsOrder, Node<Integer> node){
	  if(node == null) {
		  return null;
	  }
	  else {
		  bfsOrder.add(node.data);
		  bfsOrder.add((Integer) node.left.data);
		  bfsOrder.add((Integer) node.right.data);
		  
			return bfsOrder;

	  }
	  
  }

  //Code by: Thomas Powis
  //Order of N: 
  //Is it recursive?: 
  public boolean isIdentical(Node<Integer> anotherTree){
	return true;
  }
  
  //Code by: Thomas Powis
  //Order of N: O(n) where n is the number of nodes
  //Is it recursive?:  Yes
  public int numLeaves(){
	  return countLeaves(root);
  }
  
  //Helper method for numLeaves
  //This method was adapted from COS 285 Data Structures Lecture 10: Tree Traversals - slide #23
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
  //Order of N: O(n) where n is the number of nodes
  //Is it recursive?: yes
  public int numInternal(){
	return countInternals(root);
  }
  
  //Helper method for numInternal
  //This method was adapted from chatGPT
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


