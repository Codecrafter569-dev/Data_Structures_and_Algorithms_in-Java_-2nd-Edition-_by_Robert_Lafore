import java.util.LinkedList;
import java.util.Queue;
public class DeleteingInCompleteBinaryTree{
	Node root;
	public DeleteingInCompleteBinaryTree(){
		root = null;
	}
	static class  Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data = data;
		}
		
	}
	public void delete(int key){
		if(root == null){
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		Node nodeToDelete = null;
		Node current = null;
		
		while(!queue.isEmpty()){
			current = queue.poll();
			if(current.data == key){
				nodeToDelete = current;
			}
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right != null){
				queue.add(current.right);
			}
			
		}
		if(nodeToDelete != null){
			nodeToDelete.data = current.data;
			deleteDeepest(current);
		}
	}
	public void deleteDeepest(Node delNode){
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		
		while(!queue.isEmpty()){
			Node current = queue.poll();
			if(current.left != null){
				if(current.left == delNode){
					current.left  = null;
				}else{
					queue.add(current.left);
				}
			}
			if(current.right != null){
				if(current.right == delNode){
					current.right = null;
				}else{
					queue.add(current.right);
				}
				
			}
			
		}
		
	}
	public void inOrder(Node node){
		if(node == null){
			return;
		}
		inOrder(node.left);
		System.out.print(node.data+ " ");
		inOrder(node.right);
	}
	public void levelOrder(Node node){
		if(node == null){
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			Node current = queue.poll();
			System.out.print(current.data+" ");
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right != null){
				queue.add(current.right);
			}
			
		}
		
	}
public static void main(String args[]){
DeleteingInCompleteBinaryTree tree = new DeleteingInCompleteBinaryTree();
tree.root = new Node(1);
tree.root.left = new Node(2);
tree.root.right = new Node(3);
tree.root.left.left = new Node(4);
tree.root.left.right = new Node(5);
tree.root.right.left = new Node(6);
tree.root.right.right = new Node(7);
tree.levelOrder(tree.root);
tree.delete(2);
tree.delete(1);
System.out.println();
tree.levelOrder(tree.root);
}
}