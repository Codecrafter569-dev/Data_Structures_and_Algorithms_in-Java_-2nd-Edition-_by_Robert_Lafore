public class QuickSelectMedian{
public static void main(String args[]){
int[] data = { 9, 4, 7, 1, 3, 6, 8,90 };

        // Display original array.
        System.out.print("Original array: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Find and display the median value.
        int median = findMedian(data);
        System.out.println("Median is: " + median);
		
		System.out.print("Partitioned array: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
}
public static int findMedian(int[] arr){
	int n = arr.length;
	int medianIndex = n/2;
	return select(arr,0,n-1,medianIndex);
}
public static int select(int[] arr,int left,int right,int k){
	if(left == right){
		return arr[left];
	}
	int pivotIndex = partition(arr,left,right);
	
	if(k == pivotIndex){
		return arr[pivotIndex];
	}else if(k < pivotIndex){
		return select(arr,left,pivotIndex-1,k);
	}else{
		return select(arr,pivotIndex+1,right,k);
	}
	
}
public static int partition(int[] arr,int left,int right){
	int pivot = arr[right];
	int i = left;
	
	for(int j= left;j<right;j++){
		if(arr[j] < pivot){
			swap(arr,i,j);
			i++;
		}
	}
	swap(arr,i,right);
	return i;
}
public static void swap(int[] arr,int i,int j){
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}
}