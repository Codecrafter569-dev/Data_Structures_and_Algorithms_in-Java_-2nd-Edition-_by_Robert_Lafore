
import java.io.*;
class DataItem{
	public long dData;
	public DataItem(long dd){
		dData = dd;
	}
	public void displayItem(){
		System.out.print("/"+dData);
	}
}
class Node{
	private static final int ORDER = 4;
	private int numItem;
	private Node parant;
	private Node[] childArray = new Node[ORDER];
	private DataItem[] itemArray = new DataItem[ORDER-1];
	
	public void connectChild(int childNum , Node child){
		childArray[childNum] = child;
		if(child != null){
			child.parant = this;
		}
		
	}
	public Node disconnectChild(int childNum){
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}
	public Node getChild(int childNum){
		return childArray[childNum];
	}
	public Node getParant(){
		return parant;
	}
	public boolean isLeaf(){
		return (childArray[0] == null) ? true : false;
	}
	public int getNumItems(){
		return numItem;
	}
	public DataItem getItem(int index){
		return itemArray[index];
	}
	public boolean isFull(){
		return (numItem == ORDER-1) ? true : false;
	}
	public int findItem(long key){
		for(int j=0;j<ORDER-1;j++){
			if(itemArray[j] == null){
				break;
			}else if(itemArray[j].dData == key){
				return j;
			}
		}
		return -1;
	}
	public int insertItem(DataItem newItem){
		numItem++;
		long newKey = newItem.dData;
		for(int j=ORDER-2;j>=0;j--){
			if(itemArray[j] == null){
				continue;
			}else{
				long itsKey = itemArray[j].dData;
				if(newKey < itsKey){
					itemArray[j+1] = itemArray[j];
				}else{
					itemArray[j+1] = newItem;
					return j+1;
				}
				
			}
		}
		itemArray[0] = newItem;
		return 0;
	}
	public DataItem removeItem(){
		DataItem temp = itemArray[numItem-1];
		itemArray[numItem-1] = null;
		numItem--;
		return temp;
		
	}
	public void displayNode(){
		for(int j=0; j<numItem;j++){
			itemArray[j].displayItem();
			
		}
		System.out.println("/");
	}
	
}
class Tree234{
	
	private Node root = new Node();
	public DataItem findMin() {
        if (root == null) throw new IllegalStateException("Tree is empty");

        Node current = root;
        while (!current.isLeaf()) {
            current = current.getChild(0); // always go to the leftmost child
        }

        return current.getItem(0); // leftmost key is the smallest
    }
	public int find(long key){
		Node curNode  = root;
		int childNumber;
		while(true){
		  if((childNumber=curNode.findItem(key)) != -1){			
			return childNumber;
		   }else if(curNode.isLeaf()){
			return -1;
		   }else{
			curNode = getNextChild(curNode,key);
		   }
		}
	}
	public void insert(long dValue){
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		while(true){
			if(curNode.isFull()){
				split(curNode);
				curNode = curNode.getParant();
				curNode = getNextChild(curNode,dValue);
			}else if(curNode.isLeaf()){
				break;
			}else{
				curNode = getNextChild(curNode,dValue);
			}
		}
		curNode.insertItem(tempItem);	
	}
	public void split(Node thisNode){
		DataItem itemB,itemC;
		Node parant,child2,child3;
		int itemIndex;
		itemC = thisNode.removeItem();
		itemB = thisNode.removeItem();
		child2 = thisNode.disconnectChild(2);
		child3 = thisNode.disconnectChild(3);
		Node newRight = new Node();
		
		if(thisNode == root){
			root = new Node();
			parant = root;
			root.connectChild(0,thisNode);
		}else{
			parant = thisNode.getParant();
		}
			itemIndex = parant.insertItem(itemB);
			int n = parant.getNumItems();
			for(int j=n-1;j>itemIndex;j--){
				Node temp = parant.disconnectChild(j);
				parant.connectChild(j+1,temp);
			}
		   parant.connectChild(itemIndex+1,newRight);
		   newRight.insertItem(itemC);
		   newRight.connectChild(0,child2);
		   newRight.connectChild(1,child3);	
	}
	public Node getNextChild(Node theNode,long theValue){
		int j;
		int numItem = theNode.getNumItems();
		for(j=0;j<numItem;j++){
			if(theValue < theNode.getItem(j).dData){
				return theNode.getChild(j);
			}
		}
		return theNode.getChild(j);
	}
	public void displayTree(){
		recDisplayTree(root,0,0);
	}
	private void recDisplayTree(Node thisNode,int level,int childNumber){
		System.out.print("level="+level+" child="+childNumber+" ");
		thisNode.displayNode();
		int numItem = thisNode.getNumItems();
		for(int j=0;j<numItem+1;j++){
			Node nextNode = thisNode.getChild(j);
			if(nextNode != null){
				recDisplayTree(nextNode,level+1,j);
			}else{
				return;
			}
		}
		
	}
	
}
public class Tree234InFindMin{
public static void main(String args[])throws IOException{
long value;;
Tree234 tree = new Tree234();
tree.insert(50);
tree.insert(40);
tree.insert(60);
tree.insert(30);
tree.insert(70);

while(true){
	System.out.print("Enter first letter of  ,show , insert, or find and 'm' for findMin: ");
	char choice = getCar();
	switch(choice){
		case 'm' :
		DataItem item = tree.findMin();
		item.displayItem();
		break;
		case 's':
		tree.displayTree();
		break;
		case 'i':
		System.out.print("Enter value to insert: ");
		value = getInt();
		tree.insert(value);
		break;
		case 'f':
		System.out.print("Enter a value to find: ");
		value = getInt();
		int found = tree.find(value);
		if(found != -1){
			System.out.println("Found "+value);
		}else{
		System.out.println("Could not find "+value);
         		
		}
		break;
		default:
		System.out.print("invalid entry\n");
	}
	
}

}
public static String getString() throws IOException
{
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
String s = br.readLine();
return s;
}
public static int getInt() throws IOException
{
String s = getString();
return Integer.parseInt(s);
}
public static char getCar() throws IOException
{
String s = getString();
return s.charAt(0);
}
}