public class QuickSortExample{
public static void main(String args[]){
int[] arr = {45,64,1,234,67,97,1,2,32,3,4,5,6,7,8,9};
System.out.println("Original arrays :");
for(int num : arr){
	System.out.print(num+ " ");
}
System.out.println();

quickSort(arr,0,arr.length-1);

System.out.println("Sorted arrays : ");
for(int num : arr){
	System.out.print(num+" ");
}
System.out.println();
}
public static int partition(int[] arr,int low , int high){
	int pivot = arr[high];
	int i = low;
	
	for(int j= low;j< high;j++){
		if(arr[j] <= pivot){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
		}
	}
	int temp = arr[i];
	arr[i] = arr[high];
	arr[high] = temp;
	
	return i;
}
public static void quickSort(int[] arr,int low , int high){
	if(low < high){
		int pivotIndex = partition(arr,low,high);
		
		quickSort(arr,low,pivotIndex-1);
		quickSort(arr,pivotIndex+1,high);
	}
}
}