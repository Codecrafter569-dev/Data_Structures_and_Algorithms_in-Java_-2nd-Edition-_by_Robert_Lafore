public class ArraysInBubbleSort{
public static void main(String args[]){
	int maxSize = 10000;
ArrayInBubble arr = new ArrayInBubble(maxSize);
for(int j=0; j<maxSize; j++) // fill array with
{ // random numbers
long n = (long)( java.lang.Math.random()*(maxSize-1) );
arr.insert(n);
}
System.out.println("Befor sorting:  ");
arr.display();
arr.bubbleSort();
System.out.println("After sorting: ");
arr.display();

}
}
class ArrayInBubble{
	private long[] a;
	private int nElems;
	
	public ArrayInBubble(int size){
		a = new long[size];
		nElems  = 0;
	}
	public void insert(long value){
		a[nElems] = value;
		nElems++;
	}
	public void display(){
		for(int j = 0 ; j <nElems; j++){
		System.out.print(a[j]+" ");	
		}
		System.out.println();
	}
	public void bubbleSort(){
		int out,in;
		for(out = nElems-1;out>1;out--){
			for(in=0;in<out;in++){
				if(a[in] >a[in+1]){
					swap(in,in+1);
				}
			}
			
		}
		
	}
	public void swap(int one , int two){
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}