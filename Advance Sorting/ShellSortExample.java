public class ShellSortExample{
public static void main(String args[]){
int[] array = {23,2,3,4,5,6,76,33,5678,96,123,7};
System.out.println("Original array : ");
for(int num : array){
	System.out.print(num+ " ");
}
System.out.println();
shellsort(array);
System.out.println("Sorted Array : ");
for(int num : array){
	System.out.print(num+ " ");
}
System.out.println();
}
public static void shellsort(int[] arr){
	int n = arr.length;
	
	for(int gap = n/2; gap > 0; gap /= 2){
		for(int i = gap;i < n;i++){
			int temp = arr[i];
			int j = i;
			
			while(j >= gap && arr[j-gap] > temp){
				arr[j] = arr[j-gap];
				j -= gap;
				
			}
			arr[j] = temp;
		}
	}
}
}