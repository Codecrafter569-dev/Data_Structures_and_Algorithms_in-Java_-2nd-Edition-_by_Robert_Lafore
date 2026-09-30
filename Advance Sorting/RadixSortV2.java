public class RadixSortV2{
public static void main(String args[]){
int[] data = {170, 45, 75, 90, 802, 24, 2, 66};

        // Choose a base. For example, 10 for decimal. Try changing it to 2 or 16.
        int base = 10;

        System.out.println("Original array (in base " + base + "):");
        printArrayInBase(data, base);

        // Sort the array using radix sort.
        radixSort(data, base);

        System.out.println("Sorted array (in base " + base + "):");
        printArrayInBase(data, base);

        // To illustrate printing in a different base,
        // you might want to see how numbers look in hexadecimal.
        int printBase = 16;
        System.out.println("Sorted array in hexadecimal (base " + printBase + "):");
        printArrayInBase(data, printBase);
		
		
		 printBase = 8;
        System.out.println("Sorted array in ocatal (base " + printBase + "):");
        printArrayInBase(data, printBase);
		
		printBase = 2;
        System.out.println("Sorted array in baineriy (base " + printBase + "):");
        printArrayInBase(data, printBase);
}
public static void radixSort(int[] arr,int base){
	if(arr == null || arr.length == 0){
		return;
	}
	int max = getMax(arr);
	int exp = 1;
	
	while(max /exp > 0){
		System.out.println("Exponent is a Value "+exp);
		coutingSortByDigit(arr,base,exp);
		exp *= base;
		
	}
}
 public static void printArrayInBase(int[] arr, int base) {
        for (int value : arr) {
            System.out.print(toBaseString(value, base) + " ");
        }
        System.out.println();
    }
public static String toBaseString(int number, int base) {
        // For bases up to 16, you could use the built-in Java conversion:
        return Integer.toString(number, base).toUpperCase();
        // Alternatively, you can implement your own conversion routine.
    }
	private static void coutingSortByDigit(int[] arr,int base ,int exp){
		int n = arr.length;
		int[] output  = new int[n];
		int[] count = new int[base];
		
		for(int i = 0;i<n;i++){
			int digit = (arr[i]/exp)%base;
			count[digit]++;
		}
		for(int i = 1;i < base;i++){
			count[i] += count[i-1];
		}
		for(int i= n-1;i >= 0;i--){
			int digit = (arr[i]/exp)%base;
			output[count[digit]-1] = arr[i];
			count[digit]--;
		}
		System.arraycopy(output,0,arr,0,n);
	}
	private static int getMax(int[] arr){
		int max = arr[0];
		for(int value : arr){
			if(value > max){
				max = value;
			}
		}
		return max;
	}

}