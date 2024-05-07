package ConsumerProducer;
import java.util.*;

public class SharedResource {
    public Queue<Integer> queue;
    public int bufferSize;

    public SharedResource(int bufferSize) {
		
		this.queue = new LinkedList<>();
		this.bufferSize = bufferSize;
	}

	public synchronized void producer(int item) throws Exception {
		System.out.println("Producer Thread Started");
		while(queue.size()==bufferSize) {
			System.out.println("Buffer is full waiting for consumer to consume");
			wait(); // releases the lock
		}
    	queue.add(item);
		System.out.println("Producer added item:"+item);
		notify(); // notify the waiting thread

    }

  public synchronized int consumer() throws Exception {
    	int item;
		System.out.println("Consumer Thread Started");

    	while(queue.size() == 0) {
			System.out.println("Buffer is empty waiting for producer to produce");

    		wait();
    		}
    	item = queue.poll();
    	System.out.println("Consumer consumed item:"+item);
    	notify();
    	return item;
    }
}
