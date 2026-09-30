import java.util.PriorityQueue;
import java.util.Queue;

public class Build_In_PriorityQueues{

public static void main(String args[]){
new Build_In_PriorityQueues().go();
}
public void go(){
	Queue<Integer> priorityQueues =new PriorityQueue<>();
	priorityQueues.offer(20);
	priorityQueues.offer(10);
priorityQueues.offer(30);
priorityQueues.offer(10);
priorityQueues.offer(5);
priorityQueues.offer(60);
System.out.println("Processing: "+priorityQueues.peek());
System.out.println("PriorityQueue (Natural Order): " + priorityQueues);

        // Poll elements: the smallest element is removed first
        while (!priorityQueues.isEmpty()) {
            System.out.println("Removed element: " + priorityQueues.poll());
        }

}
}
