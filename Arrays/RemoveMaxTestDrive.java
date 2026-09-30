public class RemoveMaxTestDrive{
public static void main(String args[]){
NormalArray a = new NormalArray(10);
a.insert(34);
a.insert(45);
a.insert(332);
a.insert(90);
a.insert(1);
a.insert(2);
a.insert(3);
a.insert(4);
a.insert(5);
a.insert(6);


System.out.println("Maximum value in the array: " + a.getMax());

int removedMax = a.removeMax();
        System.out.println("Removed maximum value: " + removedMax);
		
System.out.println("Array after removing the maximum value:");
a.display();
NormalArray emptyArray = new NormalArray(5);
        System.out.println("Attempting removeMax() on an empty array: " + emptyArray.removeMax());
    

}
}
class NormalArray{
	private int[] arr;
	private int nElems;
	
	
	public NormalArray(int size){
		arr = new int[size];
		nElems = 0;
	}
	public void insert(int value){
		if(nElems < arr.length){
			arr[nElems++] = value;
		}else{
			System.out.println("Array is full.Cannot insert "+value);
		}
	}
	public void display(){
		for(int i = 0; i < nElems;i++){
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
	}
	public int getMax(){
		if(nElems == 0){
			return -1;
		}
		int max = arr[0];
		for(int i = 1;i <nElems;i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		return max;
	}
	public int removeMax(){
		if(nElems == 0){
			return -1;
		}
		int maxIndex = 0;
        int maxValue = arr[0];
        for (int i = 1; i < nElems; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
		for(int i = maxIndex;i < nElems-1;i++){
		   arr[i] = arr[i+1];	
		}
		nElems--;
		return maxValue;
		
		
	}
}