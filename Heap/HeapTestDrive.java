import java.io.*;

public class HeapTestDrive{
public static void main(String args[])throws IOException{
int value, value2;
Heap theHeap = new Heap(31); // make a Heap; max size 31
boolean success;
theHeap.insert(70); // insert 10 items
theHeap.insert(40);
theHeap.insert(50);
theHeap.insert(20);
theHeap.insert(60);
theHeap.insert(100);
theHeap.insert(80);
theHeap.insert(30);
theHeap.insert(10);
theHeap.insert(90);
while(true) // until [Ctrl]-[C]
{
System.out.print("Enter first letter of ");
System.out.print("show, insert, remove, change: ");
int choice = getChar();
switch(choice)
{
case 's': // show
theHeap.displayHeap();
break;
case 'i': // insert
System.out.print("Enter value to insert: ");
value = getInt();
success = theHeap.insert(value);
if( !success )
System.out.println("Can’t insert; heap full");
break;
case 'r': // remove
if( !theHeap.isEmpty() )
theHeap.remove();
else
System.out.println("Can’t remove; heap empty");
break;
case 'c': // change
System.out.print("Enter current index of item: ");
value = getInt();
System.out.print("Enter new key: ");
value2 = getInt();
success = theHeap.change(value, value2);
if( !success )
System.out.println("Invalid index");
break;
default:
System.out.println("Invalid entry\n");
} // end switch
}
}
public static String getString() throws IOException
{
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
String s = br.readLine();
return s;
}
//-------------------------------------------------------------
public static char getChar() throws IOException
{
String s = getString();
return s.charAt(0);
}
//-------------------------------------------------------------
public static int getInt() throws IOException
{
String s = getString();
return Integer.parseInt(s);
}
}
class Node{
	private int iData;
	public Node(int ii){
		iData = ii;
	}
	public int getKey(){
		return iData;
	}
	public void setKey(int ii){
		iData = ii;
	}
}
class Heap{
	private Node[] heapArrays;
	private int maxsize;
	private int currentSize;
	
	public Heap(int mx){
		maxsize = mx;
		currentSize = 0;
		heapArrays = new Node[maxsize];
		
	}
	public boolean isEmpty(){
		return currentSize == 0;
	}
	public boolean insert(int key){
		if(currentSize==maxsize){
			return false;
		}
		Node newNode = new Node(key);
		heapArrays[currentSize] = newNode;
		trickleUP(currentSize++);
		return true;
		
	}
	public void trickleUP(int index){
		int parent = (index-1)/2;
		Node bottom = heapArrays[index];
		while(index > 0 && heapArrays[parent].getKey() < bottom.getKey()){
			heapArrays[index] = heapArrays[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapArrays[index] = bottom;
	}
	public Node remove(){
		Node root = heapArrays[0];
		heapArrays[0] = heapArrays[--currentSize];
		trickleDown(0);
		return root;
		
	}
	public void trickleDown(int index){
		int largerChild;
		Node top = heapArrays[index];
		while(index < currentSize/2){
			int leftChild = 2*index+1;
			int rightChild = leftChild+1;
			if(rightChild < currentSize && heapArrays[leftChild].getKey() < heapArrays[rightChild].getKey()){
				largerChild  = rightChild;
			}else{
				largerChild = leftChild;
			}
			if(top.getKey() >= heapArrays[largerChild].getKey()){
				break;
			}
			heapArrays[index] = heapArrays[largerChild];
			index = largerChild;
		}
		heapArrays[index] = top;
		
	}
	public boolean change(int index , int newValue){
		if(index<0 || index >= currentSize){
			return false;
		}
		int oldValue = heapArrays[index].getKey();
		heapArrays[index].setKey(newValue);
		if(oldValue < newValue){
			trickleUP(index);
		}else{
			trickleDown(index);
		}
		return true;
		
	}
	public void displayHeap(){
		System.out.print("heapArrays: ");
		for(int m = 0; m< currentSize;m++){
			if(heapArrays[m] != null){
				System.out.print(heapArrays[m].getKey()+" ");
			}else{
				System.out.print("-- ");
			}
			
		}
          System.out.println();
			int nBlanks = 32;
			int itemsPerRow = 1;
			int column = 0;
			int j = 0;
			String dots = "...............................";
			System.out.println(dots+dots);
			while(currentSize > 0){
				if(column == 0){
					for(int k=0;k<nBlanks;k++){
						System.out.print(' ');
					}
				}
					System.out.print(heapArrays[j].getKey());
					if(++j == currentSize){
						break;
					}
					if(++column == itemsPerRow){
						nBlanks /= 2;
						itemsPerRow *= 2;
						column = 0;
						System.out.println();
					}else{
						for(int k=0;k<nBlanks*2-2;k++){
							System.out.print(' ');
						}
					
					}
					
				
			}
		System.out.println("\n"+dots+dots);
	}
}