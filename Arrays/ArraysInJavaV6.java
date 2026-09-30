public class ArraysInJavaV6{
public static void main(String args[]){
HighArray a = new HighArray(10);
a.insert(5634);
a.insert(9876);
a.insert(2145);
a.insert(142);
a.insert(903);
a.insert(98353);
a.insert(13783);
a.insert(89540);
a.insert(234);
 boolean  find = a.find(9);
 System.out.println(find +"\n Before delete elements :");
a.display();
a.delete(5634);
a.delete(903);
a.delete(234);
System.out.println("After delete elements");
a.display();

HighArray a1 = new HighArray(10);
a1.display();
}
}
class HighArray{
private	long[] a;
private int nElems;
	public HighArray(int size){
	  a = new long[size];
	  nElems = 0;
	}
	public boolean find(long searchKey){
		int i ;
		for(i = 0; i < a.length; i++){
			if(a[i] == searchKey){
				return true;
			}	
			
		}
			return false;
	}
	public void insert(long value){
		a[nElems] = value;
		nElems++;
	}
	public boolean delete(long value){
		int indexToDelete = -1;
		for(int j = 0; j < a.length;j++){
			if(value == a[j]){
				indexToDelete = j;
				break;
			}
		}
		if(indexToDelete != -1){
			for(int k=indexToDelete; k < a.length-1;k++){
				a[k] = a[k+1];
			}
			long[] newArray = new long[a.length-1];
			System.arraycopy(a,0,newArray,0,a.length-1);
			a = newArray;
			return true;
		}else{
			return false;
		}
		
	}
	public void display(){
		for(int i = 0; i < a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}