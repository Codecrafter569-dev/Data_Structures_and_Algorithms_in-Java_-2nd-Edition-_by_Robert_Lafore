public class ArraysInJavaV5{
public static void main(String args[]){
	long searchKey = 50;
LowArray arr = new LowArray(10);
arr.setElem(0,6949875l);
arr.setElem(1,10);
arr.setElem(2,20);
arr.setElem(3,30);
arr.setElem(4,40);
arr.setElem(5,50);
arr.setElem(6,60);
arr.setElem(7,70);
arr.setElem(8,80);
arr.setElem(9,90);
System.out.println(arr.getElem(1) +" "+ arr.length());
//search for element
for(int i = 0; i < arr.length();i++){
	if(arr.getElem(i) == searchKey){
		System.out.println(searchKey +" found at index :"+i);
		break;
	}
	if(i == arr.length()-1){
		System.out.println("Element not found! ");
	}
}
System.out.println("Befor deleted element");
printArray(arr.getArray());
searchKey = 410;
//deletion for element
int indexToDelete = -1;
for(int i = 0; i < arr.length();i++){
	if(arr.getElem(i) == searchKey){
		indexToDelete = i;
		break;
	}
}
if(indexToDelete != -1){
	for(int i = indexToDelete ; i < arr.length()-1;i++){
		arr.setElem(i,arr.getElem(i+1));
	}
	long[] newArray = new long[arr.length()-1];
	System.arraycopy(arr.getArray(),0,newArray,0,arr.length()-1);
	newArray = newArray;
	System.out.println("After deleted element");

	printArray(newArray);
}else{
			System.out.println("Element not found in array");
		}
}
public static void printArray(long[] arr){
	for(int i = 0; i < arr.length;i++){
		System.out.print(arr[i]+" ");
	}
	System.out.println();
}
}
class LowArray{
	long[] a;
	public LowArray(int size){
		a = new long[size];
	}
	public void setElem(int index , long element){
		a[index] = element;
	}
	public long getElem(int index){
	return	a[index];
	}
	public int length(){
		return a.length;
	}
	public long[] getArray(){
		return a;
	}
}