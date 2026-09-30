public class PriorityQueuesTestDriveV2{
public static void main(String args[]){
PQueue pQ=new PQueue(10);

        pQ.insert(10);
		pQ.insert(30);
		pQ.insert(40);
		pQ.insert(60);
		pQ.insert(70);
        pQ.insert(80);
        pQ.insert(20);
        pQ.insert(50);

        pQ.display();

        while(!pQ.isEmpty()) {
            System.out.print( pQ.delete() + " " );
        }
}
}
class PQueue {
    private int[] a;
    private int max;
    private int rear;
    private int front;
    
    //Considering smallest number to have maximum priority

    public PQueue(int max) {
        this.max = max;
        a = new int[max];
        rear = front = -1;
    }

    public boolean isFull() {
        if(rear == max -1) return true;
        else return false;
    }

    public boolean isEmpty() {
        if(rear == -1 )  return true;
        else return false;
    }

    public void display() {
        int i;
        if(!isEmpty()) {
            for(i=front;i<=rear;i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        else {
            System.out.println("Queue is Empty");
        }  
    }
	public void insert(int val) {
        if(isFull()) {
            System.out.println("Overflow");
         } else {
            if(isEmpty()) {
                 front = rear = 0;
                a[rear] = val;
            } else {
                rear++;
                 a[rear] = val;
            }
        }
     }
	public int delete() {
        if(!isEmpty()) {
            if(rear == front) {
                int ele = a[rear];
                rear = front = -1;
                
                return ele;
            } else {              //find minimum
                int pos = 0;
                int min = a[0];

                for(int i=0; i<=rear; i++) {
                    if(a[i]<min) {
                         min = a[i];
                         pos = i;
                     }
                }

                for(int i=pos; i<rear; i++) {
                    a[i] = a[i+1];
                }

                 max--;
                 rear--;
                 return min;
             }
         } else {
            System.out.println("Underflow");
         }
        return -1;
     }
	
	
}