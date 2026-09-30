import java.util.Scanner;
public class SearchingINBinaryTree{
	static class Node{
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	Node root;
	
	public Node search(Node node , int key){
		if(node == null){
			return null;
		}
		if(node.data == key){
			return node;
		}
		Node foundNode = search(node.left , key);
		if(foundNode != null){
			return foundNode;
		}
		return search(node.right,key);
		
	}
public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
SearchingINBinaryTree tree = new SearchingINBinaryTree();

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