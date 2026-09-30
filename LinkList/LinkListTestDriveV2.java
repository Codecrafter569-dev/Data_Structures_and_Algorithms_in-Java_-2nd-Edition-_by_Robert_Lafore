public class LinkListTestDriveV2{
public static void main(String args[]){
LinkList aList = new LinkList();
aList.inserFirst("Vikash Kumar",14);
aList.inserFirst("Ajay Paswan",55);
aList.inserFirst("Sunita devi",48);
aList.inserFirst("Suman Kumari",12);
aList.inserFirst("Parwati Devi",63);
aList.inserFirst("Deepak Paswan",30);
aList.inserFirst("Randeo Paswan",67);
aList.displayList();

Link findRam  = aList.find(63);
System.out.print("I have found You ");
findRam.displayLink();
Link deleteAjay = aList.delete(55);
System.out.print("I have deleted this Person ");
deleteAjay.displayLink();

System.out.println("After deleting ");
aList.displayList();
}
}
class Link{
	public String name;
	public int age;
	public Link next;
	
	public Link(String name,int age){
		this.name = name;
		this.age  = age;
	}
	public void displayLink(){
		System.out.println("("+name+" ,"+age+")");
	}
}
class LinkList{
	private Link first;
	
	public LinkList(){
		first = null;
	}
	public void inserFirst(String name,int age){
		Link newLink = new Link(name,age);
		newLink.next = first;
		first = newLink;
	}
	public Link find(int key){
		Link current = first;
		while(current.age != key){
			if(current.next == null){
				return null;
			}else{
				current = current.next;
			}
			
		}
		return current;
	}
	public Link delete(int key){
		Link current = first;
		Link previous = first;
		
		while(current.age != key){
			if(current.next == null){
				return null;
			}else{
				previous = current;
				current = current.next;
			}
		}
		if(current == first){
			first = first.next;
		}else{
			previous.next = current.next;
		}
		return current;
	}
	public void displayList(){
		System.out.println("List (first--> last: ");
		Link current = first;
		while(current != null){
			current.displayLink();
			current =current.next;
		}
		System.out.println("");
	}
}