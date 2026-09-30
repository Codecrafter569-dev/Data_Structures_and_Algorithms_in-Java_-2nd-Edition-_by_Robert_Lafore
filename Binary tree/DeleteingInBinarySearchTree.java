public class DeleteingInBinarySearchTree{
	static class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
		
	}
	Node root;
	public DeleteingInBinarySearchTree(){
		root = null;
	}
	public Node delete(Node root, int key){
		if(root == null){
			return null;
		}
		if(key < root.data){
			root.left  = delete(root.left,key);
		}else if(key  > root.data){
			root.right = delete(root.right,key);
			
		}else{
			if(root.left == null){
				return root.right;
			}else if(root.right == null){
				return root.left;
			}
			Node successor = minValueNode(root.right);
		root.data = successor.data;
		root.right = delete(root.right,successor.data);
		}
		return root;
		
	}
	private Node minValueNode(Node node){
		Node current = node;
		while(current.left != null){
			current = current.left;
		}
		return current;
		
	}
	public Node insert(Node root,int key){
		if(root == null){
			root = new Node(key);
		}
		if(key < root.data){
			root.left = insert(root.left,key);
		}else if(key > root.data){
			root.right = insert(root.right , key);
		}
		return root;
	}
	public void inOrder(Node node) {
        if (node == null){
            return;
	    }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
public static void main(String args[]){
DeleteingInBinarySearchTree bst = new DeleteingInBinarySearchTree();
        
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 60);
        bst.insert(bst.root, 80);
        
        System.out.println("In-order traversal before deletion:");
        bst.inOrder(bst.root);  // Should show sorted order.

        // Delete a node with two children.
        bst.root = bst.delete(bst.root, 50);
        bst.root = bst.delete(bst.root,20);
		bst.root = bst.delete(bst.root,80);
        System.out.println("\nIn-order traversal after deletion of 50:");
        bst.inOrder(bst.root);
}
}