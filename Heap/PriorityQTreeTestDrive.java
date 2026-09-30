public class PriorityQTreeTestDrive{
public static void main(String args[]){
PriorityQTree heapTree = new PriorityQTree();
heapTree.insert(2);
heapTree.insert(4);
heapTree.insert(6);
heapTree.insert(9);
heapTree.insert(12);
heapTree.insert(10);
heapTree.insert(3);
heapTree.insert(5);
System.out.print("After inserting : ");
heapTree.printInOrder();
System.out.println("\n Removed max : "+heapTree.removeMax());
heapTree.printInOrder();
System.out.print("\n Current max : "+heapTree.peekMax());


}
}
class PriorityQTree{
	private Tree tree;
	
	public PriorityQTree(){
		tree = new Tree();
	}
	public void insert(int value){
		tree.insert(value);
	}
	public int removeMax(){
		return tree.removeMax();
	}
	public int peekMax(){
		return tree.findMax();
	}
	public boolean isEmpty(){
		return tree.isEmpty();
	}
	public void printInOrder(){
		tree.inOrder();
		System.out.println();
	}
}
class Tree{
	private Node root;
	public boolean isEmpty(){
		return root == null;
	}
	public void insert(int key){
		root = insertRec(root,key);
	}
	private Node insertRec(Node node,int key){
		if(node == null){
			return new Node(key);
		}
		if(key < node.key){
			node.left = insertRec(node.left , key);
		}else{
			node.right = insertRec(node.right,key);
		}
		return node;
	}
	public int findMax(){
		if(root == null){
			throw new IllegalStateException("Empty Queue !");
		}
		Node cur = root;
		while(cur.right != null){
			cur = cur.right;
		}
		return cur.key;
	}
	public int removeMax(){
		if(root == null){
			throw new IllegalStateException("Empty Queues ");
		}
		int[] maxHolder = new int[1];
		root = removeMaxRec(root,maxHolder);
		return maxHolder[0];
		
	}
	private Node removeMaxRec(Node node  , int[] maxHolder){
		if(node.right == null){
			maxHolder[0] = node.key;
			return node.left;
		}
		node.right = removeMaxRec(node.right,maxHolder);
		return node;
		
	}
	public void inOrder(){
		inOrderRec(root);
	}
	private void inOrderRec(Node node){
		if(node == null){
			return;
		}
		inOrderRec(node.right);
		System.out.print(node.key+" ");
		inOrderRec(node.left);
	}
	
}
class Node{
	int key;
	Node left, right;
	Node(int k ){
		 key = k;
	}
}