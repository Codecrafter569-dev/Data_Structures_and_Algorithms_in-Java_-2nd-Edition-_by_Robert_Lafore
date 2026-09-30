public class ArrayInInsertionSortTestDrive{

public static void main(String args[]){
	int maxSize = 10000;
ArrayInInsertionSort arr = new ArrayInInsertionSort(maxSize);
for(int j=0; j<maxSize; j++) // fill array with
{ // random numbers
long n = (long)( java.lang.Math.random()*(maxSize-1) );
arr.insert(n);
}
System.out.println("Before sorting : ");
arr.dispalay();
arr.insertionSort();
System.out.println("After sorting : ");
arr.dispalay();

}
}
class ArrayInInsertionSort{
	private long[] a;
	private int nElemes;
	
	public ArrayInInsertionSort(int size){
		a = new long[size];
		nElemes = 0;
	}
	public void insert(long value){
		a[nElemes] = value;
		nElemes++;
	}
	public void dispalay(){
		for(int i = 0;i < nElemes;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
	}
	public void insertionSort(){
		int in,out;
		for(out = 1;out <nElemes;out++){
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1] >= temp){
				a[in] = a[in-1];
				--in;
			}
			a[in] = temp;
		}
	}
}