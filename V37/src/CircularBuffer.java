
public class CircularBuffer<T> {
/*
 En FIFO generisk klass d�r <T> l�ggs till i k�n, tail
 och plockas fr�n head
*/	
	private T[]  buffer;
    private int  head,      // pekar p� ledigt element
                 tail;      // pekar p� sista element
    private boolean m;      // minne f�r att veta om pekarna �r p� samma varv eller inte

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
        // �terst�ller r�knaren till 0 n�r slutet av bufferten �r n�dd
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
