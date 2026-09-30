import java.io.*;
public class HashTableLinearProbeTestDrive{
public static void main(String args[])throws IOException{
String aKey;
        int size, n;

        // Get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();

        // Create hash table
        StringHashTable theHashTable = new StringHashTable(size);

        // Insert initial items (random lowercase strings)
        for (int j = 0; j < n; j++) {
            aKey = generateRandomString(3); // Generate 3-letter string
            theHashTable.insert(aKey);
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
                    System.out.print("Enter string to insert: ");
                    aKey = getString();
                    theHashTable.insert(aKey);
                    break;
                case 'd':
                    System.out.print("Enter string to delete: ");
                    aKey = getString();
                    DataItem deleted = theHashTable.delete(aKey);
                    if (deleted != null) {
                        System.out.println("Deleted " + aKey);
                    } else {
                        System.out.println("Could not delete " + aKey);
                    }
                    break;
                case 'f':
                    System.out.print("Enter string to find: ");
                    aKey = getString();
                    DataItem found = theHashTable.find(aKey);
                    if (found != null) {
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

    // Utility method to read a char
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    // Utility method to read an int
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    // Utility method to generate a random lowercase string
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + (int) (Math.random() * 26));
            sb.append(c);
        }
        return sb.toString();
    }
}
class DataItem{
	private String key;
	public DataItem(String key){
		this.key = key;
	}
	public String getKey(){
		return key;
	}
}
class StringHashTable{
	private DataItem[] hashArray;
	private int arraysize;
	private DataItem nonItem;
	
	public StringHashTable(int size){
		arraysize = size;
		hashArray = new DataItem[arraysize];
	     nonItem = new DataItem(null);
		
	}
	public void displayTable(){
		System.out.print("Table ");
		for(int i = 0;i < arraysize;i++){
			if(hashArray[i] != null && hashArray[i].getKey() != null){
				System.out.print(hashArray[i].getKey()+" ");
			}else{
				System.out.print("** ");
			}
			
		}
		System.out.println("");
		
	}
	public int hashFunc(String key){
		int hashVal = 0;
		for(int i = 0;i < key.length();i++){
			int letter = key.charAt(i) - 'a' +1;
			hashVal = (hashVal*31+letter)%arraysize;
			
		}
		return hashVal;
	}
	public void insert(String key){
		DataItem item = new DataItem(key);
		int hashVal = hashFunc(key);
		int originalHashVal = hashVal;
		
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != null){
			hashVal = (hashVal+1)%arraysize;
			if(hashVal == originalHashVal){
				System.out.println("Table is full , cannot insert "+key);
				return;
			}
			
		}
		hashArray[hashVal] = item;
	}
	public DataItem find(String key){
		int hashVal = hashFunc(key);
		int originalHashVal = hashVal;
		
		while(hashArray[hashVal] != null ){
			if(hashArray[hashVal].getKey().equals(key)){
				return hashArray[hashVal];
			
			}
			hashVal = (hashVal+1)%arraysize;
			if(hashVal == originalHashVal){
				break;
			}
			
		}
		return null;
	}
	public DataItem delete(String key){
		int hashVal = hashFunc(key);
		int originalHashVal = hashVal;
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getKey().equals(key)){
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			hashVal = (hashVal+1)%arraysize;
			if(hashVal == originalHashVal){
				break;
			}
		}
		return null;
	}
}