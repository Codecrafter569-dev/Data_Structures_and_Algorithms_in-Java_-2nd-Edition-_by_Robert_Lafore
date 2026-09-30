import java.lang.Math;
public class LinkListWithInsertionSort{

public static void main(String args[]){
int size = 10;
Link[] linkArray = new Link[size];
for(int j=0;j<size;j++){
	int n = (int)(Math.random()*99);
	Link newLink = new Link(n);
	linkArray[j] = newLink;
}
System.out.print("Unsorted Array: ");
for(int j=0;j<size;j++){
	System.out.print(linkArray[j].dData+" ");
}
System.out.println();



SortedList list = new SortedList(linkArray);

        for(int i = 0;i<size;i++){
	        linkArray[i] = list.remove();
        }
		System.out.print("Sorted Array: ");
		
		for(int i = 0; i<size; i++){
			System.out.print(linkArray[i].dData+" ");
		}
		System.out.println(" ");
}
}
class Link{
	public long dData;
	public Link next;
	
	public Link(long dd){
		dData = dd;
	}
}
class SortedList{
	private Link first;
	
	public SortedList(){
		first = null;
	}
	public SortedList(Link[] linkArr){
		first = null;
		for(int i = 0;i < linkArr.length;i++){
			insert(linkArr[i]);
		}
	}
	public void insert(Link k){
		Link previous = null;
		Link current = first;
		while(current != null && k.dData > current.dData){
			previous =current;
			current = current.next;
		}
		if(previous==null){
			first =k;
		}else{
			previous.next = k;
		}
		k.next = current;
	}
	public Link remove(){
		Link temp = first;
		first = first.next;
		return temp;
	}
}