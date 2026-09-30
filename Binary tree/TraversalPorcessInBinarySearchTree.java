public class TraversalPorcessInBinarySearchTree{
	//
	Node root;
	public TraversalPorcessInBinarySearchTree(){
		root = null;
	}
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	public Node insert(Node node ,int key){
		if(node == null){
			return new Node(key);
		}
		if(key < node.data){
			node.left = insert(node.left,key);
		}else if(key > node.data){
			node.right = insert(node.right,key);
		}
		return node;
	}
	public void insert(int key){
		root = insert(root,key);
	}
	public void inorder(Node node){
		if(node == null){
		return;	
		}
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	public void preOrder(Node node){
		if(node == null){
			return ;
		}
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	public void postOrder(Node node){
		if(node == null){
			return ;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
public static void main(String args[]){
TraversalPorcessInBinarySearchTree bst = new TraversalPorcessInBinarySearchTree();

bst.insert(50);
bst.insert(30);
bst.insert(70);
bst.insert(20);
bst.insert(90);
bst.insert(80);
bst.insert(34);
bst.insert(12);
System.out.println("In-order Traversal of BST: ");
bst.inorder(bst.root);
System.out.println("\nIn-PostOrder Traversal of BST: ");
bst.postOrder(bst.root);
System.out.println("\nIn-preorder Traversal of BST: ");
bst.preOrder(bst.root);

}
}