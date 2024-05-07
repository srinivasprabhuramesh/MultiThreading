package ConsumerProducer;

public class Mainclass {

	public Mainclass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     SharedResource resource = new SharedResource(3);
     Thread t1 = new Thread(()->{
    	 for(int i=0;i<6;i++) {
    		 try {
				resource.producer(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
     });
     Thread t2 = new Thread(()->{
    	 for(int i=0;i<6;i++) {
    		 try {
				resource.consumer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    	 }
     });
     
     t1.start();
     t2.start();
	}

}
