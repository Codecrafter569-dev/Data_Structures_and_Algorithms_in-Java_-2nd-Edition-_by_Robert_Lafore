import java.util.LinkedList;
import java.util.Queue;
public class FIFOQueuesExample{
public static void main(String args[]){
new FIFOQueuesExample().go();
}
public void go(){
	Queue<Integer> queue = new LinkedList<>();
	
	queue.offer(10);
	queue.offer(20);
	queue.offer(30);
	queue.offer(40);
	queue.offer(50);
	
	System.out.println("Queues "+queue);
	
	System.out.println("Front element: "+queue.poll());

	System.out.println("After poll Queues "+queue);
	
		System.out.println("Processing: "+queue.peek());

}
}