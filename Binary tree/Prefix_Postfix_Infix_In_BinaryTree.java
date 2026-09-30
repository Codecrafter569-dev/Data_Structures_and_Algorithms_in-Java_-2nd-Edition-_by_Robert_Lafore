import java.util.Scanner;
import java.util.Stack;

public class Prefix_Postfix_Infix_In_BinaryTree{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.print("Enter a postfix expression (e.g. ab+c*): ");
String postfix = sc.nextLine().trim();

ExpTree tree = new ExpTree(postfix);
tree.displayExpressions();
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
class ExpTree{
	Node root;
	
	
	public ExpTree(String postfix){
		Stack <ExpTree> stack = new Stack<>();
		for(int i = 0; i < postfix.length();i++){
			char ch = postfix.charAt(i);
			if(Character.isWhitespace(ch)){
				continue;
			}
			ExpTree tree = new ExpTree(ch);
			if(isOperator(ch)){
				tree.root.right = stack.pop().root;
				tree.root.left = stack.pop().root;
				
			}
			stack.push(tree);
		}
		this.root = stack.pop().root;
	}
	private ExpTree(char data){
		root = new Node(data);
	}
	private boolean isOperator(char ch){
		return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
	}
	public void preOrder(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	public void inOrder(Node node){
		if(node == null){
			return;
		}
		if(isOperator(node.data)){
			System.out.print("(");
			
		}
		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
		if(isOperator(node.data)){
			System.out.print(")");
		}
	}

public void postOrder(Node node){
	if(node == null){
		return;
	}
	postOrder(node.left);
	postOrder(node.right);
	System.out.print(node.data);
}
public void displayExpressions(){
	System.out.print("Prefix expression: ");
	preOrder(root);
	System.out.println();
	
	System.out.print("InOrder expression: ");
	inOrder(root);
	System.out.println();
	
	System.out.print("PostOrder expression: ");
	postOrder(root);
	System.out.println();
	
}

}