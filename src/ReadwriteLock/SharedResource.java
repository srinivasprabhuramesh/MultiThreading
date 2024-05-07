package ReadwriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class SharedResource {

	boolean isAvailable = false;
	
	public void producer(ReentrantReadWriteLock lock) {
		try {
			lock.readLock().lock();
			System.out.println("Read Lock Acquired by"+Thread.currentThread().getName());
			

			Thread.sleep(5000);
		}
		catch(Exception e) {
			
		}
		finally {
			lock.readLock().unlock();
			System.out.println("Read Lock Released by"+Thread.currentThread().getName());

		}
	}
	public void consumer(ReadWriteLock lock) {
		try {
			lock.writeLock().lock();
			System.out.println("Write Lock Acquired by"+Thread.currentThread().getName());
			Thread.sleep(5000);
		}
		catch(Exception e) {
			
		}
		finally {
			lock.writeLock().unlock();
			System.out.println("Write Lock Released by"+Thread.currentThread().getName());

		}
	}

	
}
