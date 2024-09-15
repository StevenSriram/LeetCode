class Solution {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;

        // Two Pointer Approach
        int l = 0, r = height.length-1;

        // maximum of Left \ maximum of Right from Current
        int maxLeft = height[l];
        int maxRight = height[r];

        // rain Water Trapped
        int res = 0;

        /*
           Formula : Min( maxLeft, maxRight ) - Height[i]
        */
        while(l < r)
        {
            // maxLeft is Min
            if(maxLeft < maxRight)
            {
                // increment left and update maxLeft
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                res += maxLeft - height[l];
            }
            // maxRight is Min
            else
            {
                // decrement right and update maxRight
                r--;
                maxRight = Math.max(maxRight, height[r]);
                res += maxRight - height[r];
            }
        }
        // Water it can trap after raining.
        return res;
    }
}