class Solution {
    public int mySqrt(int x) 
    {
        // sqrt(0) = 0
        if(x == 0)  return 0;

        // Integer part of sqare root
        int res = 0;

        // Binary search : range from 0 to x
        int l = 1, r = x;

        // loop until pointers Overlap
        while (l <= r) 
        {
            // Calculate middle value
            int mid = l + (r - l) / 2;

            /*
                Mid * Mid maybe Out of Integer range,
                    Mid = X / Mid
            */

            // mid*mid is less than X, move right
            if (mid < x / mid) 
            {
                l = mid + 1;

                /*
                    Update result because mid*mid < x,
                        this maybe Integer part of square root

                    sqrt(5) = 2.236  ->  2 
                */
                res = mid; 
            }

            // mid*mid is greater than x, move left
            else if (mid > x / mid) 
            {
                r = mid - 1;
            }

            // mid*mid equals x, return mid (perfect square)
            else 
            {
                return mid;
            }
        }

        return res;
    }

    public boolean isPerfectSquare(int num) 
    {
        // find Sqrt of Num
        int sqrt = mySqrt(num);

        // sqrt ^ 2 == Num -> Perfect Square
        return sqrt * sqrt == num;

        /*
            Alternate : 
                Similar to  SQRT logic, use long sq = mid * mid

                sq == Num  -> Perfect Square
        */
    }
}