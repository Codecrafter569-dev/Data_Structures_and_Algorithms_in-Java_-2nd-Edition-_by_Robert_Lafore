public class SortedLinkList{

public static void main(String args[]){
SortedList list = new SortedList();
list.insert(30);
list.insert(20);
list.insert(45);
list.insert(10);
list.insert(10);
list.insert(89);
list.insert(40);
list.displayList();
list.remove();
list.remove();
list.displayList();
}
}
class Link{
	public long dData;
	public Link next;
	
	public Link(long d){
		dData = d;
	}
	public void displayLink(){
		System.out.println(dData+" ");
	}
	
}
class SortedList{
	private Link first;
	
	public SortedList(){
		first = null;
	}
	public boolean isEmpty(){
		return (first == null);
	}
	public void insert(long key){
		Link newLink = new Link(key);
		Link previous = null;
		Link current = first;
		while(current != null && key > current.dData){
			previous = current;
			current = current.next;
			
		}
		if(previous == null){
			first = newLink;
		}else{
			previous.next = newLink;
		}
		newLink.next = current;
	}
	public Link remove(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	public void displayList(){
		System.out.println("List (first-->last): ");
		Link current = first;
		
		while(current != null){
			current.displayLink();
			current =current.next;
		}
		System.out.println();
	}
}