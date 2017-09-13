
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
        //TODO error handling

        if (isFull())
            return;

        m = true;
        buffer[tail] = item;
        tail = countUp(tail);
        System.out.println("added item " + item.toString());
    }

    public void remove()
    {
        //TODO error handling
        //TODO ska objectet returneras eller bara tas bort?

        if (isEmpty())
            return;

        m = false;
        buffer[head] = null;
        head = countUp(head);     
        System.out.println("removed item");
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
