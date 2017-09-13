
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
