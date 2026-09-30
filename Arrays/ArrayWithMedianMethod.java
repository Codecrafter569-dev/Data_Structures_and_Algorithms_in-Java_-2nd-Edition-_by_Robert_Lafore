import java.util.Arrays;
import java.util.NoSuchElementException;


public class ArrayWithMedianMethod{
public static void main(String args[]){
ArrayWithMedian arr = new ArrayWithMedian(10);
arr.a = new int[]{2,12,16,8,10,14};
arr.nElemes = arr.a.length;

System.out.println("Median Value "+arr.median());
}
}



class ArrayWithMedian{
	 int[] a;
	 int nElemes;
	
	public ArrayWithMedian(int size){
		a = new int[size];
		nElemes = 0;
	}
	public void insert(int value){
		a[nElemes] = value;
		nElemes++;
	}
	public void dispalay(){
		for(int i = 0;i < nElemes;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
	}
	public double median(){
		if(nElemes == 0){
			throw new NoSuchElementException("Array is empty");
		}
		int[] temp = new int[nElemes];
		for(int i = 0;i < nElemes;i++){
			temp[i] = a[i];
		}
		Arrays.sort(temp);
		if(nElemes % 2 != 0){
			return temp[nElemes/2];
		}else{
			int mid1 = temp[(nElemes-1)/2];
			int mid2  = temp[(nElemes/2)/2];
			return (mid1+mid2)/2.0;
		}
	}
}