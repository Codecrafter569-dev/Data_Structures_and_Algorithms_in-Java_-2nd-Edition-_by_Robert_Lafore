/*
- **Definition:**  
  Linear search, also known as sequential search, traverses the array from the first element to the last, comparing each element with the target value.

- **Time Complexity:**
  - **Best Case:** O(1) – when the target is the first element.
  - **Worst Case:** O(n) – when the target is at the end of the array or not present at all, where *n* is the number of elements.
  
- **Space Complexity:**  
  O(1) – linear search uses a constant amount of space since it only requires a few extra variables.

*/

public class LinearSearchInArrays{
public static void main(String args[]){
int[] numbers = {1,3,4,5,6,7,8,9};
int target = 40;
int index = linearSearch(numbers,target);
if(index != -1){
System.out.println("Element "+target+" found at Index : "+index);	
}else{
	System.out.println("Element "+target+" Not found in the array.");
}

}
public static int linearSearch(int[] arr,int target){
	for(int i = 0; i < arr.length;i++){
		if(arr[i] == target){
			return i;
		}
	}
	return -1;
}
}