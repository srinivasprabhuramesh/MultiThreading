package Semaphore;

import java.util.concurrent.Semaphore;

public class SharedResource {
	
	public void producer(Semaphore lock) {
		
		try {
			 lock.acquire();

			System.out.println("Semaphore lock Acquired" + Thread.currentThread().getName());
			Thread.sleep(5000);
			
		} catch (Exception e) {

		}
		finally {
			lock.release();
			System.out.println("Semaphore lock Released" + Thread.currentThread().getName());

		}
	}
}
