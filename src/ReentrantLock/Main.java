package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    SharedResource resource = new SharedResource();
    ReentrantLock lock = new ReentrantLock();
    Thread t1 = new Thread(()->{
    	resource.producer(lock);
    });
    SharedResource resource1 = new SharedResource();

    Thread t2 = new Thread(()->{
    	resource1.producer(lock);
    });
    t1.start();
    t2.start();
	}

}
