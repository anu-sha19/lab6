package lab6;

import java.util.ArrayList;
import java.math.*;
import java.lang.Integer;

//tree implementation
public class BinaryTree{
	int n=0;
	Node root=null;  
	static class Node{
		int  data;
		Node right;
		Node left;
		public Node(int val){
			data=val;
		}
  }
 public ArrayList<Integer> bfsOrder = new ArrayList<Integer>();
 //test
  public static void main(String[]args){
	 BinaryTree myTree = new BinaryTree();
	 int[] list ={72, 10, 25, 63, 91, 4, 85, 50, 13, 44, 57, 88, 97, 39, 78, 30, 21, 48, 65, 99, 60, 76, 33, 55, 82};
	 for(int i=0;i<list.length;i++){
		myTree.add(list[i]);
	 }
	 //lets put our tests here! use sout() to print
	 sout("Jimmys tests");
	 sout("Get the trees height");
	 sout(myTree.getHeight());
	 sout("Get the trees largest value");
	 sout(myTree.getMax());
	 sout("getLevel of 99");
	 sout(myTree.getLevel(99));
	 sout("getAllDescendant of 25");
	 sout(myTree.getAllDescendant(25	));
	 /* 
	 sout("Pre Order");
	 myTree.preOrder();
	 sout("Post Order");
	 myTree.postOrder();
	 sout("In Order");
	 myTree.inOrder();
	 */
	  sout("\n" +"Anusha's tests");
		// Testing the remove() method
		sout("\n" +"Testing remove() method");
		int removed = myTree.remove(4);
		sout("Removed " + removed + " from the tree");
		
		// Testing the find() method
		System.out.println("\n" +"Testing find() method");
		boolean found = myTree.find(4);
		sout("Found 4 in the tree? " + found);
		sout("Found 50 in the tree? " + myTree.find(50));

		// Testing the getParent() method
		sout("\n" +"Testing getParent() method");
		int parent = myTree.getParent(10);
		sout("Parent of 10: " + parent);
		
	//Testing Tom Powis's Methods
	sout("\nTom's Method Tests:");
	sout("\nTesting isIdentical() method");
	BinaryTree myTree2 = myTree;
	//Should be true
	sout(myTree.isIdentical(myTree2));
	//Should be false
	BinaryTree myTree3 = new BinaryTree();
	myTree3.add(5);
	sout(myTree.isIdentical(myTree3));
	sout("\nTesting numLeaves");
	sout(myTree.numLeaves());
	sout(myTree2.numLeaves());
	sout(myTree3.numLeaves());
	sout("\nTesting numInternal");
	sout(myTree.numInternal());
	sout(myTree2.numInternal());
	sout(myTree3.numInternal());
	sout("\nTesting clear");
	myTree.clear();
	sout("Internal nodes after clear: " +myTree.numInternal());
	sout("Leaves after clear: " + myTree.numLeaves());
	
  }
  //ANusha's methods 
  public boolean add(int item) {
      // If the root is null, create a new node with the input item as its data and set it as the root of the tree
      if (root == null) {
          root = new Node(item);
          return true;
      } else {
          // If the root is not null, call the addHelper method to recursively add the element to the tree
          return add(item, root);
      }
  }

  
  //Helper method to recursively add a new element to the binary search tree. 
  public static void sout(Object o){
	System.out.println(o);
  }
  private boolean add(int item, Node node) {
      // If the input item is less than the data in the current node, check if the left child of the current node is null
      if (item<node.data) {
          if (node.left == null) {
              // If the left child is null, create a new node with the input item as its data and set it as the left child of the current node
              node.left = new Node(item);
              return true;
          } else {
              // If the left child is not null, call the addHelper method with the input item and the left child as parameters
              return add(item, node.left);
          }
      } 
      // If the input item is greater than the data in the current node, check if the right child of the current node is null
      else if (item>node.data) {
          if (node.right == null) {
              // If the right child is null, create a new node with the input item as its data and set it as the right child of the current node
              node.right = new Node(item);
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

	public int remove(int item){
		if (root == null) {
	        return -1; // empty tree
	    } else {
	        Node parent = null;
	        return remove(item, root, parent);
	    }
	
  }
	//helper method for remove 
	private int remove(int item, Node node, Node parent) {
			if (node == null) {
				return -1; // item not found
			} 
			else if (item<node.data) {
				// search in the left subtree
				return remove(item, node.left, node);
			} else if (item>node.data) {
				// search in the right subtree
				return remove(item, node.right, node);
			} else {
				// item found, remove the node
				int removedItem = node.data;
				if (node.left == null && node.right == null) {
					// case 1: node has no children
					if (parent == null) {
						root = null; // node is the root of the tree
					} else if (parent.left == node) {
						parent.left = null; // node is the left child of its parent
					} else {
						parent.right = null; // node is the right child of its parent
					}
				} else if (node.left == null) {
					// case 2: node has one right child
					if (parent == null) {
						root = node.right; // node is the root of the tree
					} else if (parent.left == node) {
						parent.left = node.right; // node is the left child of its parent
					} else {
						parent.right = node.right; // node is the right child of its parent
					}
				} else if (node.right == null) {
					// case 2: node has one left child
					if (parent == null) {
						root = node.left; // node is the root of the tree
					} else if (parent.left == node) {
						parent.left = node.left; // node is the left child of its parent
					} else {
						parent.right = node.left; // node is the right child of its parent
					}
				} else {
					// case 3: node has two children
					// find the successor of the node
					Node successor = node.right;
					Node successorParent = node;
					while (successor.left != null) {
						successorParent = successor;
						successor = successor.left;
					}
					// replace the node's data with the successor's data
					node.data = successor.data;
					// remove the successor node
					if (successorParent.left == successor) {
						successorParent.left = successor.right;
					} else {
						successorParent.right = successor.right;
					}
				}
				return removedItem;
			}
		}
public boolean find(int item) {
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
  private boolean find(int item, Node node) {
	    // Compare the item with the data at the current node

	    // If the item is smaller than the data at the current node, search the left subtree
	    if (item<node.data) {
	        // If the left child is null, the item cannot be found
	        if (node.left == null) {
	            return false;
	        } else {
	            return find(item, node.left);
	        }
	    } 
	    // If the item is larger than the data at the current node, search the right subtree
	    else if (item>node.data) {
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


  public int getParent( int item){
	 return getParent(item, root, null);
  }
//helper method for getParent()
	private int getParent(int item, Node current, Node parent) {
      // Base case 1: if the current node is null, the item is not in the tree
      if (current == null) {
	        return -1; // item not found
	    } else if (current.data == item) {
	        if (parent == null) {
	            return -1; // item is root node
	        } else {
	            return parent.data;
	        }
	    } else if (item < current.data) {
	        return getParent(item, current.left, current);
	    } else {
	        return getParent(item, current.right, current);
	    }
  }
//End of Anusha's methods

//Jimmys Methods
  public ArrayList<Integer> getAllDescendant (int item){
	ArrayList<Integer> descendants =new ArrayList<>();
    findNodeForgetAllDescendantsHelper(root,item,descendants);
	descendants.remove(0);
    return descendants;
  }
  
  private void findNodeForgetAllDescendantsHelper(Node current, int item,ArrayList<Integer> descendants) {
	if(current.data<item){
		findNodeForgetAllDescendantsHelper(current.right,item, descendants);
	}
	else if(current.data>item){
		findNodeForgetAllDescendantsHelper(current.left,item, descendants);
	}
	else{
	 getAllDescendantsHelper(current, descendants);
	}
 }

private void getAllDescendantsHelper(Node current,ArrayList<Integer> descendants) {
    if (current == null) {
        return;
    } 
		descendants.add(current.data);
 	    getAllDescendantsHelper(current.left,descendants);
        getAllDescendantsHelper(current.right,descendants);


    
}
/*
* Written by Jimmy Gore
 This method just keeps going right*/ 
  public int getMax() {
	if(root.right==null){
		return root.data;
	}
	return getMax(root);
  }
  private int getMax(Node root){
	if(root.right==null){
		return root.data;
	}
	return getMax(root.right);
  }
  /*
   * 
   written by jimmy gore*/
  public int getHeight(){
	return getHeight(root);
  }
  // I used adapted the code from the slides for this one
  private int getHeight( Node node){
	if(node==null){
		return -1;
	}
	return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
  }

  public int getLevel(int item){
	return getLevel(root, item, 1);
  }
  private int getLevel(Node root, int item,int level){
	if(root==null){
		return -1;
	}
	if(root.data<item){
		return getLevel(root.right, item,++level);
	}
	else if(root.data>item){
		return getLevel(root.left, item,++level);
	}
	return level;
  }
  //end of Jimmys methods

//Jonathan's methods 
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
  
  public void inOrder(Node node) {
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
  public void preOrder(Node node) {
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
  public void postOrder(Node node) {
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
  
  public ArrayList<Integer> bfs(ArrayList<Integer> bfsOrder, Node node){
	  if(node == null) {
		  return null;
	  }
	  else {
		/* 
		  bfsOrder.add(node.data);
		  bfsOrder.add(node.left.data);
		  bfsOrder.add(node.right.data);
		  */
			return bfsOrder;

	  }
	  
  }
//End of Jonathan's methods

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
