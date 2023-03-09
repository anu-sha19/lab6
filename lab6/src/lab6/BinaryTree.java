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
  }
 public ArrayList<Integer> bfsOrder = new ArrayList<Integer>();

  public static void main(String[]args){
	 BinaryTree myTree = new BinaryTree();
	 BinaryTree myTree2 = new BinaryTree();
	 myTree.root = new Node(4);
	 myTree2.root = new Node(4);
		
	 System.out.println(myTree.isIdentical(myTree2));
  }

  public boolean add(Integer item) {
      // If the root is null, create a new node with the input item as its data and set it as the root of the tree
      if (root == null) {
          root = new Node<>(item);
          return true;
      } else {
          // If the root is not null, call the addHelper method to recursively add the element to the tree
          return add(item, root);
      }
  }

  
  //Helper method to recursively add a new element to the binary search tree.
   
  private boolean add(Integer item, Node<Integer> node) {
      // If the input item is less than the data in the current node, check if the left child of the current node is null
      int comp = item.compareTo(node.data);
      if (comp < 0) {
          if (node.left == null) {
              // If the left child is null, create a new node with the input item as its data and set it as the left child of the current node
              node.left = new Node<>(item);
              return true;
          } else {
              // If the left child is not null, call the addHelper method with the input item and the left child as parameters
              return add(item, node.left);
          }
      } 
      // If the input item is greater than the data in the current node, check if the right child of the current node is null
      else if (comp > 0) {
          if (node.right == null) {
              // If the right child is null, create a new node with the input item as its data and set it as the right child of the current node
              node.right = new Node<>(item);
              return true;
          } else {
              // If the right child is not null, call the addHelper method with the input item and the right child as parameters
              return add(item, node.right);
          }
      } 
      // If the input item is equal to the data in the current node, return false to indicate that the element already exists in the tree
      else {
          return false;
      }
  }

  public Integer remove(Integer item){
	return item;
  }
public boolean find(Integer item) {
	    // If the tree is empty, the item cannot be found
	    if (root == null) {
	        return false;
	    } 
	    // Call the recursive helper method to traverse the tree and find the item
	    else {
	        return find(item, root);
	    }
	}
	//helper method for find
  private boolean find(Integer item, Node<Integer> node) {
	    // Compare the item with the data at the current node
	    int cmp = item.compareTo(node.data);
	    // If the item is smaller than the data at the current node, search the left subtree
	    if (cmp < 0) {
	        // If the left child is null, the item cannot be found
	        if (node.left == null) {
	            return false;
	        } else {
	            return find(item, node.left);
	        }
	    } 
	    // If the item is larger than the data at the current node, search the right subtree
	    else if (cmp > 0) {
	        // If the right child is null, the item cannot be found
	        if (node.right == null) {
	            return false;
	        } else {
	            return find(item, node.right);
	        }
	    } 
	    // If the item is equal to the data at the current node, the item is found
	    else {
	        return true;
	    }
	}


  public Integer getParent(Integer item){
	 return (Integer) getParent(item, root, null);
  }
//helper method for getParent()
	private Integer getParent(Integer item, Node<Integer> current, Node<Integer> parent) {
      // Base case 1: if the current node is null, the item is not in the tree
      if (current == null) {
          return null;
      }
      
      // Base case 2: if the current node is the root and does not have a parent, the item is the root
      if (current == root && parent == null) {
          return null;
      }
      
      // Recursive case: traverse the left subtree if the item is less than the current node's value, 
      // or the right subtree if it is greater
      int cmp = item.compareTo(current.data);
      if (cmp < 0) {
          return (Integer) getParent(item, current.left, current);
      } else if (cmp > 0) {
          return (Integer) getParent(item, current.right, current);
      } else {
          // Base case 3: if the current node contains the item, return its parent's value
          return parent.data;
      }
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
  //Order of N: O(n) where n is the number of nodes because the worst case scenario has the method visiting each node to make sure the two trees are identical
  //Is it recursive?: Yes
  public boolean isIdentical(BinaryTree anotherTree){
	return areIdenticalTrees(this.root, anotherTree.root);
  }
  
  //This code was partially adapted from chatGPT
  public static boolean areIdenticalTrees(Node root1, Node root2) {  
	  
      //Checks if both the trees are empty  
      if(root1 == null && root2 == null)  
          return true;  

     
      //If both trees are not empty, check whether the data of the nodes is equal 
      if(root1 != null  && root2 != null) {  

    	  //Repeat using recursion
          return ((root1.data == root2.data) &&  
                  (areIdenticalTrees(root1.left, root2.left)) &&  
                  (areIdenticalTrees(root1.right, root2.right)));  
      }  
      return false;  
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


