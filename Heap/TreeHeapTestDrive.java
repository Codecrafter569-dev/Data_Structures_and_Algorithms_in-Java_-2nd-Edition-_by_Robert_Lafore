import java.io.*;

public class TreeHeapTestDrive{

public static void main(String args[]){
TreeHeap th = new TreeHeap();
        th.insert(20);
        th.insert(5);
        th.insert(15);
        th.insert(30);
        th.insert(10);
        System.out.print("After inserts:     ");
        th.printLevelOrder();  // should show 30 at root

        System.out.println("peekMax(): " + th.peekMax());

        int max = th.removeMax();
        System.out.println("removeMax(): " + max);
        System.out.print("After removeMax:   ");
        th.printLevelOrder();

        // Change a node's key: find some node, e.g., at idx=4
        // (for demo we reach it via getNode; in real use you might keep references)
        Node node4 = th.getNode(4);
        System.out.println("Changing idx=4 key from " + node4.key + " to 50");
        th.changeKey(node4, 50);
        System.out.print("After changeKey:   ");
        th.printLevelOrder();
}
}
    class Node{
		int key;
		Node left, right , parent;
		
		Node(int key , Node parent){
			this.key = key;
			this.parent = parent;
		}
	}
class TreeHeap{
	private Node root;
	private int size;
	
	public TreeHeap(){
		root = null;
		size = 0;
	}
	
	public void insert(int key){
		size++;
		if(root == null){
			root = new Node(key,null);
			return;
		}
		Node parent = getNode((size)>>>1);
		Node node  = new Node(key, parent);
		if((size & 1) ==0){
			parent.left = node;
		}else{
			parent.right = node;
		}
		bubbleUP(node);
	}
	public int removeMax(){
		if(root == null){
			throw new IllegalStateException("Heap is Empty");
		}
		int max = root.key;
		if(size == 1){
			root = null;
			size = 0;
			return max;
		}
		Node last = getNode(size);
		root.key = last.key;
		if(last.parent.left == last){
			last.parent.left = null;
		}else{
			last.parent.right = null;
		}
		size++;
		fixDown(root);
		return max;
		
	}
	public void changeKey(Node node , int newKey){
		int old = node.key;
		node.key = newKey;
		if(newKey > old){
			bubbleUP(node);
		}else{
			fixDown(node);
		}
		
	}
	public void bubbleUP(Node node){
		while(node.parent != null && node.key > node.parent.key){
			int tmp = node.key;
			node.key = node.parent.key;
			node.parent.key = tmp;
			node = node.parent;
		}
		
	}
	public void fixDown(Node node){
		while(node.left != null){
			Node larger = node.left;
			if(node.right != null && node.right.key > node.left.key){
				larger = node.right;
			}
			if(node.key >= larger.key){
				break;
			}
			int tmp = node.key;
			node.key = larger.key;
			larger.key = tmp;
			node = larger;
		}
	}
	public Node getNode(int idx){
		String path = Integer.toBinaryString(idx);
		Node cur = root;
		for(int i = 1;i < path.length();i++){
			if(path.charAt(i) == '0'){
				cur = cur.left;
			}else{
				cur = cur.right;
				
			}
		}
		return cur;
	}
	public int peekMax(){
		if(root == null){
			throw new IllegalStateException("Heap is empty");
		}
		return root.key;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int getSize(){
		return size;
	}
	public void printLevelOrder(){
		if(root == null){
			System.out.println("Empty treeHeap");
			return;
		}
		java.util.Queue<Node> q = new java.util.LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node n = q.poll();
			System.out.print(n.key+" ");
			if(n.left != null){
				q.add(n.left);
			}
			if(n.right != null){
				q.add(n.right);
			}
			
		}
		System.out.println();
	}
}