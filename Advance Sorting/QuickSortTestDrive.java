import java.lang.Math;
public class QuickSortTestDrive{
public static void main(String args[]){
int max = 16;
ArrayQu arr = new ArrayQu(max);
for(int j = 0; j<max;j++){
	long n = (int) (Math.random()*99);
	arr.insert(n);
}
arr.display();
arr.quicksort();
arr.display();

}
}
class ArrayQu{
	private long[] arr;
	private int nElem;
	
	public ArrayQu(int max){
		arr = new long[max];
		nElem = 0;
	}
	public void insert(long value){
		arr[nElem] = value;
		nElem++;
	}
	public void display(){
		for(int i = 0;i <nElem;i++){
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	public int size(){
		return nElem;
	}
	public void quicksort(){
		reQuickSort(0 , nElem-1);
	}
	public void reQuickSort(int left , int right){
		if(right-left <= 0){
			return;
		}else{
			long pivot = arr[right];
			int partition = partition(left,right,pivot);
			reQuickSort(left,partition-1);
			reQuickSort(partition+1,right);
		}
	}
	public int partition(int left , int right,long pivot){
		int leftPtr = left-1;
		int rightPtr = right;
		while(true){
			while(arr[++leftPtr] < pivot);
			while(rightPtr > 0 && arr[--rightPtr] > pivot);
			
			if(leftPtr >= rightPtr){
				break;
			}else{
				long temp = arr[leftPtr];
				arr[leftPtr] = arr[rightPtr];
				arr[rightPtr] = temp;
			}
		}
		long temp = arr[leftPtr];
				arr[leftPtr] = arr[right];
				arr[right] = temp;
		return leftPtr;
		
	}

}