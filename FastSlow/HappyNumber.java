class Solution {

    // function to find sum_of_square of digits
    static int sumOfSquare(int n)
    {
        int res = 0;
        while(n > 0)
        {
            res += (n%10) * (n%10);
            n /= 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        // Cycle detection slow - fast
        int slow = n;
        int fast = sumOfSquare(n);
        while(slow != fast)
        {
            slow = sumOfSquare(slow);
            fast = sumOfSquare(sumOfSquare(fast));
        }
        
        // 1 - happy  /  otherwise unhappy
        return slow == 1 ? true : false;
    }
}