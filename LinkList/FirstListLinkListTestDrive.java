public class FirstListLinkListTestDrive{
public static void main(String args[]){
LinkList list = new LinkList();
list.insertFirst("Vikash Kumar",14,"987-098-2345");
list.insertFirst("Shahile Kumar",13,"546-963-3478");
list.insertFirst("Yesh Kumar",15,"986-234-6545");
list.insertLast("Suman Kumari",12,"123-895-6641");
list.insertLast("Ramdeo Paswan",67,"620-670-2914");
list.insertLast("Parwati Devi",62,"371-294-4823");
list.dispalyList();
list.deleteFirst();
list.deleteFirst();
list.dispalyList();
}
}
class Link{
	public String name;
	public int age;
	public String number;
	public Link next;
	
	public Link(String name,int age,String number){
		this.name = name;
		this.age = age;
		this.number = number;
	}
	public void dispalyLink(){
		System.out.print("("+name+" ,"+age+" ,"+number+")");
	}
	
}
class LinkList{
	private Link first;
	private Link last;
	
	public LinkList(){
		first = null;
		last = null;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public void insertFirst(String name ,int age,String number){
		Link newLink = new Link(name,age,number);
		if(isEmpty()){
			last = newLink;
		}
		newLink.next = first;
		first  = newLink;
	}
	public void insertLast(String name,int age,String number){
		Link newLink = new Link(name,age,number);
		if(isEmpty()){
			first = newLink;
		}else{
			last.next = newLink;
		}
		last = newLink;
	}
	public Link deleteFirst(){
		Link temp = first;
		if(first.next == null){
			last = null;
		}
		first = first.next;
		return temp;
	}
	public void dispalyList(){
		System.out.println("List (first-->last): ");
		Link current = first;
		while(current != null){
			current.dispalyLink();
			current =current.next;
		}
		System.out.println("");
	}
	
}