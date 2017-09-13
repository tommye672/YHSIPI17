import java.util.Random;

public class Program {
	
	private static CircularBuffer<Integer> buffer = new CircularBuffer<Integer>(10);
	
	public static class Consumer extends Thread
	{
		public void run(){
			while(true) {
				if (buffer.isEmpty()){
					synchronized(buffer) {
						try {
							buffer.wait();
						} catch(InterruptedException e) {
				        }
					}
				}
			
				buffer.remove();
				try	{
					Thread.sleep(1000);
				} catch (InterruptedException e1){
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      synchronized(buffer) {
			    	  buffer.notifyAll();
			    }
			}
	    }
	}
	
	public static class Producer extends Thread
	{
		public Random random = new Random();
		
		public void run(){
			while(true) {
				if (buffer.isFull()){
					synchronized(buffer) {
						try {
							buffer.wait();
						} catch(InterruptedException e) {
				        }
					}
				}
			
				buffer.add(random.nextInt(1000));
				try	{
					Thread.sleep(1000);
				} catch (InterruptedException e1){
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    synchronized(buffer) {
			    	buffer.notifyAll();
			    }
			}
	    }
	}

	public static void main(String[] args){
		
		new Producer().start();
		new Consumer().start();
		new Consumer().start();
						
	}

}
