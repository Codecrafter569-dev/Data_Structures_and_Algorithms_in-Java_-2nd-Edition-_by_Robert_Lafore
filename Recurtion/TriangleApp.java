import java.util.Scanner;
public class TriangleApp{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.print("Enter a number : ");
int n = sc.nextInt();
 n = triangle(n);
 System.out.println("triangle = "+n);
}
/*
if n = 4;  (n == numberofCall-1);
1call = 4+3
2call = 7+2
3call = 9+1 (bass case = 1);
total = 10;
*/
public static int triangle(int n){
	if(n == 1){
		return 1;
	}else{
		return (n+triangle(n-1));
		
	}
}
}