public class StackTestDrive{
public static void main(String args[]){
StackX stack = new StackX(10);
stack.push(20);
stack.push(30);
stack.push(40);
stack.push(50);
stack.push(60);
stack.push(70);
stack.push(80);
stack.push(90);
stack.push(10);
stack.push(1);
System.out.println(stack.peek());
stack.push(12);
while(!stack.isEmpty()){
	long value = stack.pop();
	System.out.print(value+" ");
	
}
System.out.println();

}
}
class StackX{
private int maxSize;
private long[] stackArray;
private int top;

    public StackX(int s){
       maxSize = s;
	   stackArray = new long[maxSize];
	   top = -1;
	}		
	public void push(long j){
		if(!isFull()){
		stackArray[++top] = j;
		}else{
			System.out.println("Can't push Stack is Full ");
		}
	}
	public long pop(){
		return stackArray[top--];
	}
	public long peek(){
		return stackArray[top];
	}
	public boolean isEmpty(){
		return (top == -1);
	}
	public boolean isFull(){
		return (top == maxSize-1);
	}
}