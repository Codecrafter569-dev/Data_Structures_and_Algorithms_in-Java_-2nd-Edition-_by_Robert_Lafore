public class QueuesTestDrive{

public static void main(String args[]){
Queues qu = new Queues(10);

qu.insert(50);
qu.insert(60);
qu.insert(70);
qu.insert(80);
qu.insert(90);
qu.insert(100);
qu.insert(110);
qu.insert(120);
qu.insert(130);
qu.insert(140);
qu.insert(1231);
System.out.println("Queue size: "+qu.size());


System.out.println("Queue size: "+qu.size());
while(!qu.isEmpty()){
	long n = qu.remove();
	System.out.print(n+" ");
	
}
System.out.println();

}
}
class Queues{
	private int maxSize;
	private long[] queuseArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queues(int s){
		maxSize = s;
		queuseArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	public void insert(long j){
		if(rear == maxSize-1){
			rear = -1;
		}
		if(isFull()){
			System.out.println("Queues is full you can't insert any item");
		}else{
			queuseArray[++rear] = j;
		    nItems++;
		}
	}
	public long remove(){
		long temp = queuseArray[front++];
		if(front == maxSize){
			front = 0;
		}
		if(isEmpty()){
			System.out.println("Queue is Empty you can't remove any thing");
		}else{
		nItems--;
		}
		return temp;
	}
	public long peekFront(){
		return queuseArray[front];
	}
	public boolean isEmpty(){
		return (nItems == 0);
	}
	public boolean isFull(){
		return (nItems == maxSize);
	}
	public int size(){
		return nItems;
	}
}