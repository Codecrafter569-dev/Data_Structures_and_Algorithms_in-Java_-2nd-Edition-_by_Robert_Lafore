public class MinHeapV2{
	 private int[] items;      // heap array, 1-based indexing
    private int size;         // number of elements in heap

    public MinHeapV2(int capacity) {
        items = new int[capacity + 1];
        size = 0;
    }

    // Insert a new value into the heap
    public void insert(int value) {
        if (size + 1 >= items.length) {
            throw new IllegalStateException("Heap is full");
        }
        items[++size] = value;
        fixUp(size);
    }

    // Remove and return the smallest (root) element
    public int delete() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = items[1];
        items[1] = items[size--];
        fixDown(1);
        return min;
    }

    // Move item at index k up to restore heap order
    private void fixUp(int k) {
        int v = items[k];
        while (k > 1 && items[k / 2] > v) {
            items[k] = items[k / 2];
            k /= 2;
        }
        items[k] = v;
    }

    // Move item at index k down to restore heap order
    private void fixDown(int k) {
        int v = items[k];
        int child;
        while (2 * k <= size) {
            child = 2 * k;
            // choose smaller of the two children
            if (child < size && items[child] > items[child + 1]) {
                child++;
            }
            if (v <= items[child]) {
                break; // heap order restored
            }
            items[k] = items[child];
            k = child;
        }
        items[k] = v;
    }

    // Peek at the smallest element without removing
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return items[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // Optional: utility to print heap contents (for debugging)
    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
public static void main(String args[]){
MinHeapV2 h = new MinHeapV2(20);
h.insert(23);
h.insert(59);
h.insert(1);
h.insert(8);
h.insert(2);
h.insert(9);
h.insert(22);
h.printHeap();
System.out.print("The minmum value is :"+h.peek()+"\n and after deleting \n");

h.delete();

System.out.print("The minmum value is :"+h.peek()+"");

}
}