class Solution {
    public int maxSum(int[] nums1, int[] nums2) 
    {
        /* We only Shift Path when same Score */

        int n = nums1.length, m = nums2.length;

        // I - nums1    J - nums2
        int i = 0, j = 0;

        // Max Sum of Scores
        long maxScore = 0;

        // Sum1 - nums1     Sum2 - nums2
        long sum1 = 0, sum2 = 0;

        // Both Inbounds
        while(i < n && j < m)   
        {
            /* We have to Take the Maximum Path */

            // nums1 less add to sum1
            if(nums1[i] < nums2[j])
            {
                sum1 += nums1[i];
                i++;
            }

            // nums2 less add to sum2
            else if(nums2[j] < nums1[i])
            {
                sum2 += nums2[j];
                j++;
            }

            // same Scores
            else
            {
                /* get Max Score till this Points */

                // max(sum1 , sum2) + either nums1 (or) nums2 
                maxScore += Math.max(sum1, sum2) + nums1[i];

                // Reset Sums and increment Index
                sum1 = sum2  = 0;
                i++;
                j++;
            }
        }

        // add remaining to Sum1
        while(i < n)
        {
            sum1 += nums1[i];
            i++;
        }

        // add remaining to Sum2
        while(j < m)
        {
            sum2 += nums2[j];
            j++;
        }

        // get Max at Last Points
        maxScore += Math.max(sum1, sum2);

        // Score - Mod with 10^9 + 7
        return (int) (maxScore % 1000000007);
    }
}