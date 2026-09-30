import java.util.Scanner;
public class SearchingINBinaryTreeV2{
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	Node root;
	public SearchingINBinaryTreeV2(){
		root = null;
	}
	public Node search(Node node , int key){
		if(node == null || node.data == key){
			return node;
		}
		if(key < node.data){
			return search(node.left,key);
		}
		return search(node.right,key);
	}
	public Node searchIterative(Node node , int key){
		while(node != null && node.data != key){
			node = (key < node.data) ? node.left : node.right;
		}
		return node;
	}
	public Node insert(Node node , int key){
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
public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
SearchingINBinaryTreeV2 tree = new SearchingINBinaryTreeV2();
tree.root = tree.insert(tree.root,50);
tree.insert(tree.root,20);
tree.insert(tree.root,100);
tree.insert(tree.root,30);
tree.insert(tree.root,10);
tree.insert(tree.root,40);
tree.insert(tree.root,60);
tree.insert(tree.root,70);
while(true){
	System.out.println("Enter a key value that you want to search in tree : ");
int key = sc.nextInt();
Node found = tree.search(tree.root,key);
if(found != null){
	System.out.println("Found node with key : "+found.data+" using recursive search. ");
}else{
	System.out.println("Key "+key+" not found in the BST(recursive). ");
}
Node foundIterative = tree.searchIterative(tree.root,key);
if(foundIterative != null){
	System.out.println("Found node with key: "+foundIterative.data+" using itrative search.");
}else{
	System.out.println("Key " + key + " not found in the BST (iterative).");
}
}
}
}