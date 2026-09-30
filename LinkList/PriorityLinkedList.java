public class PriorityLinkedList{
       public static void main(String args[]){
	   PriorityQueues pq = new PriorityQueues();
	   pq.insert(10);
	   pq.insert(2);
	   pq.insert(30);
	   pq.insert(56);
	   pq.insert(56);
	   pq.insert(22);
	   pq.insert(1);
	   pq.display();
	   pq.delete();
	   pq.delete();
	   pq.display();
	   pq.insert(2);
	   pq.insert(99);
	   pq.display();
   
	   }

}
class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
	
}
class SortedLinkedList{
	Node start;
	
	public SortedLinkedList(){
		start = null;
	}
	public void insert(int data){
		Node newNode = new Node(data);
		
		Node p,p1;
		p = p1 = start;
		if(start == null){
			start = newNode;
		}else{
			while(p != null && data > p.data){
				p1 = p;
				p = p.next;
			}
			if(p == null){
				p1.next = newNode;
			}else if(p1 == p){
				newNode.next = p;
				start = newNode;
			}else{
				newNode.next = p;
				p1.next = newNode;
			}
		}
		
	}
	public int delete(){
		int temp;
		Node p = start;
		temp = p.data;
		start = p.next;
		p.next = null;
		return temp;
		
	}
	public void display(){
		Node n = start;
		
		while(n != null){
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println();
		
	}
}
class PriorityQueues{
	SortedLinkedList sortList;
	
	public PriorityQueues(){
		sortList = new SortedLinkedList();
	}
	public void insert(int data){
		sortList.insert(data);
	}
	public int delete(){
		return sortList.delete();
	}
	public void display(){
		sortList.display();
	}
}
