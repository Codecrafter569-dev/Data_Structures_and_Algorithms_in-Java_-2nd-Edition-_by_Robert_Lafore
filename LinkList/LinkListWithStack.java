public class LinkListWithStack{

  public static void main(String args[]){
  LinkStack list = new LinkStack();
  list.push(34);
  list.push(20);
  list.push(30);
  list.displayStack();
  
  list.push(44);
  list.push(78);
  list.push(90);
  list.push(100);
  list.displayStack();
  list.pop();
  list.pop();
  list.pop();
  list.displayStack();
  }
}
class Link{
	public long dDate;
	public Link next;
	
	public Link(long dd){
		dDate = dd;
	}
	public void displayLink(){
		System.out.println(dDate+" ");
	}
	
}
class LinkList{
	private Link first;
	
	public LinkList(){
		first = null;
	}
	public boolean isEmpty(){
		return (first == null);
	}
	public void insertFirst(long dd){
		Link newLink = new Link(dd);
		newLink.next = first;
		first = newLink;
	}
	public long deleteFirst(){
		Link temp  = first;
		first = first.next;
		return temp.dDate;
	}
	public void displayList(){
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	
}
class LinkStack{
	private LinkList theList;
	
	public LinkStack(){
		theList = new LinkList();
	}
	public void push(long j){
		theList.insertFirst(j);
	}
	public long pop(){
		return theList.deleteFirst();
	}
	public boolean isEmpty(){
		return (theList.isEmpty());
	}
	public void displayStack(){
		System.out.println("Stack (top--> bottom): ");
		theList.displayList();
	}
}