import java.io.*;

public class HashTableWithReHashMethod{
public static void main(String args[])throws IOException{
		
	
DataItem aDataItem;
int aKey, size,n,keyPerCell;
System.out.print("Enter size of a hash Table :");
size = getInt();
System.out.print("Enter initial number of items :");
n = getInt();
keyPerCell = 10;
HashTableWithReHash theHashTable = new HashTableWithReHash(size);
for(int i = 0; i < n;i++){
	aKey = (int) (java.lang.Math.random() * keyPerCell * size);
	aDataItem = new DataItem(aKey);
	theHashTable.insert(aDataItem);
}
while(true){
	System.out.print("Enter first letter of ");
	System.out.print("Show,insert,delete ");
	char choice = getChar();
	switch(choice){
		case 'i':
		System.out.print("Enter key value to insert: ");
		aKey = getInt();
		aDataItem = new DataItem(aKey);
		theHashTable.insert(aDataItem);
		break;
		case 'd':
		System.out.print("Enter key value to delete:");
		aKey = getInt();
		theHashTable.delete(aKey);
		break;
		case 's':
		theHashTable.displayTable();
		break;
		
		default:
		System.out.print("Invalid number!!!");
		
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
//--------------------------------------------------------------
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

class HashTableWithReHash{
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	private int itemCount;
	
	public HashTableWithReHash(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
		itemCount = 0;
		
	}
	public int hashFunc(int key){
		return key % arraySize;
	}
	public void insert(DataItem item){
		if((double)itemCount / arraySize > 0.5){
			rehash();
		}
		int key = item.getKey();
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
			hashVal = (hashVal +1)%arraySize;
		}
		hashArray[hashVal] = item;
		itemCount++;
		
	}
	private void rehash(){
		int newSize  = getNextPrime(arraySize*2);
		DataItem[] newHashArray = new DataItem[newSize];
		
		for(int i=0;i<arraySize;i++){
			if(hashArray[i] != null && hashArray[i].getKey() != -1){
				int key = hashArray[i].getKey();
				int hashVal = key % newSize;
				while(newHashArray[hashVal] != null){
					hashVal = (hashVal+1) % newSize;
				}
				newHashArray[hashVal] = hashArray[i];
			}
		}
		hashArray = newHashArray;
		arraySize = newSize;
		
	}
	private int getNextPrime(int n){
		while(!isPrime(n)){
			n++;
		}
		return n;
	}
	private boolean isPrime(int n){
		if(n <= 1){
			return false;
		}
		if(n <= 3){
			return true;
		}
		if(n % 2 == 0 || n % 3 == 0){
			return false;
		}
		for(int i = 5;i*i <= n;i += 6){
			if(n % i == 0 || n % (i+2) == 0){
				return false;
			}
			
		}
		return true;
		
	}
	public DataItem delete(int key){
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getKey() != key){
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				itemCount--;
				return temp;
			}
			hashVal = (hashVal+1)%arraySize;
		}
		return null;
	}
	public void displayTable(){
		System.out.print("Table : ");
		for(int i=0;i<arraySize;i++){
			if(hashArray[i] != null){
				System.out.print(hashArray[i].getKey()+" ");
			}else{
				System.out.print("** ");
			}
			
		}
		System.out.println("");
	}
}
class DataItem{
	private int iData;
	
	public DataItem(int ii){
		iData = ii;
	}
	public int getKey(){
		return iData;
	}
	
}