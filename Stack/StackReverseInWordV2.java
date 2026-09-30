import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class StackReverseInWordV2{
public static void main(String args[]){
String input = "";
String output = "";
while(true){
System.out.flush();
try{
input = getString(); 
}catch(IOException e){
	System.out.println(e);
}
if(input.equals("")){
break;
}	
Reverser theReverser = new Reverser(input);
output = theReverser.doRev();
System.out.println("Reverser: "+output);
}
}
public static String getString() throws IOException{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader irs = new BufferedReader(isr);
	String s = irs.readLine();
	return s;
}
}
class StackY{
private int maxSize;
private char[] stackArray;
private int top;

public StackY(int maxSize){
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
class Reverser{
	private String input;
	private String output;
	
	public Reverser(String in){
		input = in;
	}
	public String doRev(){
		int stackSize = input.length();
		StackY theStack = new StackY(stackSize);
		for(int i = 0;i <input.length();i++){
			char ch = input.charAt(i);
			theStack.push(ch);
		}
		output = "";
		while(!theStack.isEmpty()){
			char ch = theStack.pop();
			output = output+ch;
			
		}
		return output;
	}
	
}