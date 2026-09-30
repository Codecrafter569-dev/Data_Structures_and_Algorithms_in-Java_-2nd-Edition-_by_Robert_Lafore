public class CocktailShakerSort{
public static void main(String args[]){
int[] arr = {5,1,4,2,8,0,2};
System.out.println("Before sorting : ");
for(int num : arr){
	System.out.print(num+ " ");
}
System.out.println();
cocktailShakerSort(arr);
System.out.println("After sorting : ");
for(int num : arr){
	System.out.print(num+ " ");
}
System.out.println();

}
public static void cocktailShakerSort(int[] arr){
	boolean swapped = true;
	int left = 0;
	int right = arr.length-1;
	
	while(left < right && swapped){
		swapped = false;
		
		for(int i = left; i < right ; i++){
			if(arr[i] > arr[i+1]){
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				swapped = true;
			}
			
		}
		right--;
		if(!swapped){
			break;
		}
		swapped = false;
		for(int i = right; i > left;i--){
			if(arr[i] < arr[i-1]){
				int temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
				swapped = true;
			}
			
		}
		left++;
	}
	
	
}
}