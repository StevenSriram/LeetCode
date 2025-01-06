/*
    Median finder by maintaining two Almost Equal Size Heaps

                Medain
             /         \
    left Sorted         right Sorted
*/

class MedianFinder {
    // Left - MAX HEAP
    private Queue<Integer> left;

    // Right - MIN HEAP
    private Queue<Integer> right;

    public MedianFinder() 
    {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) 
    {
        /* By Default : add to Right (Heaps Size same) */
        if(left.size() == right.size())
        {
            // If we add to Right - first add to Left 
            left.offer(num);

            // remove Max from Left and add to Right
            right.offer(left.poll());
        }

        /* add to Left (Unequal Size Heaps) */
        else
        {
            // If we add to Left - first add to Right
            right.offer(num);

            // remove Min from Right and add to Left
            left.offer(right.poll());
        }
    }
    
    public double findMedian() 
    {
        /* Size Same - Even Medain */
        if(left.size() == right.size())
        {
            // Medain = max(Left) + min(Right) 
            return (double) (left.peek() + right.peek()) / 2;
        }

        /* Unequal Size - Odd Even */
        // Medain = min(Right)
        return right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */