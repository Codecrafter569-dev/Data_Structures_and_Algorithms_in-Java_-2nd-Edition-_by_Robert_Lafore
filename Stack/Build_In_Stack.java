import java.util.Stack;
public class Build_In_Stack{
public static void main(String args[]){
new Build_In_Stack().go();
}
public void go(){
	Stack<Integer> stack = new Stack<>();
	
	stack.push(10);
	stack.push(20);
	stack.push(30);
	stack.push(40);
	stack.push(50);
	System.out.println("Stack after pushes: "+stack);
	System.out.println("Top stack "+stack.pop());//this principle called //Last-In-First-out(LIFO).
	System.out.println("Stack after removing Top :"+stack);
	
	System.out.println("Is stack empty? "+stack.empty());
}
}