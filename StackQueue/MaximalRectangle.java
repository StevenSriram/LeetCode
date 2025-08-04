class Solution {
    /*
        Relate it with Largest Rectangle in Histogram
            in each Row calc Heights

        {   1  0  1  0  0
            1  0  1  1  1
            1  1  1  1  1   }

        1 : [1, 0, 1, 0, 0]
        2 : [2, 0, 2, 1, 1]
        3 : [3, 1, 3, 2, 2]

        find largest Rect among Hist -> Maximal Rectangle
    */
    public int maximalRectangle(char[][] matrix) 
    {
        int r = matrix.length, c = matrix[0].length;

        // Histogram heights at each row
        int[] heights = new int[c];

        // maximal Rectangle in Matrix
        int maxRect = 0;

        // iterate over Matrix
        for(int i = 0; i < r; i++)    
        {
            // calculate Height at cur Row
            for(int j = 0; j < c; j++)
            {
                // '1' : height + 1, '0' : 0
                if(matrix[i][j] == '1')
                    heights[j] += 1;
                else
                    heights[j] = 0;
            }

            // max among largest Rect in Hist
            maxRect = Math.max(maxRect, 
                        largestRectangleInHistogram(heights));
        }

        /* return maxSquare = side * side */
        return maxRect;
    }

    public int largestRectangleInHistogram(int[] heights)
    {
        int n = heights.length;

        int maxArea = 0;

        // Monotonic Stack : Increasing Order
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for(int i = 0; i < n; i++)
        {
            // decreasing - find Area
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()])
            {
                int height = heights[stack.pop()];
                int width = i - 1 - stack.peek();

                /* 
                Maximal Square : 

                    minSide among (height, width) to find 
                        Largest Square Side that Fits here
                */

                maxArea = Math.max(maxArea, height * width);
            }

            // push Index
            stack.push(i);
        }

        // stricly Increasing
        while(stack.peek() != -1)
        {
            int height = heights[stack.pop()];
            int width = n - 1 - stack.peek();

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}