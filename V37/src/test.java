public class test {
  private static CircularBuffer<String> buffer = new CircularBuffer<String>(5);
  private static boolean fileProcessed = false;
  
  public static class Process1Thread extends Thread
  {
    public void run() {
      while(!fileProcessed) {
        synchronized(buffer) {
          try {
            buffer.wait();
          } catch(InterruptedException e) {
          
          }
        }
      }
      
      System.out.println("File Processed, now upload file...");
    }
  }
  
  public static class Process2Thread extends Thread
  {
	  private long milli;
	  public Process2Thread(long milli) {
		  this.milli = milli;
	  }
    public void run() {
     
      
      //do some processing on the files here...
      try {
		Thread.sleep(milli);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.out.println("Start Processing File...");
      fileProcessed = true;
      
      synchronized(buffer) {
        buffer.notifyAll();
      }
    }
  }
  
//  public static void main(String[] args) {
//    new Process1Thread().start();
//    new Process2Thread(1000).start();
//    new Process2Thread(2000).start();
//  }
}