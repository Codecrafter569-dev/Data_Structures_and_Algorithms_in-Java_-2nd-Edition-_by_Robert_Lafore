public class GetMaxTestDriveInArray{
public static void main(String args[]){
	GetMaxValueInArray a = new GetMaxValueInArray();
int[] array = {1,2,3,4,5,66,6,7,855,90};
System.out.println("Array elements :");
for(int value : array){
	System.out.print(value+" ");
}
System.out.println();
int maxValue = a.getMax(array);
System.out.println("Maximum value in the array : "+maxValue);

int[] emptyArray = new int[0];
System.out.println("Maximum value in an empty Array : "+a.getMax(emptyArray));
}
}
class GetMaxValueInArray{
	public int getMax(int[] arr){
		if(arr == null || arr.length == 0){
			return -1;
		}
		int max = arr[0];
		for(int i = 1;i < arr.length;i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		return max;
	}
	
}