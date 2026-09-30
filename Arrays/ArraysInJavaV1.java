public class ArraysInJavaV1{

public static void main(String args[]){
int[] arr;
arr = new int[10];
//this is scond Method for createing a arrays.
int[] arr1 = {67,764,644,762,06,28};
int numberOfEliments = 0;
int j;
int searchKey;

arr[0] = 56;
arr[1] = 99;
arr[2] = 12;
arr[3] = 56;
arr[4] = 83;
arr[5] = 6;
arr[6] = 47;
arr[7] = 9;
arr[8] = 00;
arr[9] = 78;
numberOfEliments = 10;

for(j = 0; j < numberOfEliments;j++){
	System.out.print(arr[j] +" ");
	
}
System.out.println();
searchKey = 6;
//Searching for elments
for(j = 0; j < numberOfEliments;j++){
	if(arr[j] == searchKey){
		System.out.println(arr[j]+" found Index : "+j);
		break;
	}if(j == numberOfEliments){
		System.out.println("Can't find "+searchKey);
	}
}

for(j = 0; j < numberOfEliments;j++){
	System.out.print(arr[j] +" ");
	
}
System.out.println();
}
}