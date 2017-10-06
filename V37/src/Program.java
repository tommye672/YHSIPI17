import java.util.Random;

public class Program {

	private static CircularBuffer<Integer> buffer = new CircularBuffer<Integer>(10);
	private static Random random = new Random();

	public static class Consumer implements Runnable {
		// Timespan in milliseconds for random generator
		private int lowerBound = 500, upperBound = 2000;

		public void run() {
			while (true) {
				/* 
				 * Här tar tråden kontrollen över buffer. 
				 * Dvs - Ingen annan tråd läser eller skriver till buffer innan all kod inom synchronizedblocket är utfört
				 */ 
				synchronized (buffer) {
					if (buffer.isEmpty()) {
						try {
							System.out.println("Wait for Producer to produce...");
							/* 
							 * Här släpper tråden kontrollen över buffer och 
							 * väntar på att en annan tråd anropar notify() eller notifyAll()
							 */
							buffer.wait();
						} catch (InterruptedException e) {
						}
					} else {
						buffer.remove();
						System.out.println("item removed");
						/* 
						 * Här talar tråden om att för de andra trådarna att det är ok att gå vidare
						 */						
						buffer.notifyAll();
					}
				}
				// Stop thread random time for some variation
				try {
					Thread.sleep(random.nextInt(upperBound - lowerBound) + lowerBound);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static class Producer implements Runnable {
		public static int counter;
		private int id;

		// Timespan in milliseconds for random generator
		private int lowerBound = 500, upperBound = 2000;

		public Producer() {
			counter++;
			id = counter;
		}

		public void run() {
			while (true) {
				synchronized (buffer) {
					if (buffer.isFull()) {
						try {
							System.out.println("Wait for Consumer to consume...");
							buffer.wait();
						} catch (InterruptedException e) {
						}
					} else {
						buffer.add(random.nextInt(2000));
						System.out.println("Item added by producer " + id);
						buffer.notifyAll();
					}
				}
				// Stop thread random time for some variation
				try {
					Thread.sleep(random.nextInt(upperBound - lowerBound) + lowerBound);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		Thread producer1 = new Thread(new Producer());
		Thread producer2 = new Thread(new Producer());
		Thread producer3 = new Thread(new Producer());
		Thread producer4 = new Thread(new Producer());
		
		producer1.start();
		producer2.start();
		producer3.start();
		producer4.start();
		
		Thread consumer1 = new Thread(new Consumer());
		Thread consumer2 = new Thread(new Consumer());
		Thread consumer3 = new Thread(new Consumer());
		Thread consumer4 = new Thread(new Consumer());

		consumer1.start();
		consumer2.start();
		consumer3.start();
		consumer4.start();
	}

}
