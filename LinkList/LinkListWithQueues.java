public class LinkListWithQueues{

public static void main(String args[]){
LinkQueue list = new LinkQueue();
list.insert(20);
list.insert(40);
list.insert(50);
list.displayQueue();
list.insert(45);
list.insert(67);
list.insert(90);
list.displayQueue();
list.remove();
list.remove();
list.displayQueue();

}
}
class Link{
	public long dDate;
	public Link next;
	
	public Link(long d){
	dDate = d;
	}
	public void displayLink(){
		System.out.println(dDate+" ");
	}
}
class FirstLastList{
	private Link first;
	private Link last;
	
	public FirstLastList(){
		first = null;
		last = null;
	}
	public boolean isEmpty(){
		return (first == null);
	}
	public void insertLast(long dd){
		Link newLink = new Link(dd);
		if(isEmpty()){
			first = newLink;
		}else{
			last.next = newLink;
		}
		last = newLink;
	}
	public long deletetFirst(){
		long temp = first.dDate;
		if(first.next ==null){
			last =null;
		}
		first = first.next;
		return temp;
	}
	public void displayList(){
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
}
class LinkQueue{
	private FirstLastList theList;
	
	public LinkQueue(){
	theList = new FirstLastList();
	}
	public boolean isEmpty(){
		return theList.isEmpty();
	}
	public void insert(long j){
		theList.insertLast(j);
	}
	public long remove(){
		return theList.deletetFirst();
	}
	public void displayQueue(){
		System.out.println("Queues (front-->rear): ");
		theList.displayList();
	}
}