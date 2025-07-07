class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        int n = heights.length;

        /* Monotonic Stack - maintaining Increasing Order */
        Deque<Integer> stack = new ArrayDeque<>();

        // push(-1) - to avoid Edge Case
        stack.push(-1);

        // Max Area of Rectange in Histogram
        int maxArea = 0;

        for(int i=0; i<n; i++)
        {
            // Stack not-Empty and cur is Less than Peek
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i])
            {
                // Height = height of stack Top
                int height = heights[stack.pop()];

                // Width Span = cur - 1 - stack Peek
                int width = i - 1 - stack.peek();

                /* Area = height * width */
                maxArea = Math.max(maxArea, height * width);
            }

            // puch if Increasing Order
            stack.push(i);
        }

        // Reverse Case : Histogram is fully Increasing
        while(stack.peek() != -1)
        {
            int height = heights[stack.pop()];

            // Width Span from End = N - 1 - stack Peek
            int width = n - 1 - stack.peek();

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}