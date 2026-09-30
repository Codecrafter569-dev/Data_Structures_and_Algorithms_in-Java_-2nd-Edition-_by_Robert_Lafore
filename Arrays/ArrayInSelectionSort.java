public class ArrayInSelectionSort{

public static void main(String args[]){
	int maxSize = 10000;
ArrayInSelection arr = new ArrayInSelection(maxSize);
for(int j=0; j<maxSize; j++) // fill array with
{ // random numbers
long n = (long)( java.lang.Math.random()*(maxSize-1) );
arr.insert(n);
}
System.out.println("Before sorting : ");
arr.dispalay();
arr.selectionSort();
System.out.println("After sorting : ");
arr.dispalay();

}
}
class ArrayInSelection{
	private long[] a;
	private int nElemes;
	
	public ArrayInSelection(int size){
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
	public void selectionSort()
{
int i, j, min;
for(i=0; i<nElemes-1; i++) {
min = i; // minimum
for(j=i+1; j<nElemes; j++) {
if(a[j] < a[min] ) {
min = j;
}
}// swap them
long temp = a[i];
a[i] = a[min];
a[min] = temp;
} // end for(out)
// end selectionSort()
//--------------------------------------------------------------
}
}