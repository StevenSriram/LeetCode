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

class MinStack {
    // two Stacks - Normal Stack, Minimum Stack
    StackArray stack;
    StackArray minStack;

    public MinStack() 
    {
        stack = new StackArray();
        minStack = new StackArray();    
    }
    
    public void push(int val) 
    {
        // Push val to Stack
        stack.push(val);

        // push Min at this point (top, val)
        int curMin = Math.min(minStack.peek(), val);
        minStack.push(curMin);
    }
    
    public void pop() 
    {
        // remove from Both Stacks
        stack.pop();
        minStack.pop();
    }
    
    public int top() 
    {
        // Normal Stack's Top
        return stack.peek();
    }
    
    public int getMin() 
    {
        // Minimu Stack's Top
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */