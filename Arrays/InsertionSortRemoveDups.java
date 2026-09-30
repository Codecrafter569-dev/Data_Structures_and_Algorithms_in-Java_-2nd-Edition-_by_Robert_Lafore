public class InsertionSortRemoveDups {
public static void main(String args[]){
int[] data = {5,3,7,3,2,7,9,5,1,2};
System.out.println("Original array:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();

RemoveDups sorter = new RemoveDups(data);
sorter.insertionSortRemoveDups();

System.out.println("Array after insertion sort with duplicate removal.");
sorter.dispaly();
}
}
class RemoveDups{
	private int[] a;
	private int nElems;
	
	public RemoveDups(int[] array){
		a = array;
		nElems = array.length;
	}
	public void insertionSortRemoveDups(){
		
		for(int i  = 1;i < nElems;i++){
			int key = a[i];
			int j = i;
			boolean duplicateFound = false;
			
			while(j > 0){
				
				if(a[j- 1] > key){
					a[j] = a[j-1];
					j--;
				}else if(a[j-1] == key){
					duplicateFound = true;
					break;
				}else{
					break;
				}
			}
			if(duplicateFound){
				key = -1;
			}
			a[j] = key;
			
			
		}
		int dupCount = 0;
		while(dupCount < nElems && a[dupCount] == -1){
			dupCount++;
		}
		int newLength = nElems-dupCount;
		for(int k = 0; k < newLength; k++){
			a[k] = a[k+dupCount];
		}
		nElems = newLength;
	}
	public void dispaly(){
		for(int i = 0; i < nElems;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}