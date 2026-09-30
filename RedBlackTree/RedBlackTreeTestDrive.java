public class RedBlackTreeTestDrive{
private static final boolean RED = true;
private static final boolean BLACK = false;

private class Node{
	int data ;
	Node parent;
	Node left;
	Node right;
	boolean color;
	
	 Node(){
		
	}
	Node(int data){
		this.data = data;
	}
}
private final Node NIL = new Node();
private Node root = NIL;
public RedBlackTreeTestDrive(){
	NIL.color = BLACK;
	NIL.left = NIL;
	NIL.right = NIL;
	NIL.parent = NIL;
	root = NIL;
}
private void leftRotate(Node x){
	Node y = x.right;
	x.right = y.left;
	if(y.left != NIL){
		y.left.parent = x;
	}
	y.parent = x.parent;
	if(x.parent == NIL){
		root = y;
	}else if(x == x.parent.left){
		x.parent.left = y;
	}else{
		x.parent.right = y;
	}
	y.left = x;
	x.parent = y;
	
}
private void rightRotate(Node x){
	Node y = x.left;
	x.left = y.right;
	if(y.right != NIL){
		y.right.parent = x;
	}
	y.parent = x.parent;
	if(x.parent == NIL){
		root = y;
	}else if(x == x.parent.right){
		x.parent.right = y;
	}else{
		x.parent.left = y;
	}
	y.right = x;
	x.parent = y;
}
public void insert(int key){
	Node node = new Node(key);
	node.parent = NIL;
	node.left = NIL;
	node.right = NIL;
	node.color = RED;
	
	
	Node y = NIL;
	Node x = root;
	while(x != NIL){
		y = x;
		if(node.data < x.data){
			x = x.left;
		}else{
			x = x.right;
		}
	}
	node.parent = y;
	if(y == NIL){
		root = node;
	}else if(node.data < y.data){
		y.left = node;
	}else{
		y.right = node;
	}
	insertFixup(node);
}
private void insertFixup(Node z){
	
	while(z.parent.color == RED){
		if(z.parent == z.parent.parent.left){
			Node y = z.parent.parent.right;
			if(y.color == RED){
				z.parent.color = BLACK;
				y.color = BLACK;
				z.parent.parent.color = RED;
				z = z.parent.parent;
			}else{
				if(z == z.parent.right){
					z = z.parent;
					leftRotate(z);
				}
				z.parent.color = BLACK;
				z.parent.parent.color = RED;
				rightRotate(z.parent.parent);
			}
		}else{
			Node y = z.parent.parent.left;
			if(y.color == RED){
				z.parent.color = BLACK;
				y.color = BLACK;
				z.parent.parent.color = RED;
				z = z.parent.parent;
			}else{
				if(z == z.parent.left){
					z = z.parent;
					rightRotate(z);
				}
				z.parent.color = BLACK;
				z.parent.parent.color = RED;
				leftRotate(z.parent.parent);
				
			}
			
		}
	}
	root.color = BLACK;
}
private void transplant(Node u,Node v){
	if(u.parent == NIL){
		root = v;
	}else if(u == u.parent.left){
		u.parent.left = v;
	}else{
		u.parent.right = v;
	}
	v.parent = u.parent;
	
}
public void delete(int key){
	Node z = searchTreeHelper(root,key);
	if(z == NIL){
		return;
	}
	Node y = z;
	boolean yOriginalColor = y.color;
	Node x;
	if(z.left == NIL){	
	  x = z.right;
      transplant(z,z.right);	
	}else if(z.right == NIL){
		x = z.left;
		transplant(z,z.left);
	}else{
		y = minimum(z.right);
		yOriginalColor = y.color;
		x = y.right;
		if(y.parent == z){
			x.parent = y;
		}else{
			transplant(y,y.right);
			y.right = z.right;
			y.right.parent = y;
			
		}
		transplant(z,y);
		y.left = z.left;
		y.left.parent = y;
		y.color = z.color;
		
	}
	if(yOriginalColor == BLACK){
			deleteFixup(x);
		}
	
}
private void deleteFixup(Node x){
	while(x != root && x.color == BLACK){
		if(x == x.parent.left){
			Node w = x.parent.right;
			if(w.color == RED){
				w.color = BLACK;
				x.parent.color = RED;
				leftRotate(x.parent);
				w = x.parent.right;
			}
			if(w.left.color == BLACK && w.right.color == BLACK){
				w.color = RED;
				x = x.parent;
			}else{
				if(w.right.color == BLACK){
					w.right.color = BLACK;
					w.color = RED;
					rightRotate(w);
					w = x.parent.right;
				}
				w.color = x.parent.color;
			     x.parent.color = BLACK;
				 w.right.color = BLACK;
				 leftRotate(x.parent);
				 x = root;
			}
		}else{
			Node w = x.parent.left;
			if(w.color == RED){
				w.color = BLACK;
				x.parent.color = RED;
				rightRotate(x.parent);
				w = x.parent.left;
			}
			if(w.left.color == BLACK && w.right.color == BLACK){
				w.color = RED;
				x = x.parent;
			}else{
				if(w.left.color == BLACK){
					w.right.color = BLACK;
					w.color = RED;
					leftRotate(w);
					w = x.parent.left;
				}
				w.color = x.parent.color;
				x.parent.color = BLACK;
				w.left.color = BLACK;
				rightRotate(x.parent);
				x  = root;
			}
		}
		
	}
	x.color = BLACK;
}
public boolean search(int key){
return searchTreeHelper(root,key) != NIL;	
	
}
private Node searchTreeHelper(Node node,int key){
if(node == NIL || key == node.data){
return node;
}	
if(key < node.data){
return searchTreeHelper(node.left,key);
}
return searchTreeHelper(node.right,key);	
}
public Node minimum(Node node){
	while(node.left != NIL){
		node = node.left;
	}
	return node;
	
}
public Node maximum(Node node){
	while(node.right != NIL){
		node = node.right;
	}
	return node;
}
public Node successor(Node x){
	if(x.right != NIL){
		return minimum(x.right);
	}
	Node y = x.parent;
	while(y != NIL && x == y.right){
		x  = y;
		y = y.parent;
	}
	return y;
}
public Node predecessor(Node x){
	if(x.left != NIL){
		return maximum(x.left);
	}
	Node y = x.parent;
	while(y != NIL && x == y.left){
		x = y;
		y = y.parent;
	}
	return y;
}
public void inorder(){
	inorderHelper(root);
	System.out.println();
	
}
private void inorderHelper(Node node){
	if(node != NIL){
		inorderHelper(node.left);
		System.out.print(node.data+" ");
		inorderHelper(node.right);
		
	}
}
public void preOrder(){
	preOrderHelper(root);
	System.out.println();
}
private void preOrderHelper(Node node){
	if(node != NIL){
	      System.out.print(node.data+" ");
             preOrderHelper(node.left);
              preOrderHelper(node.right);			 
	}
	
}
public void postOrder(){
	postOrderHelper(root);
	System.out.println();
}
private void postOrderHelper(Node node){
	if(node != NIL){
		postOrderHelper(node.left);
		postOrderHelper(node.right);
		System.out.print(node.data+" ");
	}
	
}
public static void main(String args[]){
RedBlackTreeTestDrive tree = new RedBlackTreeTestDrive();
int[] values = {20,15,25,10,5,1,30,28,40};
System.out.println("Inserting values:");
for(int v : values){
	System.out.print(v+" ");
	tree.insert(v);
}
System.out.println("\nInorder traversal:");
tree.inorder();
System.out.println("PreOrder traversal : ");
tree.preOrder();
System.out.println("PostOrder traversal :");
tree.postOrder();


int searchKey = 25;
System.out.println("\nSearch "+searchKey+": "+tree.search(searchKey));


System.out.println("\nDeleting 10 and 20");
tree.delete(10);
tree.delete(20);
System.out.println("Inorder after deleteing: ");
tree.inorder();
}

}