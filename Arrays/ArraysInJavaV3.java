public class ArraysInJavaV3{
public static void main(String args[]){
int[] array = {1,2,3,4,5};
int elementToDelete = 4;
System.out.println("Original Array:");
printArray(array);

System.out.println("Array after deletion");
deleteElements(array,elementToDelete);
}
 public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
	public static void deleteElements(int[] array , int elementToDelete){
		int indexToDelete = -1;
		for(int i = 0; i < array.length;i++){
			if(array[i] == elementToDelete){
				indexToDelete = i;
				break;
			}
			
		}
		if(indexToDelete != -1){
			for(int i = indexToDelete; i < array.length-1;i++){
			array[i] = array[i+1];
			}
			int[] newArray = new int[array.length - 1];
			System.arraycopy(array,0,newArray,0,array.length-1);
			array = newArray;
			printArray(array);
		}else{
			System.out.println("Element not found in array");
		}
	}
}