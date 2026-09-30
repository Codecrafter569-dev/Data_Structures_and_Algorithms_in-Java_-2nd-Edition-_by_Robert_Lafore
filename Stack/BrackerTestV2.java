
import java.util.Scanner;
public class BrackerTestV2{
public static void main(String args[]){
String input;

Scanner sc = new Scanner(System.in);

System.out.print("Enter string containing delimiters: ");
input = sc.nextLine();

if(input == ""){
	System.out.println("");
}else{
	BrackerChecker theChecker = new BrackerChecker(input);
	theChecker.check();
}
}
}
class StackB{
	private Character[] a;
	private int els;
	private int size;
	
	public StackB(int size){
		a = new Character[size];
		this.size = size;
		els = -1;
		
	}
	public void push(Character ch){
		if(isFull()){
			System.out.println("Stack is full");
		}else{
			els++;
			a[els] = ch;
		}
	}
	public Character pop(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return '\0';
		}else{
			Character ch  = a[els];
			els--;
			return ch;
		}
	}
	public boolean isEmpty(){
		if(els == -1){
			return true;
		}else{
			return false;
		}
	}
	public boolean isFull(){
		if(els == size-1){
			return true;
		}else{
			return false;
		}
	}
}
class BrackerChecker{
	private String input;
	
	public BrackerChecker(String in){
		input = in;
	}
	public void check(){
		int stackSize = input.length();
		StackB theStack = new StackB(stackSize);
		
		for(int i = 0;i<input.length();i++){
			char ch = input.charAt(i);
			switch(ch){
				case '{':
				case '[':
				case '(':
				theStack.push(ch);
				break;
				case '}':
				case ']':
				case ')':
				if(!theStack.isEmpty()){
					char chx = theStack.pop();
					
				       if((ch=='}' && chx!='{') || (ch==']' && chx!='[') || (ch==')' && chx!='(')){
						System.out.println("Error: "+ch+" at "+i);
					    }
				}else{
					System.out.println("Error: "+ch+" at "+i);
				}
				break;
				
				default:
				break;
			}
		}
		if(!theStack.isEmpty()){
			System.out.println("Error: missing right delimiter");
		}
	}
}