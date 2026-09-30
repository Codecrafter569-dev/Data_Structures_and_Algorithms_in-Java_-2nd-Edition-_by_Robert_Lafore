public class Tree2_3_TestDrive{
public static void main(String args[]){
Tree2_3 tree = new Tree2_3();
int[] values = {50,40,60,30,20,10,80,90,25};

for(int val : values){
	System.out.println("Insertin "+val);
	tree.insert(val);
	tree.displayTree();
	System.out.println();
}
System.out.println("Search 50: "+tree.search(50));
System.out.println("Search 100: "+tree.search(100));
}
}
class Node {
	static final int MAX_KEYS = 2;
	int numKeys = 0;
	int[] keys = new int[MAX_KEYS+1];
	Node[] children = new Node[MAX_KEYS+2];
	Node parent;
	
	public boolean isLeaf(){
		return children[0] == null;
	}
	public boolean isOverflow(){
		return numKeys > MAX_KEYS;
	}
	public void insertKey(int key){
		numKeys++;
		int i = numKeys-1;
		while(i > 0 && keys[i-1] > key){
			keys[i] = keys[i-1];
			i--;
		}
		keys[i] = key;
	}
	public int findChildIndex(int key){
		int i = 0;
		while(i < numKeys && key > keys[i]){
			i++;
		}
		return i;
		
	}
	public void connectChild(int idx,Node child){
		children[idx] = child;
		if(child != null){
			child.parent = this;
		}
		
	}
	
}
class Tree2_3{
	private Node root = new Node();
	
	public void insert(int key){
		Node leaf = findLeaf(root,key);
		leaf.insertKey(key);
		if(leaf.isOverflow()){
			split(leaf);
		}
	}
	private Node findLeaf(Node node , int key){
		Node current = node;
		while(!current.isLeaf()){
			int idx = current.findChildIndex(key);
			current = current.children[idx];
			
		}
		return current;
		
	}
	private void split(Node node){
		int mid = node.numKeys / 2;
		int promoteKey = node.keys[mid];
		
		Node leaf = new Node();
		Node right = new Node();
		for(int i = 0; i <mid; i++){
			leaf.insertKey(node.keys[i]);
		}
		for(int i = mid+1; i <= node.numKeys;i++){
			right.insertKey(node.keys[i]);
		}
		if(!node.isLeaf()){
			for(int i = 0; i <= leaf.numKeys; i++){
				leaf.connectChild(i,node.children[i]);
			}
			for(int i = 0 ; i <= right.numKeys;i++){
				right.connectChild(i,node.children[mid+1+i]);
			}
			
		}
		Node parent = node.parent;
		if(parent == null){
			root = new Node();
			root.insertKey(promoteKey);
			root.connectChild(0,leaf);
			root.connectChild(1,right);
		}else{
			int idx = 0;
			while(parent.children[idx] != node){
				idx++;
			}
			for(int i = parent.numKeys +1;i > idx+1;i--){
				parent.children[i] = parent.children[i-1];
			}
			parent.connectChild(idx,leaf);
			parent.connectChild(idx+1,right);
			parent.insertKey(promoteKey);
			
		}
		if(parent != null && parent.isOverflow()){
			split(parent);
			
		}
	}
	public boolean search(int key){
		Node current = root;
		while(current != null){
			int i = 0;
			while(i < current.numKeys && key > current.keys[i]){
				i++;
			}
			if(i < current.numKeys && key == current.keys[i]){
				return true;
			}
			current = current.children[i];
		}
		return false;
	}
	public void displayTree(){
		recDisplay(root,0,0);
	}
	private void recDisplay(Node node, int level,int childNum){
		System.out.print("Level="+level+" Child="+childNum+" ");
		for(int i = 0; i < node.numKeys;i++){
			System.out.print("/"+node.keys[i]);
		}
		System.out.println();
		for(int i = 0; i <= node.numKeys;i++){
			if(node.children[i] != null){
				recDisplay(node.children[i],level+1,i);
			}
		}
	}
	
}