public class ArraysInJavaV4{
public static void main(String args[]){
int[] array = {1,2,3,4,5,6};
int elementToInsert = 676;
int insertionPoint = 2;

 System.out.println("Original Array:");
        printArray(array);
        System.out.println("Array after insertion:");
               insertElement(array, elementToInsert, insertionPoint);

}
public static void insertElement(int[] array, int elementToInsert,int insertionPoint){
	if(array.length == 0 ){
		array = new int[1];
		array[0] = elementToInsert;
    }else if(insertionPoint < 0 || insertionPoint > array.length){
		System.out.println("Invalid insertion point");
	}else{
		int[] newArray = new int[array.length +1];
		System.arraycopy(array, 0, newArray, 0, insertionPoint);
            System.arraycopy(array, insertionPoint, newArray, insertionPoint + 1, array.length - insertionPoint);
			
			//Insert the new elementToInsert
			newArray[insertionPoint] = elementToInsert;
			
			//Update the original array
			array = newArray;
			printArray(array);
	}
	
}
public static void printArray(int[] array){
	for(int i = 0; i < array.length; i++){
		System.out.print(array[i]+" ");
	}
	System.out.println();
}
}