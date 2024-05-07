package StampedReadWritelock;

import java.util.concurrent.locks.StampedLock;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
