public class HeapInDescendingOrderTestDrive{
public static void main(String args[]){
PriorityQSe pq = new PriorityQSe(10);
HeapV4 heapInDe = new HeapV4(20);
MinHeapV2 heap = new MinHeapV2(20);
pq.insert(15);
pq.insert(112);
pq.insert(1);
pq.insert(154);
System.out.println("PriorityQueue Operation ");
pq.printQueue();

int max = pq.remove();
System.out.println("Removed max : "+max);
System.out.print("After remove: ");
pq.printQueue();

System.out.println("Current max : "+pq.peek());

heap.insert(1);
heap.insert(3);
heap.insert(2);
heap.insert(4);
heap.insert(3);
heap.insert(8);
heap.insert(6);
heap.insert(2);
System.out.println("MinHeap Operation : ");
System.out.print("After inserting : ");
heap.printHeap();

heap.toss(10);
heap.toss(20);
heap.toss(44);
System.out.print("After tossing : ");
heap.printHeap();

heap.restoreHeap();
System.out.print("After restore: ");
heap.printHeap();


System.out.println("Heap in desendingorder : ");
heapInDe.insert(1);
heapInDe.insert(5);
heapInDe.insert(9);
heapInDe.insert(4);
heapInDe.insert(7);
heapInDe.insert(3);
heapInDe.insert(2);
System.out.print("After inserting : ");
heapInDe.printHeap();

System.out.println(" \n deleteing : "+heapInDe.delete());
System.out.print("After deleteing : ");
heapInDe.printHeap();
System.out.println(" Current Value : "+heapInDe.peek());

}
}
class HeapV4{
	private int[] items;
	private int size;
	
	public HeapV4(int capacity){
		items = new int[capacity+1];
		size = 0;
	}
	public void insert(int value){
		if(size+1 >= items.length){
			throw new IllegalStateException("Heap is full");
		}
			items[++size] = value;
			fixUP(size);
		
		
	}
	public int delete(){
		if( size == 0){
			throw new IllegalStateException("Heap is empty");
		}
			int max = items[1];
			items[1] = items[size--];
			fixDown(1);
			return max;
		
	}
	public int peek(){
		if(size == 0){
			throw new IllegalStateException("heap is empty");
		}
		return items[1];
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int getSize(){
		return size;
	}
	private void fixUP(int k){
		int v = items[k];
		while(k > 1 && items[k/2] < v){
			items[k] = items[k/2];
			k /= 2;
			
		}
		items[k] = v;
	}
	private void fixDown(int k){
		int v = items[k];
		int child;
		while(2*k <= size){
			child = 2*k;
			if(child < size && items[child] < items[child+1]){
				child++;
			}
			if(v >= items[child]){
				break;
			}
			items[k] = items[child];
			k = child;
			
		}
		items[k] = v;
	}
	public void printHeap(){
		for(int i = 1; i <= size;i++){
			System.out.print(items[i]+" ");
		}
		System.out.println();
	}
}




//MinHeap code example
class MinHeapV2 {
    private int[] items;  // 1‑based heap array
    private int size;     

    public MinHeapV2(int capacity) {
        items = new int[capacity + 1];
        size = 0;
    }

    /** Normal insert with heap order */
    public void insert(int value) {
        if (size + 1 >= items.length) throw new IllegalStateException("Heap is full");
        items[++size] = value;
        fixUp(size);
    }

    /** Fast toss without maintaining order */
    public void toss(int value) {
        if (size + 1 >= items.length) throw new IllegalStateException("Heap is full");
        items[++size] = value;
    }

    /** Restore full min‑heap order in O(n) */
    public void restoreHeap() {
        for (int k = size/2; k >= 1; k--) {
            fixDown(k);
        }
    }

    /** Remove & return smallest */
    public int delete() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int min = items[1];
        items[1] = items[size--];
        fixDown(1);
        return min;
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return items[1];
    }
    public boolean isEmpty() { return size == 0; }
    public int getSize()    { return size; }

    private void fixUp(int k) {
        int v = items[k];
        while (k > 1 && items[k/2] > v) {
            items[k] = items[k/2];
            k /= 2;
        }
        items[k] = v;
    }

    private void fixDown(int k) {
        int v = items[k];
        int child;
        while (2*k <= size) {
            child = 2*k;
            if (child < size && items[child] > items[child+1]) child++;
            if (v <= items[child]) break;
            items[k] = items[child];
            k = child;
        }
        items[k] = v;
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) System.out.print(items[i] + " ");
        System.out.println();
    }

    
}







//PriorityQueue
class PriorityQSe{
	private HeapV4 heap;
	
	public PriorityQSe(int capacity){
		heap = new HeapV4(capacity);
	}
	public void insert(int value){
		heap.insert(value);
	}
	public int remove(){
		return heap.delete();
	}
	public int peek(){
		return heap.peek();
	}
	public int size(){
	return heap.getSize();	
	}
	public void printQueue(){
		heap.printHeap();
	}
	
}