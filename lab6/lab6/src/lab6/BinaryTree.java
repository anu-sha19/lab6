package lab6;
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

  public void remove(E item){
	return true;
  }
  public boolean find(E item){
	return true;
  }

}


