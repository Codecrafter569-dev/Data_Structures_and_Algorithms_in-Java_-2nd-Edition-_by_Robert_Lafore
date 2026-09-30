import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class TreeWithTop_Down{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.print("Enter a String of letters (e.g.,ABCDEFGHIJ): ");
String letters = sc.nextLine().trim();

if(letters.isEmpty()){
	System.out.println("No input Provided.");
	return;
}
Tree completeTree = new Tree(letters);

System.out.println("\nThe complete Tree (level order display) is : ");
completeTree.displayLevelOrder();

System.out.println("\nPre-order traversal of the tree: ");
completeTree.preOrder(completeTree.root);
System.out.println();
}
}
class Node{
	char data;
	Node left,right;
	
	public Node(char data){
		this.data = data;
		left = right = null;
	}
	
}
class Tree{
	Node root;
	
	public Tree(String s ){
		root = buildTree(s,0);
	}
	private Node buildTree(String s , int index){
		if(index >= s.length()){
			return null;
		}
		Node node = new Node(s.charAt(index));
		node.left = buildTree(s,2*index+1);
		node.right = buildTree(s,2*index+2);
		return node;
		
	}
	public void displayLevelOrder(){
		if(root == null){
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			int levelSize = queue.size();
			for(int i=0;i <levelSize;i++){
				Node current = queue.poll();
				System.out.print(current.data+" ");
				
				if(current.left != null){
					queue.add(current.left);
				}
				if(current.right != null){
					queue.add(current.right);
				}
				
			}
			System.out.println();
		}
	}
	public void preOrder(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data+ " ");
		preOrder(node.left);
		preOrder(node.right);
	}
}