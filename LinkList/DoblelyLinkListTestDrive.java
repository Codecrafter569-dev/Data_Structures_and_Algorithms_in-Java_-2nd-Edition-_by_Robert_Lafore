public class DoblelyLinkListTestDrive{
public static void main(String[] args){
DoublyLinkList list = new DoublyLinkList();
list.insertFirst(12);
list.insertFirst(34);
list.insertFirst(10);
list.insertLast(20);
list.insertLast(30);
list.insertLast(40);
list.displayBackward();
list.displayForward();
list.deleteFist();
list.deleteLast();
list.displayForward();
list.insertAfter(20,78);
list.insertAfter(78,99);
list.displayForward();
list.displayBackward();
list.deleteKey(78);
list.deleteKey(99);
list.displayForward();
}
}
class Link{
	public long dData;
	public Link next;
	public Link previous;
	
	public Link(long d){
		dData = d;
	}
	public void displayLink(){
		System.out.println(dData+" ");
	}
	
}
class DoublyLinkList{
	private Link first;
	private Link last;
	
	public DoublyLinkList(){
		first = null;
		last = null;
	}
	public boolean isEmpty(){
		return (first == null);
	}
	public void insertFirst(long dd){
		Link newLink = new Link(dd);
		if(isEmpty()){
			last = newLink;
		}else{
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	public void insertLast(long dd){
		Link newLink = new Link(dd);
		if(isEmpty()){
			first = newLink;
		}else{
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
		
	}
	public Link deleteFist(){
		Link temp = first;
		if(first.next == null){
			last = null;
		}else{
			first.next.previous = null;
		}
		first  = first.next;
		return temp;
	}
	public Link deleteLast(){
		Link temp = last;
		if(first.next == null){
			first = null;
		}else{
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}
	public boolean insertAfter(long key , long dd){
		Link current = first;
		while(current.dData != key){
			current = current.next;
			if(current == null){
				return false;
			}
			
		}
			Link newLink = new Link(dd);
			if(current == last){
				newLink.next = null;
				last = newLink;
			}else{
				newLink.next = current.next;
				current.next.previous = newLink;
			}
			newLink.previous = current;
			current.next = newLink;
			return true;
		
	}
	public Link deleteKey(long key){
		Link current = first;
		while(current.dData != key){
			current = current.next;
			if(current == null){
				return null;
			}
		}
		if(current == first){
			first = current.next;
		}else{
			current.previous.next = current.next;
		}
		if(current==last){
			last = current.previous;
		}else{
			current.next.previous = current.previous;
		}
		return current;
		
	}
	public void displayForward(){
		System.out.println("List (first-->last): ");
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	public void displayBackward(){
		System.out.println("List (last-->first) : ");
		Link current = last;
		while(current != null){
			current.displayLink();
			current = current.previous;
		}
		System.out.println();
	}
	
}