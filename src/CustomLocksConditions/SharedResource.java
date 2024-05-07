package CustomLocksConditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	public  void producer()  {
	//	System.out.println("Producer Thread Started");
		try {
		    lock.lock();
		    System.out.println("Producer Thread Lock Acquired"+Thread.currentThread().getName());
		    if(isAvailable) {
				System.out.println("Producer thread will wait for consumer to consume");
               condition.await(); // releases the lock
		    }
			isAvailable = true;
			condition.signal();
		}
		catch(Exception e) {
			
		}
		finally {
			lock.unlock();
			System.out.println("Producer Thread Released Lock"+Thread.currentThread().getName());
			
		}
    }

  public  void consumer()  {
    	
		
    	   try {
    		   Thread.sleep(5000);
    		   lock.lock();
    		   System.out.println("Consumer thread Lock Acquired"+Thread.currentThread().getName());
               
    		   if(!isAvailable) {
    			   System.out.println("Consumer thread will wait for Producer to Produce");
                   condition.await();
    		   }
    		   isAvailable=false;
    		   condition.signal();
    	   }
    	   catch(Exception e) {
    		   
    	   }
    	   finally {
    		   lock.unlock();
    		   System.out.println("Consumer Thread Released Lock"+Thread.currentThread().getName());
   			
    	   }
			
    }
}
