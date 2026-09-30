public class DeQueueList{
public static void main(String args[]){
DeQueue d = new DeQueue();
d.insertFront(20);
d.insertFront(30);
d.insertEnd(40);
d.insertEnd(50);
d.display();
d.insertFront(33);
d.insertFront(56);
d.insertFront(44);
d.insertEnd(78);
d.insertEnd(67);
d.insertEnd(90);
d.display();
d.deleteFront();
d.deleteFront();
d.deleteRear();
d.deleteRear();
d.display();
}

}
class Node {
	int data;
	Node fLink;
	Node bLink;
	
	public Node(int data){
		this.data = data;
		this.fLink = this.bLink = null;
	}
	
}
class DoubleLinkList{
	private Node start;
	private Node end;
	
	public DoubleLinkList(){
		this.start = this.end = null;
	}
	public void insertBeg(int data){
		Node newNode = new Node(data);
		
		if(start == null){
			start = newNode;
			end = newNode;
		}else{
			start.bLink = newNode;
			newNode.fLink = start;
			start = newNode;
		}
	}
	public void insertEnd(int data){
		Node newNode = new Node(data);
		
		if(start == null){
			start = newNode;
			end = newNode;
		}else{
			end.fLink = newNode;
			newNode.bLink = end;
			end = newNode;
			
		}
		
	}
	public void deleteBeg(){
		if(start == null){
			System.out.println("List Empty");
		}else if(start == end){
			start = end = null;
		}else {
			Node temp = start;
			start = start.fLink;
			start.bLink = null;
			temp.fLink = null;
		}
	}
	public void deleteEnd(){
		if(start == null){
			System.out.println(" List Empty ");
		}else if(start == end){
			start = end = null;
		}else{
			Node temp = end;
			end = end.bLink;
			end.fLink = null;
			temp.bLink = null;
		}
		
	}
	public void display(){
		Node n = start;
		if(start != null){
			while(n.fLink != null){
				System.out.print(n.data+ " -> ");
				n = n.fLink;
			}
			System.out.print(n.data+ " ");
			System.out.println();
		}else{
			System.out.println("List is Empty");
		}
	}
	
}
class DeQueue{
	DoubleLinkList dll;
	
	public DeQueue(){
		dll = new DoubleLinkList();
	}
	public void insertFront(int data){
		dll.insertBeg(data);
	}
	public void insertEnd(int data){
	      dll.insertEnd(data);
	}
	public void deleteRear(){
		dll.deleteEnd();
	}
	public void deleteFront(){
		dll.deleteBeg();
	}
	public void display(){
		dll.display();
	}
}