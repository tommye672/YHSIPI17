
public class CircularBuffer<T> {
/*
 En FIFO generisk klass där <T> läggs till i kön, tail
 och plockas från head
*/	
	private T[]  buffer;
    private int  head,      // pekar på ledigt element
                 tail;      // pekar på sista element
    private boolean m;      // minne för att veta om pekarna är på samma varv eller inte

    @SuppressWarnings("unchecked")
	public CircularBuffer(int size)
    {
        buffer = (T[])new Object[size];
    }

    public void add(T item)
    {
        if (isFull())
            return;

        if (buffer[tail] != null) throw new IllegalArgumentException();
        
        m = true;
        buffer[tail] = item;
        tail = countUp(tail);
    }

    public void remove()
    {
        if (isEmpty())
            return;

        if (buffer[head] == null) throw new IllegalArgumentException();
        
        m = false;
        buffer[head] = null;
        head = countUp(head);     
    }

    public boolean isFull()
    {
        return head == tail && m;
    }
    public boolean isEmpty()
    {
        return tail == head && !m;
    }

    private int countUp(int counter)
    {
        // Återställer räknaren till 0 när slutet av bufferten är nådd
        return counter >= buffer.length -1 ? 0 : counter + 1 ;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < buffer.length; i++)
        {
            builder.append(i+": ").append(buffer[i]).append("\n");
        }

        return builder.toString();
    }
}
