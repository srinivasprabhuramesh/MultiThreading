package StampedReadWritelock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    //StampedLock lock = new StampedLock();
    
    public void producer(StampedLock lock) {
		long stamp =lock.readLock();

    	try {
    		System.out.println("Stamped Read Lock Acquired"+Thread.currentThread().getName());
    		Thread.sleep(5000);
    	}
    	catch(Exception e){
    		
    	}
    	finally {
    		lock.unlockRead(stamp); // no use in Read Write lock but useful in Optimistic read
    		System.out.println("Stamped Read Lock Released by "+Thread.currentThread().getName());

    	}
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
