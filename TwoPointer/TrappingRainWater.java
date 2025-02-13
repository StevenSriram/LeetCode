class Solution {

    /*
        INTUTION : 
             [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]

        maxL [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
        maxR [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]

        MIN  [0, 1, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1]  

    RES = MIN(maxL[i], maxR[i]) - height[i] : 
        RES  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0]
    */

    public int trap(int[] height) {
        if(height.length == 0)
            return 0;

        // Two Pointer Approach
        int l = 0, r = height.length-1;

        // maximum so For on Left , Right
        int maxLeft = height[l];
        int maxRight = height[r];

        // rain Water Trapped
        int res = 0;

        /*
           Formula : Min( maxLeft, maxRight ) - Height[i]

           maxLeft is Min don't need to consider about maxRight,
                - no matter we still choose maxLeft
        */

        while(l < r)
        {
            // maxLeft is Min
            if(maxLeft < maxRight)
            {
                /*
                    move Left - In edges we don't Trap any Water
                                because Water Spill Out Start
                    
                    update maxLeft with curHeight to avoid -Ve case

                     L          R
                      \        /        maxLeft = 2
                        [2, 3]          maxLeft = 3

                    TRAP = (3 - 3) => 0 
                */
                l++;
                maxLeft = Math.max(maxLeft, height[l]);

                // MIN => maxLeft - heigth[L]
                res += maxLeft - height[l];
            }

            // maxRight is Min
            else
            {
                /*
                    move Right - In edges we don't Trap any Water
                                because Water Spill Out End
                    
                    update maxRight with curHeight to avoid -Ve case
                */
                r--;
                maxRight = Math.max(maxRight, height[r]);

                // MIN => maxRight - heigth[R]
                res += maxRight - height[r];
            }
        }

        // Water it can trap after raining.
        return res;
    }
}