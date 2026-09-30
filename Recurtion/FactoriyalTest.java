import java.util.Scanner;
public class FactoriyalTest{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.print("Enter a Number : ");
int n = sc.nextInt();
n = factoriyal(n);
System.out.println("Factoriyal = "+n);


}
public static int factoriyal(int n ){
	if(n == 0){
		return 1;
	}else{
		return(n*factoriyal(n-1));
	}
}
}