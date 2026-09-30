public class RecursivePower{
public static void main(String args[]){
System.out.println("2^10 = " + power(2, 10));    // Expected 1024
        System.out.println("3^5  = " + power(3, 5));     // Expected 243
        System.out.println("5^0  = " + power(5, 0));     // Expected 1
        System.out.println("2^-3 = " + power(2, -3));    // Expected 0.125
}
public static double power(double base , int exponent){
	if(exponent == 0){
		return 1;
	}
	if(exponent < 0){
		return 1 / power(base,-exponent);
	}
	if(exponent % 2 == 0){
		double halfPower = power(base , exponent/2);
		return halfPower * halfPower;
	}else{
		return base*power(base,exponent-1);
	}
}
}