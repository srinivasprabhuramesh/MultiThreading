package ReadwriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 SharedResource resource = new SharedResource();
 ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
 ReadWriteLock locks = new ReentrantReadWriteLock();
  Thread t1 = new Thread(()->{
	  resource.producer(lock);
  });
  Thread t2 = new Thread(()->{
	  resource.producer(lock);
  });
  Thread t3 = new Thread(()->{
	  resource.consumer(lock);
  });
  t1.start();
  t2.start();
  t3.start();
	}

}
