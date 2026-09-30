public class OddEvenSortTestDrive{
public static void main(String args[]){
	OddEvenSort sort = new OddEvenSort();
int[] arr = {5,3,8,4,2,7,1,6};

System.out.println("Before sorting: ");
sort.display(arr);
sort.oddEvenSort(arr);
System.out.println("After sorting: ");
sort.display(arr);
}
}
class OddEvenSort{
	
	
 public void oddEvenSort(int[] arr){
     boolean  sorted = false;
      while(!sorted){
	     sorted = true;
	
	       for(int j = 0; j < arr.length-1; j +=2){
			   if(arr[j] > arr[j+1]){
				   int temp = arr[j];
				   arr[j] = arr[j+1];
				   arr[j+1] = temp;
				   sorted = false;
			   }
			   
		   }
	       
		   
		   for(int j = 1;j < arr.length-1;j+= 2){
			   if(arr[j] > arr[j+1]){
				   int temp = arr[j];
				   arr[j] = arr[j+1];
				   arr[j+1] = temp;
				   sorted = false;
			   }
			   
		   }
        }
    }
	public void display(int[] arr){
		for(int num : arr){
			System.out.print(num+ " ");
		}
		System.out.println();
	}
}