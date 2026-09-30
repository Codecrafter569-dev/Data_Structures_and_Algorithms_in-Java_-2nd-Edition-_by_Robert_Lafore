import java.util.ArrayList;
import java.util.Scanner;

public class BalancedBinaryTree{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.print("Enter a String of letters (e.g.,ABCDE): ");
String letters = sc.nextLine().trim();

if(letters.length() == 0){
	System.out.println("No input provided.");
	return;
}
ArrayList<Tree> forest = new ArrayList<>();
for(int i = 0;i < letters.length();i++){
	forest.add(new Tree(letters.charAt(i)));
}
while(forest.size() > 1){
	ArrayList<Tree> newForest = new ArrayList<>();
	
	for(int i = 0; i< forest.size();i += 2){
		if(i+1 < forest.size()){
		Tree combinedTree = new Tree('+',forest.get(i),forest.get(i+1));
          newForest.add(combinedTree);		
		}else{
		newForest.add(forest.get(i));
	}
	}
	forest = newForest;
}
Tree balancedTree = forest.get(0);

System.out.println("\nThe balanced binarty tree is:");
balancedTree.displayTree();

System.out.println("\nPre-order traversal:");
balancedTree.preOrder(balancedTree.root);
System.out.println();
}
}
class Node{
	char data;
	Node left,right;
	
	Node(char data){
		this.data = data;
		this.left = this.right = null;
	}
}
class Tree{
	Node root;
	
	public Tree(char data){
		root = new Node(data);
	}
	public Tree(char data , Tree leftTree ,Tree rightTree){
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
		
		for(int i = 0;i < level;i++){
			System.out.print("   ");
		}
		System.out.println(node.data);
		
		displayTree(node.left,level+1);
	}
	public void preOrder(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
}