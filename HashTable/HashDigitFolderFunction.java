import java.io.*;

public class HashDigitFolderFunction {
    public static void main(String[] args) throws IOException {
        int size, groupSize, n;

        // Get user input
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter group size for folding: ");
        groupSize = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
		
		HashTable6543 theHashTable = new HashTable6543(size,groupSize);
		// Insert initial random items
        for (int j = 0; j < n; j++) {
            int aKey = (int) (Math.random() * 10000); // Random keys
            DataItem aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);
        }

        // Interactive menu
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
                    int aKey = getInt();
                    DataItem aDataItem = new DataItem(aKey);
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

class HashTable6543 {
    private DataItem[] hashArray; // Array holds hash table
    private int arraySize;
    private DataItem nonItem; // For deleted items
    private int groupSize; // Size of each group for folding

    public HashTable6543(int size, int groupSize) {
        arraySize = size;
        this.groupSize = groupSize;
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

    // Digit-folding hash function
    public int hashFunc(int key) {
        String keyStr = String.valueOf(key);
        int sum = 0;
        // Process the key in groups of groupSize digits
        for (int i = 0; i < keyStr.length(); i += groupSize) {
            int end = Math.min(i + groupSize, keyStr.length());
            String group = keyStr.substring(i, end);
            sum += Integer.parseInt(group);
        }
        return sum % arraySize;
    }

    // Insert a DataItem using linear probing
    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key); // Hash the key
        // Probe linearly until an empty or deleted slot is found
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal = (hashVal + 1) % arraySize; // Move to next slot
        }
        hashArray[hashVal] = item; // Insert item
    }

    // Find a DataItem with given key
    public DataItem find(int key) {
        int hashVal = hashFunc(key); // Hash the key
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal]; // Found it
            hashVal = (hashVal + 1) % arraySize; // Linear probing
        }
        return null; // Not found
    }

    // Delete a DataItem with given key
    public DataItem delete(int key) {
        int hashVal = hashFunc(key); // Hash the key
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // Save item
                hashArray[hashVal] = nonItem; // Mark as deleted
                return temp; // Return item
            }
            hashVal = (hashVal + 1) % arraySize; // Linear probing
        }
        return null; // Not found
    }
}


