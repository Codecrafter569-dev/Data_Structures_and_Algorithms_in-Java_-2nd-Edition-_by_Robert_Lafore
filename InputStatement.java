import java.io.*;
public class InputStatement{
public static void main(String args[]){
new InputStatement().go();
}
public void go(){
	try{
		System.out.println("Inter Your Name :");
	String  name = getInput();
	System.out.println(" Hello " +name+" ,I am a DSA teacher");
	System.out.println(getChar());
	System.out.println(getDouble());
	System.out.println(getInt());
	}catch(IOException e){
		System.out.println(e);
	}
}
public  String getInput() throws IOException{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	String s = br.readLine();
	return s;
}
public  char getChar() throws IOException
{
	System.out.println("Inter Char value :");
String s = getInput();
return s.charAt(0);
}
public int getInt() throws IOException
{
	System.out.println("Inter Integer value :");
String s = getInput();
return Integer.parseInt(s);
}
public double getDouble() throws IOException
{
	System.out.println("Inter Double value :");
String s = getInput();
Double aDub = Double.valueOf(s);
return aDub.doubleValue();
}
}
