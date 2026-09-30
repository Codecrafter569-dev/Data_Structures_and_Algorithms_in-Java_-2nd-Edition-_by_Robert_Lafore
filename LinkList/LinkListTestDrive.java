public class LinkListTestDrive{
public static void main(String args[]){
LinkList firstList = new LinkList();
firstList.insertFirst("Vikash kumar",14);
firstList.insertFirst("Shahile kumar",13);
firstList.insertFirst("Yesh Kumar ",15);
firstList.insertFirst("Lucky Kumar ",15);
firstList.insertFirst("Anomal Kumar ",13);
firstList.displayList();
 Link aLink1 =  firstList.deleteSecond();
 System.out.print("This is a second link and this is deleted : ");
 aLink1.displayLink();
while(!firstList.isEmpty()){
Link aLink = firstList.deleteFirst();
System.out.print(" Deleted ");
aLink.displayLink();
System.out.println();
}

}
}
class Link{
	public String name;
	public int age;
	public Link next;
	public Link(String name,int age){
		this.name = name;
		this.age = age;
	}
	public void displayLink(){
		System.out.print("{ "+name+", "+age+" }");
	}
	
}
class LinkList{
	private Link first;
	
	
	public LinkList(){
		first = null;
	}
	public void insertFirst(String name,int age){
		Link newLink = new Link(name,age);
		newLink.next = first;
		first = newLink;
		
	}
	public boolean isEmpty(){
		return (first == null);
	}
	public Link deleteFirst(){
		if(!isEmpty()){
		Link temp = first;
		first = first.next;
		return temp;
		}else{
			System.out.println("LinkList is Empty :");
			return null;
		}
	}
	public Link deleteSecond(){
		if(first.next != null){
		Link temp = first.next;
		first.next = first.next.next;
		return temp;
		}else{
			System.out.println("second link not avalebe :");
			return null;
		}
	}
	public void displayList(){
		System.out.print("List (first-->last): ");
		Link current = first;
		while(current != null){
			current.displayLink();
			current  = current.next;
		}
		System.out.println("");
	}
	
}