class StackArray
{
    private static final int CAPACITY = 10;

    // Dynamic Stack Array    
    private int[] s;
    private int top;

    public StackArray()
    {
        // create array with initial capcity and top -1
        s = new int[CAPACITY];
        top = -1;
    }

    public void push(int x)
    {
        // size of Array exceeds
        if(top + 1 == s.length)
        {
            // resize Array Double Times
            resize();
        }

        s[++top] = x;
    }

    public void resize()
    {
        // create NewStack Double size
        int[] newS = new int[s.length * 2];

        // copy original Stack Element
        for(int i = top; i >= 0; i--)
        {
            newS[i] = s[i];
        }
        // change Orginal Array
        s = newS;
    }

    public int pop()
    {
        // check Empty Stack - return MAX_int
        if(isEmpty())
            return Integer.MAX_VALUE;

        // remove top of Stack - return MAX_int
        return s[top--];
    }

    public int peek()
    {
        // check Empty Stack
        if(isEmpty())
            return Integer.MAX_VALUE;

        // return top of Stack
        return s[top];
    }

    public boolean isEmpty()
    {
        // top still in -1 (EMPTY)
        return top == -1;
    }
}

class MyQueue {
    // create Two Stacks
    StackArray stack1;
    StackArray stack2;

    public MyQueue() 
    {
        stack1 = new StackArray();
        stack2 = new StackArray();
    }

    /* Queue - FIFO     Stack - LIFO */
    public void push(int x) 
    {
        // just add to Stack (stack, queue both adds to End)
        stack1.push(x); 
    }
    
    public int pop() 
    {
        // Stack2 is Empty 
        if(stack2.isEmpty())    
        {
            // Transfer all from Stack1 to Stack2
            while(!stack1.isEmpty())
            {
                // pop from Stack1 - push to Stack2
                stack2.push( stack1.pop() );
            }
        }

        // remove top from Stack2 - (Queue , revesed first)
        return stack2.pop();
    }
    
    public int peek() 
    {
        // Stack2 is Empty - Transfer all from Stack1 to Stack2
        if(stack2.isEmpty())    
        {
            while(!stack1.isEmpty())
            {
                stack2.push( stack1.pop() );
            }
        }

        // return top from Stack2 - (Queue , revesed first)
        return stack2.peek();
    }
    
    public boolean empty() 
    {
        // both Stack1 and Stack2 are EMPTY
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */