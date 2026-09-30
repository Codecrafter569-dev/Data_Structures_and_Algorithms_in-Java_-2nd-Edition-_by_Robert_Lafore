public class MargeSortWithIteration{
public static void main(String args[]){
int[] arrayA = {12,22,32,42};
int[] arrayB = {1,2,3,4,5,6};
int[] arrayC = new int[10];
merge(arrayA,4,arrayB,6,arrayC);
display(arrayC,10);
}
public static void merge(int[] arrayA,int sizeA,int[] arrayB, int sizeB,int[] arrayC){
	int aDex = 0,bDex = 0,cDex = 0;
	while(aDex < sizeA && bDex < sizeB){
		if(arrayA[aDex] < arrayB[bDex]){
			arrayC[cDex++] = arrayA[aDex++];
		}else{
			arrayC[cDex++] = arrayB[bDex++];
		}
		
	}
	while(aDex < sizeA){
			arrayC[cDex++] = arrayA[aDex++];
		}
		while(bDex <sizeB){
			
			arrayC[cDex++] = arrayB[bDex++];
			
		}
}
public static void display(int[] a , int s){
	for(int i=0;i<s;i++){
		System.out.print(a[i]+ " ");
	}
	System.out.println("");
}
}