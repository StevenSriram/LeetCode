class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int n = nums1.length, m = nums2.length;
        int total = (n + m);

        // Ensures first Array is Mininum -  O ( log min(n + m) )
        if(n > m)
            return findMedianSortedArrays(nums2, nums1);

        // Partiton total Array to atmost Half Equal Size
        /*
            mid1 - no change
                EVEN :  (4 + 2 + 1) / 2 => 3
            
            mid1 - left partiton have high
                ODD :  (3 + 4 + 1) / 2 => 4
        */
        int half = (total + 1) / 2;

        // take atmost N values of nums1
        int l = 0, r = n;

        // until don't cross Over
        while(l <= r)
        {
            // Efficent Inbound Min calculation
            int mid1 = l + (r - l) / 2;

            // take mid element from nums1 then 
            //      take remaining half - mid elements form nums2
            int mid2 = half - mid1;

            /* 
                Compute Left and Right values of both Arrays
                    if not avaliable left - MIN / right - MAx
            */
            int L1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int R1 = mid1 < n ? nums1[mid1] : Integer.MAX_VALUE;

            int L2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int R2 = mid2 < m ? nums2[mid2] : Integer.MAX_VALUE;

            /*  
                Valid Partiton : 
                    ALeft <= BRight and BLeft <= ARight
            */
            if(L1 <= R2 && L2 <= R1)
            {
                // ODD : max(ALeft, BLeft) {left balanced with more Values}
                if(total % 2 == 1)
                    return Math.max(L1, L2);
                
                // EVEN : (max(Lefts) + min(Right)) / 2
                return ((double) Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
            }
            // ALeft > BRight
            else if(L1 > R2)
            {
                // eliminate Right Half
                r = mid1 - 1;
            }
            // BLeft > ARight
            else
            {
                // eliminate Left Half
                l = mid1 + 1;
            }
        }

        return 0.0;
    }
}