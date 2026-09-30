class Node{
	int key;
	Object value;
	Node left;
	Node right;
	
	public Node(int key,Object value){
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		
	}
}
class Tree{
	private Node root;
	
	public Tree(){
		root = null;
	}
	public void insert(int key,Object value){
		if(find(key) != null){
			System.out.println("Duplicate key "+key+", insertion skipped.");
			return;
			
		}
		root = insertRec(root,key,value);
	}
	private Node insertRec(Node root,int key,Object value){
		if(root == null){
			return new Node(key,value);
		}
		if(key < root.key){
			root.left = insertRec(root.left,key,value);
		}else if(key > root.key){
			root.right = insertRec(root.right,key,value);
		}
		return root;
	}
	public Object find(int key){
		Node current = root;
		while(current != null){
			if(key == current.key){
				return current.value;
			}else if(key < current.key){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return null;
	}
	public void inOrder(){
		inOrderRec(root);
	}
	private void inOrderRec(Node root){
		if(root != null){
			inOrderRec(root.left);
			System.out.print(root.key+" ");
			inOrderRec(root.right);
		}
	}
}
class HashTableWithTree{
	private Tree[] hashArray;
	private int arraySize;
	
	public HashTableWithTree(int size){
		arraySize = size;
		hashArray = new Tree[size];
		for(int i = 0; i<size; i++){
			hashArray[i] = new Tree();
			
		}
		
	}
	public int hashFunc(int key){
		return key % arraySize;
	}
	public void insert(int key,Object value){
		int hashVal = hashFunc(key);
		hashArray[hashVal].insert(key,value);
	}
	public Object find(int key){
		int hashVal = hashFunc(key);
		return hashArray[hashVal].find(key);
		
	}
	public void displayTable(){
		for(int i= 0;i < arraySize;i++){
			System.out.print(i+". ");
			hashArray[i].inOrder();
			System.out.println();
			
		}
	}
}
public class HashTableWithBST{
public static void main(String args[]){
HashTableWithTree ht = new HashTableWithTree(10);
ht.insert(1,"one");
ht.insert(11,"eleven");
ht.insert(21,"twenty-one");
ht.insert(2,"two");
ht.insert(12,"twelve");
ht.insert(56,"fifty-six");
ht.insert(44,"forty-four");
ht.insert(100,"hundred");
ht.insert(10,"ten");

ht.displayTable();

System.out.println("find 11: "+ht.find(11));
System.out.println("find 3: "+ht.find(3));

ht.insert(11,"eleven again");
ht.displayTable();
}

}