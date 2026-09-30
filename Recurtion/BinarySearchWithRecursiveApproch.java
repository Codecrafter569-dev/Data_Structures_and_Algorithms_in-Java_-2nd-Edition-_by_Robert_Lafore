public class BinarySearchWithRecursiveApproch{
public static void main(String args[]){
int maxSize = 100;
OrArray arr = new OrArray(maxSize);
arr.insert(72); // insert items
arr.insert(90);
arr.insert(45);
arr.insert(126);
arr.insert(54);
arr.insert(99);
arr.insert(144);
arr.insert(27);
arr.insert(135);
arr.insert(81);
arr.insert(18);
arr.insert(108);
arr.insert(9);
arr.insert(117);
arr.insert(63);
arr.insert(36);
arr.display();
int s = 36;
if(arr.find(s) != arr.size()){
	System.out.println("found "+s);
}else{
	System.out.println("can't find "+s);
}
}
}
class OrArray{
	private long[] a;
	private int nElems;
	
	public OrArray(int max){
		a = new long[max];
		nElems = 0;
	}
	public int size(){
		return nElems;
	}
	public int find(long searckKey){
		return recFind(searckKey,0,nElems-1);
	}
	private int recFind(long searckKey,int lowerBound,int upperBound){
		int curIn;
		curIn = (lowerBound+upperBound)/2;
		if(a[curIn] == searckKey){
			return curIn;
		}else if(lowerBound > upperBound){
			return nElems;
		}else{
			if(a[curIn] < searckKey){
			return recFind(searckKey,curIn+1,upperBound);	
			}else{
				return recFind(searckKey,lowerBound,curIn-1);
			}
		}
	}
	public void insert(long value){
		int j;
		for(j=0;j<nElems;j++){
			if(a[j] > value){
				break;
			}
		}
			for(int k=nElems; k>j;k--){
				a[k] = a[k-1];
				
			}
			a[j] = value;
				nElems++;

	}
	public void display(){
		for(int j=0;j<nElems;j++){
			System.out.print(a[j]+" ");
		}
		System.out.println("");
	}
}