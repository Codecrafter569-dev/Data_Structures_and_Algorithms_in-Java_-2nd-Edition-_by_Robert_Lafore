import java.util.Scanner;
public class NumberPower{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.println("Enter a number Like this (56^5) = 550731776 : ");
int x = sc.nextInt();
int y = sc.nextInt();
System.out.println(x+"^"+y+" = "+power(x,y));
}
public static int power(int x , int y){
	if(y == 0){
		return 1;
	}else if(y == 1){
		return x;
	}else{
		int a = power(x*x,y /2);
		if(y % 2 == 1){
			a *= x;
		}
		return a;
	}
}
}