import java.io.*;
public class HashTableWithQuadraticProd{
public static void main(String args[]) throws IOException{
DataItem aDataItem;
int aKey, size,n,keysPerCell;

System.out.print("Enter size of hash table: ");
size = getInt();
System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;
		
		HashTableWithPod theHashTable = new HashTableWithPod(size);
		for (int j = 0; j < n; j++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);
        }

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                    } else {
                        System.out.println("Could not find " + aKey);
                    }
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
}
 public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}




class DataItem {
    private int iData; // Data item (key)

    public DataItem(int ii) {
        iData = ii;
    }

    public int getKey() {
        return iData;
    }
}

class HashTableWithPod {
    private DataItem[] hashArray; // Array holds hash table
    private int arraySize;
    private DataItem nonItem; // For deleted items

    public HashTableWithPod(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); // Deleted item key is -1
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    public int hashFunc(int key) {
        return key % arraySize; // Hash function
    }

    // Modified insert method using quadratic probing
    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key); // Hash the key
        int i = 0; // Probe counter

        // Continue probing until an empty slot or deleted slot is found
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            i++;
            // Quadratic probing: add i^2 to the hash value
            hashVal = (hashFunc(key) + i * i) % arraySize;
        }
        hashArray[hashVal] = item; // Insert item
    }

    // Modified find method using quadratic probing
    public DataItem find(int key) {
        int hashVal = hashFunc(key); // Hash the key
        int i = 0; // Probe counter

        // Probe until the key is found, or an empty slot is encountered
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal]; // Found it
            i++;
            // Quadratic probing: add i^2 to the hash value
            hashVal = (hashFunc(key) + i * i) % arraySize;
        }
        return null; // Not found
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key); // Hash the key
        int i = 0; // Probe counter

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // Save item
                hashArray[hashVal] = nonItem; // Delete item
                return temp; // Return item
            }
            i++;
            // Quadratic probing: add i^2 to the hash value
            hashVal = (hashFunc(key) + i * i) % arraySize;
        }
        return null; // Not found
    }
}