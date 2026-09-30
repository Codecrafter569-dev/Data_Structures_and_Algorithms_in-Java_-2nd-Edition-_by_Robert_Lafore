public class MinHeap {
	private int[] items;
	private int size;
	
	public MinHeap(int capacity){
		items = new int[capacity +1];
		size  = 0;
	}
	public void insert(int value){
		if(size+1 >= items.length){
			throw new IllegalStateException("Heap is full");
		}
		items[++size] = value;
		fixUp(size);
	}
	public void toss(int value){
		if(size +1 >= items.length){
			throw new IllegalStateException("Heap is full");
			
		}
		items[++size] = value;
	}
	public void restoreHeap(){
		for(int k = size/2; k >= 1;k--){
			fixDown(k);
		}
	}
	public int delete(){
		if(size == 0){
			throw new IllegalStateException("heap is empty");
		}
		int min = items[1];
		items[1] = items[size--];
		fixDown(1);
		return min;
	}
	public int peek(){
		if(size == 0){
			throw new IllegalStateException("Heap is empty");
		}
		return items[1];
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int getSize(){
		return size;
	}
	private void fixUp(int k){
		int v = items[k];
		while(k > 1 && items[k/2] > v){
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
			if(child < size && items[child]  > items[child+1]){
				child++;
			}
			if(v <= items[child]){
				break;
			}
			items[k] = items[child];
			k = child;
			
		}
		items[k] = v;
		
	}
	public void printHeap(){
		for(int i = 1; i <= size; i++){
			System.out.print(items[i]+" ");
			
		}
		System.out.println();
	}
public static void main(String args[]){
MinHeap heap  = new MinHeap(20);
heap.insert(20);
        heap.insert(5);
        heap.insert(15);
        System.out.print("After insert(): ");
        heap.printHeap();
		
		// Toss in more items without maintaining order
        heap.toss(10);
        heap.toss(2);
        heap.toss(17);
        System.out.print("After toss(): ");
        heap.printHeap();


 // Restore full heap order in O(n)
        heap.restoreHeap();
        System.out.print("After restoreHeap(): ");
        heap.printHeap();
}
}