public class PartitionTestDriveLastIndexPro{
	private int[] theArray;
	public static void main(String args[]){
     int[] sample = {23,17,3,1,2,3,4,5,6,56};
	 PartitionTestDriveLastIndexPro partitioner  = new PartitionTestDriveLastIndexPro(sample);
	 
	 System.out.println("Original arrays:");
	 partitioner.display();
	 
	 int pivotIndex = partitioner.partitionIt(0,sample.length-1);
	 System.out.println("Pivot is a index "+pivotIndex+". Array after partitioning: ");
	 partitioner.display();
    }
	public PartitionTestDriveLastIndexPro(int[] arr){
		this.theArray = arr;
	}
private void swap(int dex1,int dex2){
	int temp = theArray[dex1];
	theArray[dex1] = theArray[dex2];
	theArray[dex2] = temp;
}
public int partitionIt(int left,int right){
	if(right-left+1 <= 3){
		menualSort(left,right);
		return (left+right)/2;
	}
	int pivot = theArray[right];
	int i = left-1;
	
	for(int j = left;j<right;j++){
		if(theArray[j] <=pivot){
			i++;
			swap(i,j);
		}
	}
	swap(i+1,right);
	return i+1;
}
private void menualSort(int left,int right){
	int size = right-left+1;
	if(size <= 1){
		return;
	}
	if(size == 2){
		if(theArray[left]>theArray[right]){
			swap(left,right);
		}
		return;
	}
	if(theArray[left]> theArray[left+1]){
		swap(left,left+1);
	}
	if(theArray[left] > theArray[right]){
		swap(left,right);
	}
	if(theArray[left+1]>theArray[right]){
		swap(left+1,right);
	}
}
public void display(){
	for(int num : theArray){
		System.out.print(num+" ");
	}
	System.out.println();
}
}