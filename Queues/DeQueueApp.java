public class DeQueueApp{
public static void main(String[] args){
DeQueue q = new DeQueue(5);
		q.insertFront(10);
		q.insertRear(20);
		q.insertRear(30);
		q.insertRear(40);
		q.insertRear(50);
		q.insertRear(60);

		q.deleteFront();
		q.deleteFront();

		q.deleteRear();
		q.deleteFront();

		q.insertFront(10);
		q.insertFront(20);
		q.insertFront(80);
		q.insertFront(70);
		q.insertRear(60);
		q.display();
		
		StackY theStackY = new StackY(5);
		theStackY.push(10);
		theStackY.push(20);
		theStackY.push(30);
		theStackY.pop();
		theStackY.display();

}
}

class StackY {
	private DeQueue dequeStack;
	
	public StackY(int maxSize) {	
		dequeStack = new DeQueue(maxSize);
	}
	
	public void push(int val) {
		dequeStack.insertRear(val);
	}
	
	public int pop() {
		return dequeStack.deleteRear();
	}

	public void display() {
		dequeStack.display();
	}
	
}

class DeQueue{
	private int max,rear,front;
	private int[] a;
	
	public DeQueue(int m){
		max = m;
		a = new int[m];
		rear = front = -1;
	}
	public void insertRear(int val){
		if(isFullRear()){
			System.out.println("OverFlow Rear");
		}else{
			if(isEmpty()){
				front = rear = 0;
				a[rear] = val;
			}else{
				rear++;
				a[rear] = val;
			}
		}
	}
	public void insertFront(int val){
		if(isFullFront()){
			System.out.println("OverFlow Front");
		}else{
			if(isEmpty()){
				front = rear =0;
				a[front] = val;
			}else{
				front--;
				a[front] = val;
			}
		}
	}
	public void display(){
		for(int i= front; i<= rear;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public boolean isFullRear(){
		if(rear == max-1){
			return true;
		}else{
			return false;
		}
	}
	public boolean isFullFront(){
		if(front == 0){
			return true;
		}else{
			return false;
		}
	}
	public boolean isEmpty(){
		if(rear == -1 && front == -1){
			return true;
		}else{
			return false;
		}
	}
	public int deleteFront(){
		if(isEmpty()){
			System.out.println("Underflow front");
			return -1;
		}else{
			int temp = a[front];
			front++;
			return temp;
		}
	}
	public int deleteRear(){
		if(isEmpty()){
			System.out.println("Underflow rear");
			return -1;
		}else{
			int temp = a[rear];
			rear--;
			return temp;
		}
	}
}