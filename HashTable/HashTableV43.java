import java.lang.Math;





// Class to represent key-value pair
class Entry<K, V> {
    K key;
    V value;
    boolean isDeleted; // For lazy deletion

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.isDeleted = false;
    }
}

// Hash Table implementation using array with linear probing
public class HashTableV43<K, V> {
    private Entry<K, V>[] table;
    private int size;
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    // Constructor
    @SuppressWarnings("unchecked")
    public HashTableV43() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    // Hash function
    private int getIndex(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode() % table.length);
    }

    // Linear probing to find next available slot or existing key
    private int findSlot(K key, boolean search) {
        int index = getIndex(key);
        int originalIndex = index;

        do {
            // Empty slot or deleted slot (for put operation)
            if (table[index] == null || (table[index].isDeleted && !search)) {
                return index;
            }
            // Key found (for get/remove operations)
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                return index;
            }
            index = (index + 1) % table.length; // Linear probing
        } while (index != originalIndex);

        return -1; // Table is full or key not found
    }

    // Put a key-value pair
    public void put(K key, V value) {
        int index = findSlot(key, false);

        if (index == -1) {
            resize();
            index = findSlot(key, false);
        }

        // Update existing key
        if (table[index] != null && !table[index].isDeleted && table[index].key.equals(key)) {
            table[index].value = value;
            return;
        }

        // Insert new entry
        table[index] = new Entry<>(key, value);
        size++;

        // Check if resize is needed
        if ((double) size / table.length >= LOAD_FACTOR) {
            resize();
        }
    }

    // Get value by key
    public V get(K key) {
        int index = findSlot(key, true);
        if (index != -1 && table[index] != null && !table[index].isDeleted) {
            return table[index].value;
        }
        return null; // Key not found
    }

    // Remove key-value pair
    public boolean remove(K key) {
        int index = findSlot(key, true);
        if (index != -1 && table[index] != null && !table[index].isDeleted) {
            table[index].isDeleted = true; // Lazy deletion
            size--;
            return true;
        }
        return false; // Key not found
    }

    // Get size of hash table
    public int size() {
        return size;
    }

    // Check if hash table is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Resize hash table
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        // Rehash all non-deleted entries
        for (Entry<K, V> entry : oldTable) {
            if (entry != null && !entry.isDeleted) {
                put(entry.key, entry.value);
            }
        }
    }

    // Main method with example usage
    public static void main(String[] args) {
        HashTableV43<String,Integer> hashTable = new HashTableV43<>();

        // Adding key-value pairs
        hashTable.put("Alice", 25);
        hashTable.put("Bob", 30);
        hashTable.put("Charlie", 35);
        hashTable.put("Alice", 26); // Update Alice's age

        // Retrieving values
        System.out.println("Alice's age: " + hashTable.get("Alice")); // Output: 26
        System.out.println("Bob's age: " + hashTable.get("Bob"));     // Output: 30
        System.out.println("Size: " + hashTable.size());              // Output: 3

        // Removing a key
        hashTable.remove("Bob");
        System.out.println("After removing Bob, size: " + hashTable.size()); // Output: 2
        System.out.println("Bob's age: " + hashTable.get("Bob"));    // Output: null

        // Check if empty
        System.out.println("Is empty? " + hashTable.isEmpty());      // Output: false
    }
}
/*```

This implementation includes:

1. **Generic Type Support**: Supports any key-value pair types using Java generics.
2. **Linear Probing**: Handles collisions by probing to the next available slot in the array.
3. **Lazy Deletion**: Marks entries as deleted instead of setting them to null to maintain probe chains.
4. **Dynamic Resizing**: Doubles the table size when the load factor (0.75) is exceeded.
5. **Basic Operations**:
   - `put(K key, V value)`: Adds or updates a key-value pair
   - `get(K key)`: Retrieves value by key
   - `remove(K key)`: Removes a key-value pair
   - `size()`: Returns number of entries
   - `isEmpty()`: Checks if table is empty
6. **Hash Function**: Uses Java's `hashCode()` with modulo for initial index.
7. **Main Method**: Demonstrates usage with example operations.

Key features:
- Uses a single array to store entries
- Handles null keys (maps to index 0)
- Implements linear probing for collision resolution
- Uses lazy deletion to maintain probe sequences
- Automatically resizes to maintain performance
- Thread-safe for single-threaded use (not synchronized for multi-threading)

To use this hash table, compile and run the code. The main method provides example operations. You can modify it to test different scenarios or integrate it into a larger program.

For thread-safe operations in a multi-threaded environment, you would need to add synchronization or use `ConcurrentHashMap` from Java's standard library. This implementation is simpler than the separate chaining version but may suffer from clustering issues with linear probing. For better performance with high collision rates, you could modify it to use quadratic probing or double hashing.

*/