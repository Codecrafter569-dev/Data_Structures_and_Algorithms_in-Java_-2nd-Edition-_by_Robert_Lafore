import java.util.Scanner;
public class HoldingOneLatterPulls{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.print("Enter a string of letter (e.g ABCDE): ");
String letters = sc.nextLine().trim();

if(letters.length() == 0){
	System.out.println("NO input provided.");
	return;
}
int n = letters.length();
Tree[] forest = new Tree[n];
for(int i = 0;i < n;i++){
	char ch = letters.charAt(i);
	forest[i] = new Tree(ch);
}
Tree combinedTree = forest[0];
for(int i = 1;i < n;i++){
	combinedTree = new Tree('+',combinedTree,forest[i]);
}
System.out.println("\nThe combined binary tree is: ");
combinedTree.displayTree();

System.out.print("\nPre-oreder Traversal: ");
combinedTree.preOrder(combinedTree.root);
System.out.println();
}
}
class Node{
	char data;
	Node left, right;
	
	 Node(char data){
		this.data = data;
		left  = right = null;
	}
}
class Tree{
	Node root;
	
	public Tree(char data){
		root = new Node(data);
	}
	public Tree(char data, Tree leftTree,Tree rightTree){
		root = new Node(data);
		root.left = leftTree.root;
		root.right = rightTree.root;
	}
	public void displayTree(){
		displayTree(root,0);
	}
	private void displayTree(Node node , int level){
		if(node == null){
			return;
		}
		displayTree(node.right,level+1);
		
		for(int i =0;i < level ;i++){
			System.out.print("   ");
		}
		System.out.println(node.data);
		
		displayTree(node.left,level+1);
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