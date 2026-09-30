import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample{

public static void main(String args[]){
new DequeExample().go();
}
public void go(){
	     Deque<String> deque = new ArrayDeque<>();

        // Adding elements at both ends
        deque.addFirst("First");
        deque.addLast("Last");
        deque.addFirst("New First");

        System.out.println("Deque: " + deque);

        // Peek operations at both ends
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());

        // Removing elements from both ends
        System.out.println("Removed from front: " + deque.removeFirst());
        System.out.println("Removed from rear: " + deque.removeLast());
        System.out.println("Deque after removals: " + deque);
}
}