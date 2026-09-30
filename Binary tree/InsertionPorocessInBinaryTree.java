import java.util.LinkedList;
import java.util.Queue;
public class InsertionPorocessInBinaryTree{
	Node root;
	//The completeBinaryTree in Insertion Porocess.
public static void main(String args[]){
InsertionPorocessInBinaryTree tree = new InsertionPorocessInBinaryTree();
tree.insert(1);
tree.insert(2);
tree.insert(3);
tree.insert(4);
tree.insert(5);

System.out.println("Level Order Traversal after insertinos.:");
tree.printLevelOrder();
}
static class Node{
	int data;
	Node left,right;
	
	Node(int data){
		this.data = data;
		left = right = null;
	}
	
}
public InsertionPorocessInBinaryTree(){
	root = null;
}
public void insert(int key){
	Node newNode = new Node(key);
	
	if(root == null){
		root = newNode;
		return;
	}
	Queue<Node> queue = new LinkedList<>();
	queue.add(root);
	
	while(!queue.isEmpty()){
		Node current = queue.poll();
		
		if(current.left == null){
			current.left = newNode;
			return;
		}else{
			queue.add(current.left);
		}
		if(current.right == null){
			current.right = newNode;
			return;
		}else{
			queue.add(current.right);
		}
	}
}
public void printLevelOrder(){
	if(root == null){
		return;
	}
	Queue<Node> queue = new LinkedList<>();
	queue.add(root);
	
	while(!queue.isEmpty()){
		Node temp = queue.poll();
		System.out.print(temp.data+" ");
		
		if(temp.left != null){
			queue.add(temp.left);
		}if(temp.right != null){
			queue.add(temp.right);
		}
	}
}
}