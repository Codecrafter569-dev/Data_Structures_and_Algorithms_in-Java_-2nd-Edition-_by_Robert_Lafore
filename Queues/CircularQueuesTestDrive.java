public class CircularQueuesTestDrive{
public static void main(String args[]){
CirQueues q = new CirQueues(5);
q.insert(10);
q.insert(20);
q.insert(30);
q.insert(40);
q.insert(50);
q.display();


q.delete(); //10
		q.display();

		q.delete(); //20
		q.display();

		q.delete(); //30
		q.display();

		q.delete(); //40
		q.delete();

		q.insert(60);
		q.insert(70);
		q.insert(80);
		q.delete();
		q.display();
}
}
class CirQueues{
	private int max,rear,front;
	private int[] a;
	
	public CirQueues(int m){
		max = m;
		a = new int[m];
		rear = front = -1;
	}
	public void insert(int val){
		if(isFull()){
			System.out.println("overflow");
		}else{
			if(isEmpty()){
				front = rear = 0;
				a[rear] = val;
			}else{
				rear = (rear+1)%max;
				a[rear] = val;
			}
		}
	}
	public void display(){
		int i;
		for(i = front;i!= rear;i=(i+1)%max){
			System.out.print(a[i]+" ");
		}
		System.out.print(a[i]+" ");
		System.out.println();
	}
	public boolean isFull(){
		if(front == (rear+1)%max){
			return true;
		}else{
			return false;
		}
	}
	public boolean isEmpty(){
		if(rear == -1){
			return true;
		}else{
			return false;
		}
	}
	public int delete(){
		if(isEmpty()){
			System.out.println("Underflow");
			return -1;
		}else{
			int temp = a[front];
			if(rear==front){
				rear=-1;
				front=-1;
			}else{
				front = (front+1)%max;
			}
			return temp;
		}
	}
}