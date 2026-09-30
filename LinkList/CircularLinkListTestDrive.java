public class CircularLinkListTestDrive{
public static void main(String args[]){
CircularLinkList cll = new CircularLinkList();
cll.insert(110);
cll.insert(20);
cll.insert(30);
cll.insert(40);
cll.insert(50);
cll.display();
cll.delete();
cll.delete();
cll.delete();
cll.display();
cll.find(110);
cll.find(30);
}

}
class Node {
	int data;
	Node link;

	Node(int data) {
		this.data = data;
		this.link = null;
	}
}
class CircularLinkList{
	private Node current;
	
	public CircularLinkList(){
		current = null;
	}
	public void insert(int data){
		Node newNode = new Node(data);
		
		if(current == null){
			newNode.link = newNode;
			current = newNode;
		}else{
			newNode.link = current.link;
			current.link = newNode;
			current = newNode;
		}
	}
	public void delete(){
		Node p = current;
		
		if(p.link == current){
			current = null;
		}else{
			do{
				p = p.link;
			}while(p.link != current);
			p.link = current.link;
			current = p;
		}
	}
	public void find(int data){
		boolean found = false;
		int temp = 0;
		Node p = current;
		
		do{
			p = p.link;
			if(data == p.data){
				temp = p.data;
				found = true;
				break;
			}
		}while(p != current);
		if(found){
			System.out.println("Found : "+temp);
		}else{
			System.out.println("Not found");
		}
	}
	public void display(){
		Node p = current;
		
		if(current != null){
			do{
				p = p.link;
				System.out.print(p.data + " ");
			}while(p != current);
			System.out.println();
		}else{
			System.out.println("List is Empty");
		}
		
	}
}