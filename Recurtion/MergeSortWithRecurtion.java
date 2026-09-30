public class MergeSortWithRecurtion{
public static void main(String args[]){
int maxSize = 100;
DArray arr = new DArray(maxSize);
arr.insert(23);
arr.insert(45);
arr.insert(56);
arr.insert(5);
arr.insert(90);
arr.insert(23);
arr.insert(34);
arr.insert(35);
arr.insert(58);
arr.display();
arr.mergeSort();
arr.display();
}
}
class DArray{
	private long[] theArray;
	private int nElems;
	
	public DArray(int max){
		theArray = new long[max];
		nElems = 0;
	}
	public void insert(long value){
		theArray[nElems] = value;
		nElems++;
	}
	public void display(){
		for(int i =0;i<nElems;i++){
			System.out.print(theArray[i]+ " ");
		}
		System.out.println("");
	}
	public void mergeSort(){
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace,0,nElems-1);
	}
	private void recMergeSort(long[] workSpace,int lowerBound,int upperBound){
		if(lowerBound == upperBound){
			return;
		}else{
			int mid = (lowerBound+upperBound)/2;
			recMergeSort(workSpace,lowerBound,mid);
			recMergeSort(workSpace,mid+1,upperBound);
			merge(workSpace,lowerBound,mid+1,upperBound);
		}
	}
	private void merge(long[] workSpace,int lowPrt,int highPtr,int upperBound){
		int j = 0;
		int lowerBound = lowPrt;
		int mid = highPtr-1;
		int n = upperBound-lowerBound+1;
		
		while(lowPrt <= mid && highPtr <= upperBound){
			if(theArray[lowPrt] < theArray[highPtr]){
				workSpace[j++] = theArray[lowPrt++];
			}else{
				workSpace[j++] = theArray[highPtr++];
			}
		}
		while(lowPrt <= mid){
			workSpace[j++] = theArray[lowPrt++];
		}
		while(highPtr <= upperBound){
			workSpace[j++] = theArray[highPtr++];
		}
		for(j=0;j<n;j++){
			theArray[lowerBound+j] = workSpace[j];
		}
	}
}