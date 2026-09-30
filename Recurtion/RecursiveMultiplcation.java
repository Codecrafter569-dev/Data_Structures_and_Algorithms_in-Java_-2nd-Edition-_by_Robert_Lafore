public class RecursiveMultiplcation{
public static void main(String args[]){
int x = 5;
int y = 6;
int result = mult(x,y);
System.out.println(x+ " * "+y+" = "+result);
}
public static int mult(int x ,int y){
	//base case : if y is 0 , the result is 0.
	if(y == 0){
		return 0;
	}
	System.out.println("Renturn the value is X :"+x+" and Y : "+y);
	return x+ mult(x,y-1);
}
}