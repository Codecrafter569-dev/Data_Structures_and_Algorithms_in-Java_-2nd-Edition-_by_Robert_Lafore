public class Partition_based_Algorithm{

public static void main(String args[]){
int[] arr = {54,67,12,34,35,62,15,61,80,35,2343,3,12};
int k = 4;
System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
		
		int kthSmallest = select(arr, k-1);
		int kthLargest = select(arr,arr.length-k);
        System.out.println("The " + (k) + "th Largest element is: " + kthLargest);
		System.out.println("The "+(k)+"th smallest element is: "+kthSmallest);
	 int[] smallArr = {99};
        System.out.println("In a single-element array, the smallest element is: " + select(smallArr, 0));

System.out.print("Partitioned array : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
				
}
public static int select(int[] arr,int k){
	if(arr == null || arr.length == 0){
		throw new IllegalArgumentException("Array must have at least one element.");
	}
	if(k < 0 || k >= arr.length){
		throw new IllegalArgumentException("k must be between 0 and "+(arr.length-1));
	}
	return select(arr,0,arr.length-1,k);
}
private static int select(int[] arr,int left,int right,int k){
	if(left == right){
		return arr[left];
	}
	int pivotIndex = partition(arr,left,right);
	
	if(k == pivotIndex){
		return arr[pivotIndex];
	}else if( k < pivotIndex){
		return select(arr,left,pivotIndex-1,k);
	}else{
		return select(arr,pivotIndex+1,right,k);
	}
}
private static int partition(int[] arr,int left,int right){
	int pivot = arr[right];
	int i = left;
	
	for(int j= left; j < right;j++){
		if(arr[j] < pivot){
			swap(arr,i,j);
			i++;
		}
	}
	swap(arr,i,right);
	return i;
}
private static void swap(int[] arr,int i,int j){
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}
}