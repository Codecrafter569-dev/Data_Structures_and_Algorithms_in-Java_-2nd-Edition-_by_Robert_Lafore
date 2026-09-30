import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;


public class SearchingINBinaryTreeV1{
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			 this.data = data;
			 left = right = null;
		}
	}
	Node root;
	
	public Node search(Node root , int key){
		if(root == null){
			return null;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node current = queue.poll();
			if(current.data == key){
				return current;
			}
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right != null){
				queue.add(current.right);
			}
		}
		return null;
		
	}
public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	SearchingINBinaryTreeV1 tree = new SearchingINBinaryTreeV1();
	
tree.root = new Node(1);
tree.root.left = new Node(2);
tree.root.right = new Node(3);
tree.root.left.right = new Node(4);
tree.root.left.left = new Node(5);
tree.root.right.left = new Node(6);
tree.root.right.right = new Node(7);

while(true){

System.out.println("Enter a key value that we want To search in BinaryTree :");
int key = sc.nextInt();
Node found = tree.search(tree.root,key);
if(found != null){
	System.out.println("Found node with Key: "+found.data);
}else{
	System.out.println("Key "+key+" not found in the tree.");
}
}
}
}