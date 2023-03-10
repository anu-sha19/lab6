//Binary Tree implementation 
This is a Java implementation of a Binary Tree, with several methods for adding, removing, finding, and manipulating the tree.

These are the Basic methods 
1. add(E item) boolean
Order: O(n)or O(logn) depending if the tree is skewed(each node having only one child which is the worst case) or balanced(best case)
2. remove(E item) E
Order: Best case would be a constant time:O(1)-if the node to be removed is root with no child or leaf-...In worst case O(n) if the method needs to traverse all the levels to find the node
3. find (E item) boolean
Order: When the tree is balanced, only subset of the nodes would be visited so that would make the best case O(logn), but when parents have only one child, order will be O(n)
4. getParent(E item): E
Order: In the worst case, we will have to traverse the entire tree so the order will be O(n)where n is the height of the tree, in the best case, when we are looking for the root, the order is O(1)

5. ArrayList<E> getAllDescendant (E item)
I may be wrong but I believe this is O(NlogN). This is because this method is composed of a search and a traversal. Log(n) to find and then O(N) to add the subtree at the find. Worst case is that the item is the root and then its O(N)
6.getMax(E)
This is O(logN) because it goes right every time. Worst case is that its a right sided chain then its O(n)

7.int getHeight()
This is O(N) as it must traverse down every tree. Worst case doesnt exist due to the nature of the function

8.int getLevel()
 This is O(logN) because its basically a search with a integer being incremented.
 
//Additional Methods
5. getAllDescendant (E item): ArrayList<E>
6. getMax(): E
7. getHeight(): int
8. getLevel(E item): int
9. inOrder(): void
10. preOrder(): void
11. postOrder(): void
12. bfs(): ArrayList<E>
13. isIdentical(Node<E> anotherTree)
Order is O(N) where N is the number of nodes. This is because the worst case scenario will require the method to visit each node to check if the two trees are identical.
14. numLeaves(): int
Order is O(N) where N is the number of nodes. This is because the method will need to visit each node to count the number of leaves.
15. numInternal(): int
Order is O(N) where N is the number of nodes. This is because the method will need to visit each node to count the number of internal nodes.
16. clear(): void
Order is O(1) this is because this method will need two steps regardless of the size of the tree, those two steps being setting the root to null and setting the number of nodes (n) to zero.

Contributers Methods 
Anusha       (1-4)
Jimmy        (5-8)
Jonathan     (9-12)
Thomas       (13-16)
