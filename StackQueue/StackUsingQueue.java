class QueueArray
{
    // Initial Capacity
    private static final int CAPACITY = 10;

    // create Queue using array    
    private int[] q;
    private int front;
    private int rear;
    private int size;

    public QueueArray()
    {
        // front = 0, rear = -1
        q = new int[CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int x)
    {
        // size exceeds Queue Length - resize Queue
        if(size == q.length)
        {
            resize();
        }

        // Circular Queue 
        rear = (rear + 1) % q.length;
        q[rear] = x;

        size++;
    }

    public void resize()
    {
        // new Queue with Double Size
        int[] newQ = new int[q.length * 2];

        // copy element to new Queue
        for(int i = 0; i < size; i++)
        {
            newQ[i] = q[(front + i) % q.length];
        }

        // Circular Queue - update front, rear
        front = 0;
        rear = size - 1;
        q = newQ;
    }

    public int dequeue()
    {
        // check for Empty Queue
        if(isEmpty())
            return Integer.MAX_VALUE;
        
        // move front
        int val = q[front];
        front = (front + 1) % q.length;

        size--;

        // return Queue front
        return val;
    }

    public int peek()
    {
        // check for Empty Queue
        if(isEmpty())
            return Integer.MAX_VALUE;

        // return Queue front
        return q[front];
    }

    // size remains 0 (EMPTY)
    public boolean isEmpty()
    {
        return size == 0;
    }

    // return Size of Queue
    public int getSize()
    {
        return size;
    }
}

class MyStack {
    // Create One Queue to Implement Stack
    QueueArray queue;

    public MyStack() 
    {
        queue = new QueueArray();
    }
    
    /* Stack - LIFO     Queue - FIFO */

    public void push(int x) 
    {
        // after adding One element to Queue,
        queue.enqueue(x);
                
        // dequeue first (Size - 1) elements and enqueue to Queue
        for(int i = 0; i < queue.getSize() - 1; i++)
        {
            queue.enqueue( queue.dequeue() );
        }
    }
    
    public int pop() 
    {
        // first element from Queue - Reversed 
        return queue.dequeue();
    }
    
    public int top() 
    {
        // front of Queue
        return queue.peek();
    }
    
    public boolean empty() 
    {
        // Queue Empty
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */