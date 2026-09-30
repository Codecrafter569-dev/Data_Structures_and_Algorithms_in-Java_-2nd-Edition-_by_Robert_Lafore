import java.util.Scanner;
public class RecursiveMultiplcationV2{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
n = previousMultipalyer(n);
System.out.println(n);
}
public static int previousMultipalyer(int n){
	if( n == 1){
		return 1;
	}
	return n * previousMultipalyer(n-1);
}
}