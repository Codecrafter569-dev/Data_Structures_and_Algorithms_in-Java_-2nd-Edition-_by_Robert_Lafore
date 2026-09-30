public class InsertionSortCounter{
	private long comparisons;
	private long copies;
public static void main(String args[]){
	InsertionSortCounter sorter = new InsertionSortCounter();
  int size = 10;
        int[] inverselySorted = new int[size];
        for (int i = 0; i < size; i++) {
            inverselySorted[i] = size - i;  // creates descending order: 10, 9, ... , 1
        }
        System.out.println("Inversely Sorted Data:");
        display(inverselySorted);

        sorter.insertionSort(inverselySorted);
        System.out.println("After Insertion Sort:");
        display(inverselySorted);
        System.out.println("Comparisons: " + sorter.getComparisons());
        System.out.println("Copies: " + sorter.getCopies());

        // Test with almost-sorted data: only a few items are out of order.
        int[] almostSorted = {1, 2, 3, 5, 4, 6, 7, 8, 9, 10};
        System.out.println("\nAlmost Sorted Data:");
        display(almostSorted);

        // Reset counts for a new run
        sorter.insertionSort(almostSorted);
        System.out.println("After Insertion Sort:");
        display(almostSorted);
        System.out.println("Comparisons: " + sorter.getComparisons());
        System.out.println("Copies: " + sorter.getCopies());
}
public void insertionSort(int[] arr){
	comparisons = 0;
	copies = 0;
	int n = arr.length;
	
	for(int i = 1;i < n;i++){
		int key = arr[i];
		copies++;
		int j = i;
		
	   while(j > 0){
		   comparisons++;
		   if(arr[j-1] > key){
			   arr[j] = arr[j-1];
			   copies++;
			   j--;
		   }else{
			   break;
		   }
		   
	   }
	   arr[j] = key;
	   copies++;
	}
}
public static void display(int[] arr){
	for(int num : arr){
	System.out.print(num+" ");	
		
	}
	System.out.println();
	
}
public  long getComparisons(){
	
	return comparisons;
}
public long getCopies(){
	return copies;
}
}