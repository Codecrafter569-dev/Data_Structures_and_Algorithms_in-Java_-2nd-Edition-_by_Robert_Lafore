import java.util.Scanner;
public class StackReverseInWord{
public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
StackX stack = new StackX(11);
System.out.println("Inter a Name/String value to reverse :");
String  s = sc.nextLine();
for(int i = 0;i <11;i++){
	stack.push(s.charAt(i));
}
while(!stack.isEmpty()){
	char value = stack.pop();
	System.out.print(value+" ");
	
}
System.out.println();
}
}
class StackX{
private int maxSize;
private char[] stackArray;
private int top;

    public StackX(int s){
       maxSize = s;
	   stackArray = new char[maxSize];
	   top = -1;
	}		
	public void push(char j){
		if(!isFull()){
		stackArray[++top] = j;
		}else{
			System.out.println("Can't push Stack is Full ");
		}
	}
	public char pop(){
		return stackArray[top--];
	}
	public char peek(){
		return stackArray[top];
	}
	public boolean isEmpty(){
		return (top == -1);
	}
	public boolean isFull(){
		return (top == maxSize-1);
	}
}