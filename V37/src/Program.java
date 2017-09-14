import java.util.Random;

public class Program {
	
	private static CircularBuffer<Integer> buffer = new CircularBuffer<Integer>(5);
	private static Random random = new Random();
	
	public static class Consumer implements Runnable
	{
		// Timespan in milliseconds for random generator
		private int lowerBound = 500,
					upperBound = 2000;
		
		public void run(){
			while(true) {
				if (buffer.isEmpty()){
					synchronized(buffer) {
						try {
							System.out.println("Wait for Producer to produce...");
							buffer.wait();
						} catch(InterruptedException e) {
				        }
					}
				}else {
					buffer.remove();
					System.out.println("item removed");
				}
				
				// Stop thread random time for some variation
				try	{
					Thread.sleep(random.nextInt(upperBound-lowerBound)+lowerBound);
				} catch (InterruptedException e1){
					e1.printStackTrace();
				}
				
			    synchronized(buffer) {
			    	buffer.notifyAll();
			    }
			}
	    }
	}
	
	public static class Producer implements Runnable
	{
		public static int counter;
		private int id;
		
		// Timespan in milliseconds for random generator
		private int lowerBound = 500,
					upperBound = 2000;
		
		public Producer() {
			counter++;
			id = counter;
		}
		
		public void run(){
			while(true) {
				if (buffer.isFull()){
					synchronized(buffer) {
						try {
							System.out.println("Wait for Consumer to consume...");
							buffer.wait();
						} catch(InterruptedException e) {
				        }
					}
				}else {
					buffer.add(random.nextInt(2000));
					System.out.println("Item added by producer " + id);
				}
			
				// Stop thread random time for some variation
				try	{
					Thread.sleep(random.nextInt(upperBound-lowerBound)+lowerBound);
				} catch (InterruptedException e1){
					e1.printStackTrace();
				}
				
			    synchronized(buffer) {
			    	buffer.notifyAll();
			    }
			}
	    }
	}

	public static void main(String[] args){
		
		Thread producer1 = new Thread(new Producer());
		Thread producer2 = new Thread(new Producer());
		Thread consumer = new Thread(new Consumer());

		producer1.start();
		producer2.start();
		consumer.start();
	}

}
