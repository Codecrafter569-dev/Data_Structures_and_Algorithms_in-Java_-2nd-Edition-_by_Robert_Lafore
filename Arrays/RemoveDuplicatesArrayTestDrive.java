import java.util.Arrays;
public class RemoveDuplicatesArrayTestDrive{
public static void main(String args[]){
	RemoveDuplicatesArray a = new RemoveDuplicatesArray();
int[] array = {10, 20, 20, 30, 40, 50, 50, 60, 10};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));
		int[] uniqueArray = a.removeDuplicates(array);
		
		
		System.out.println("Array after removing duplicates:");
        System.out.println(Arrays.toString(uniqueArray));
}
}
class RemoveDuplicatesArray{
	public int[] removeDuplicates(int[] arr){
		if(arr == null || arr.length == 0){
			return new int[0];
		}
		int n = arr.length;
		int[] temp = new int[n];
		int j = 0;
		for(int i = 0;i < n;i++){
			boolean isDuplicate = false;
			
			for(int k = 0; k < j;k++){
				if(arr[i] == temp[k]){
					isDuplicate = true;
					break;
				}
			}
			
			if(!isDuplicate){
				temp[j] = arr[i];
				j++;
			}
		}
		return Arrays.copyOf(temp,j);
	}
	
}