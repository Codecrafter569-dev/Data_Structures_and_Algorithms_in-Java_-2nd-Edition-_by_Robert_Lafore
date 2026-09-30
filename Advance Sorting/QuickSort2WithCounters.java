public class QuickSort2WithCounters {
private int[] theArray;
private int nElems;
private long comparisonCount = 0;
private long copyCount = 0;
public QuickSort2WithCounters(int[] arr){
	this.theArray = arr;
	this.nElems  = arr.length;
}
private void swap(int dex1,int dex2){
	int temp = theArray[dex1];
	copyCount++;
	
	theArray[dex1] = theArray[dex2];
	copyCount++;
	
	theArray[dex2] = temp;
	copyCount++;
}
private int compare(int a,int b){
	comparisonCount++;
	return a-b;
}
public void quickSort(){
	recQuickSort(0,nElems-1);
}
private void recQuickSort(int left,int right){
	int size = right-left+1;
	if(size <= 3){
		manualSort(left,right);
	}else{
		int madian = medianOf3(left,right);
		int partition = partitionIt(left,right,madian);
		recQuickSort(left,partition-1);
		recQuickSort(partition+1,right);
	}
}
private int medianOf3(int left,int right){
	int center = (left+right)/2;
	if(compare(theArray[left],theArray[center]) > 0){
		swap(left,center);
	}
	if(compare(theArray[left],theArray[right])> 0){
		swap(left,right);
	}
	if(compare(theArray[center],theArray[right]) > 0){
		swap(center,right);
	}
	swap(center,right-1);
	return theArray[right-1];
}
private int partitionIt(int left,int right,int pivot){
	int leftPtr = left;
	int rightPtr = right-1;
	
	while(true){
		while(compare(theArray[++leftPtr],pivot) < 0);
		while(compare(theArray[--rightPtr],pivot) > 0);
		if(leftPtr >= rightPtr){
			break;
		}else{
			swap(leftPtr,rightPtr);
		}
		
	}
	swap(leftPtr,right-1);
	return leftPtr;
}
private void manualSort(int left,int right){
	int size = right-left+1;
	if(size <= 1){
		return;
	}
	if(size == 2){
		if(compare(theArray[left],theArray[right]) > 0 ){
			swap(left,right);
		}
		return;
	}else{
		if(compare(theArray[left],theArray[left+1]) > 0){
			swap(left,left+1);
		}
		if(compare(theArray[left],theArray[right])>0){
			swap(left,right);
		}
		if(compare(theArray[left+1],theArray[right]) > 0){
			swap(left+1,right);
		}
	}
}
public void display(){
	for(int j : theArray){
		System.out.print(j+" ");
	}
	System.out.println();
}
public void displayCounters(){
	System.out.println("total comparisons : "+comparisonCount);
	System.out.println("total copies (assignment operatios): "+copyCount);
}
public static void main(String args[]){
int size = 10;
int[] array = new int[size];
for(int i=0;i<size;i++){
	array[i] =size-i;
}
System.out.print("Original Array: ");
for(int value : array){
	System.out.print(value+" ");
}
System.out.println("\n");
QuickSort2WithCounters sorter = new QuickSort2WithCounters(array);
sorter.quickSort();
System.out.print("Sorted Array :");
sorter.display();
sorter.displayCounters();
}
}