import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BrackersCheckTestDrive{
public static void main(String args[]){
String input = "";
while(true)
{
System.out.print(
"Enter string containing delimiters: ");
System.out.flush();
try{
input = getString();
}catch(IOException e){
	System.out.println(e);
}
if(input.equals("")){
	break;
}
BrackerChecker theChecker = new BrackerChecker(input);
theChecker.check();
}
}
public static String getString() throws IOException
{
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
String s = br.readLine();
return s;
}

}
class StackZ{
private int maxSize;
private char[] stackArray;
private int top;
public StackZ(int maxSize){
this.maxSize = maxSize;
stackArray = new char[maxSize];
top  = -1;
}	
public void push(char j){
	stackArray[++top] = j;
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
class BrackerChecker{
	private String input;
	private int printCount = 0;
	public BrackerChecker(String input){
		this.input = input;
	}
	public void check(){
		int stackSize = input.length();
		StackZ theStack = new StackZ(stackSize);
		
		for(int j = 0; j < input.length();j++){
			char ch = input.charAt(j);
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
				    if((ch=='}' && chx!='{') ||(ch==']' && chx!='[') ||(ch== ')' && chx != '(')){
						System.out.println("Error: "+ch+" at "+j);
					}
				}else{
						System.out.println("Error: "+ch+" at "+j);
						break;
					}
				default:
				if(printCount == 0){
				System.out.println("You enter this code : "+input+" true");
				printCount++;
				}
					break;
			}
		}
		if(!theStack.isEmpty()){
		System.out.println("Error: missing right delimiter");
	}
	}
	
}