package CustomLocksConditions;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     SharedResource resource = new SharedResource();
     Thread t1 = new Thread(()->{
    	 for(int i=0;i<2;i++) {
    		 try {
				resource.producer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
     });
     Thread t2 = new Thread(()->{
    	 for(int i=0;i<2;i++) {
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
