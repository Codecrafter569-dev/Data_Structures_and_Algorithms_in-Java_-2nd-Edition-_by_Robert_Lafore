public class ArraysInJavaV2{
public static void main(String args[]){
new ArraysInJavaV2().go();
}
public void go(){
	 int[] array = {1, 2, 3, 4, 5};
        int indexToDelete = 2; // delete element at index 2

        System.out.println("Original Array:");
        printArray(array);

        deleteElement(array, indexToDelete);

        System.out.println("Array after deletion:");
        printArray(array);
}


    public  void deleteElement(int[] array, int indexToDelete) {
        if (indexToDelete < 0 || indexToDelete >= array.length) {
            System.out.println("Invalid index");
            return;
        }

        // Shift elements
        for (int i = indexToDelete; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        // Update array size
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        array = newArray;
    }

    public  void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}