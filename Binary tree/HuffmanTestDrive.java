import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Map.Entry;
public class HuffmanTestDrive{
	public static Map<Character,Integer>  buildFrequencyTable(String text){
	Map<Character , Integer> freq = new HashMap<>();
        for(char ch : text.toCharArray()){
           freq.put(ch , freq.getOrDefault(ch,0)+1);
	    }		
	return freq;	
	}
	public static HuffmanNode buildHuffmanTree(Map<Character,Integer> freq){
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
		for(Entry<Character,Integer> entry : freq.entrySet()){
			pq.add(new HuffmanNode(entry.getKey(),entry.getValue()));
		}
		while(pq.size() > 1){
			HuffmanNode node1 = pq.poll();
			HuffmanNode node2 = pq.poll();
			HuffmanNode combined = new HuffmanNode(node1.freq+node2.freq,node1,node2);
			pq.add(combined);
			
		}
		return pq.poll();
	}
	public static void buildCodeTable(HuffmanNode root ,String code , Map<Character,String> codeTable){
		if(root == null){
			return;
		}
		if(root.isLeaf()){
			codeTable.put(root.ch,code);
			
		}else{
		    buildCodeTable(root.left,code+"0",codeTable);
            buildCodeTable(root.right,code+"1",codeTable);			
		}
		
	}
	public static String encode(String text , Map<Character , String> codeTable){
		StringBuilder encoded = new StringBuilder();
		for(char ch : text.toCharArray()){
			encoded.append(codeTable.get(ch));
	    }
		return encoded.toString();
	}
	public static String decode(String encoded , HuffmanNode root){
		StringBuilder decoded = new StringBuilder();
		HuffmanNode current = root;
		for(int i = 0; i < encoded.length();i++){
			char bit = encoded.charAt(i);
			if(bit == '0'){
				current = current.left;
			}else if(bit == '1'){
				current = current.right;
			}
			if(current.isLeaf()){
				decoded.append(current.ch);
				current = root;
			}
		}
		return decoded.toString();
	}
	public static void displayTree(HuffmanNode node , int level){
		if(node == null){
			return;
		}
		displayTree(node.right,level+1);
		for(int i = 0; i<level;i++){
			System.out.print("   ");
		}
		if(node.isLeaf()){
			System.out.println("'"+node.ch+"' ("+node.freq+")");
		}else{
			System.out.println("* ("+node.freq+")");
		}
		displayTree(node.left,level+1);
	}
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.println("Enter a text message (multiple lines; end input with an empty line):");
StringBuilder inputTextBuilder = new StringBuilder();

while(true){
	String line = sc.nextLine();
	if(line.isEmpty()){
		break;
	}
	inputTextBuilder.append(line).append("\n");
}
String message = inputTextBuilder.toString().trim();
if(message.isEmpty()){
	System.out.println("NO message entered.");
	return;
}
Map<Character ,Integer> frequencyTable = buildFrequencyTable(message);

HuffmanNode root = buildHuffmanTree(frequencyTable);
Map<Character , String> codeTable = new HashMap<>();
buildCodeTable(root, "",codeTable);

System.out.println("\nHuffman Code Table:");
for(Entry<Character,String> entry : codeTable.entrySet()){
	System.out.println("'"+entry.getKey()+"': "+entry.getValue());
}

String encodedMessage = encode(message,codeTable);
System.out.println("\nEncoded Message:");
System.out.println(encodedMessage);


String decodedMessage = decode(encodedMessage,root);
System.out.println("\nDecoded Message:");
System.out.println(decodedMessage);

if(message.length() < 50){
	System.out.println("\nHuffman Tree (sideways display):");
	displayTree(root,0);
}
}
}
class HuffmanNode implements Comparable<HuffmanNode>{
	char ch;
	int freq;
	HuffmanNode left ,right;
	
	public HuffmanNode(char ch , int freq){
		this.ch = ch;
		this.freq = freq;
         left = right = null;
	}
	public HuffmanNode(int freq ,HuffmanNode left , HuffmanNode right){
		this.ch = '\0';
		this.freq = freq;
		this.left = left;
		this.right = right;
	}
	public int compareTo(HuffmanNode node){
		return this.freq - node.freq;
	}
	public boolean isLeaf(){
		return left == null && right == null;
	}
}