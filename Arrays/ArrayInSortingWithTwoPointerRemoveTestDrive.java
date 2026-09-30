public class ArrayInSortingWithTwoPointerRemoveTestDrive{
public static void main(String args[]){
ArrayInSortinRemove arr = new ArrayInSortinRemove(10);
arr.insert(1);
arr.insert(7);
arr.insert(1);
arr.insert(7);
arr.insert(6);
arr.insert(4);
arr.insert(5);
arr.insert(5);
arr.insert(4);
arr.insert(6);
System.out.println("After sorting ");
arr.insertionSort();
arr.dispalay();

System.out.println("After removing duplicates:");
arr.noDups();
arr.dispalay();
}
}
class ArrayInSortinRemove{
	private long[] a;
	private int nElemes;
	
	public ArrayInSortinRemove(int size){
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
	public void noDups(){
		if(nElemes == 0){
			return;
		}
		int uniqueIndex = 0;
		for(int i = 1; i <nElemes; i++){
			if(a[i] != a[uniqueIndex]){
				uniqueIndex++;
				a[uniqueIndex] = a[i];
			}
		}
		nElemes = uniqueIndex+1;
	}
}
