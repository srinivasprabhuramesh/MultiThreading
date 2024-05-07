package StampedOptimisticRead;

import java.util.concurrent.locks.StampedLock;


public class Main {

	
	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
		StampedLock lock = new StampedLock();
		Thread t1 = new Thread(()->{
			resource.producer(lock);
			});

		Thread t2 = new Thread(()->{
			resource.producer(lock);
			});
		SharedResource resource1 = new SharedResource();

		Thread t3 = new Thread(()->{
			resource1.consumer(lock);
			});
		t1.start();
		t2.start();
		t3.start();
	}

}
