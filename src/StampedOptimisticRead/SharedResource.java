package StampedOptimisticRead;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

//StampedLock lock = new StampedLock();
    
    public void producer(StampedLock lock) {
		long stamp =lock.tryOptimisticRead();

    	try {
    		System.out.println("Optimistic Read Acquired"+Thread.currentThread().getName());
    		Thread.sleep(5000);
    		if(lock.validate(stamp)) {
        		System.out.println("Update Value Successfully");

    		}
    		else {
        		System.out.println("RollBack");

    		}
    	}
    	catch(Exception e){
    		
    	}
    	// No Unlocking Required because no lock
    }
    public void consumer(StampedLock lock) {
    	long stamp =lock.writeLock();

    	try {
    		System.out.println("Stamped Write Lock Acquired"+Thread.currentThread().getName());
    		Thread.sleep(5000);
    	}
    	catch(Exception e){
    		
    	}
    	finally {
    		lock.unlockWrite(stamp);
    		System.out.println("Stamped Write Lock Released by "+Thread.currentThread().getName());

    	}
    }

}
