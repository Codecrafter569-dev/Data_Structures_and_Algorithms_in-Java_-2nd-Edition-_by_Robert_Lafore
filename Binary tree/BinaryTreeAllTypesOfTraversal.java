import java.util.LinkedList;
import java.util.Queue;
public class BinaryTreeAllTypesOfTraversal{
	Node root;
	public BinaryTreeAllTypesOfTraversal(){
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
	public void preOrder(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	public void inOrder(Node node){
		if(node == null){
			return;
		}
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
		
	}
	public void postOrder(Node node){
		if(node == null){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
		
	}
	public void levelOrder(Node root){
		if(root == null){
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node current = queue.poll();
			System.out.print(current.data+ " ");
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right != null){
				queue.add(current.right);
			}
		}
	}
public static void main(String args[]){
BinaryTreeAllTypesOfTraversal tree = new BinaryTreeAllTypesOfTraversal();
tree.root = new Node(1);
tree.root.left = new Node(2);
tree.root.right = new Node(3);
tree.root.left.left = new Node(4);
tree.root.left.right = new Node(5);
tree.root.right.right = new Node(6);


System.out.println("Pre-order Traversal :");
tree.preOrder(tree.root);
System.out.println("\nPost-order Traversal :");
tree.postOrder(tree.root);
System.out.println("\nIN-order Traversal :");
tree.inOrder(tree.root);
System.out.println("\nLevel-order Traversal :");
tree.levelOrder(tree.root);

}
}