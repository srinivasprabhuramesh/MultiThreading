package Semaphore;

import java.util.concurrent.Semaphore;


public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore lock = new Semaphore(2);
		SharedResource resource = new SharedResource();
		
		Thread t1 = new Thread(()->{
			resource.producer(lock);
			});

		Thread t2 = new Thread(()->{
			resource.producer(lock);
			});
		SharedResource resource1 = new SharedResource();

		Thread t3 = new Thread(()->{
			resource1.producer(lock);
			});
		t1.start();
		t2.start();
		t3.start();
	}

}
