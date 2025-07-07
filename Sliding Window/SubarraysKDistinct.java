class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) 
    {
        /*
            Count of subarrays with exactly K distinct elements : 
                ATMOST(K) - ATMOST(K - 1)
        */
        int exactlyK = distinctHelper(nums, k) - distinctHelper(nums, k - 1);

        return exactlyK;
    }

    public int distinctHelper(int[] nums, int k)
    {
        // Store Freq of elements in cur Window
        Map<Integer, Integer> uniqueMap = new HashMap<>(); 

        // Total No. of subarrays
        int count = 0; 

        int l = 0, r = 0; // Window pointers

        while(r < nums.length)
        {
            // Add cur Element to Map, update Freq
            uniqueMap.put(nums[r], uniqueMap.getOrDefault(nums[r], 0) + 1);

            // If No. of Distinct element exceeds K
            while(uniqueMap.size() > k)
            {
                // Shrink window from Left
                uniqueMap.put(nums[l], uniqueMap.get(nums[l]) - 1); 

                // Remove element if its Freq becomes 0
                uniqueMap.remove(nums[l], 0);
                /*
                Equivalent : 
                    if(uniqueMap.get(nums[l]) == 0)
                        uniqueMap.remove(nums[l]);
                */

                l++; 
            }

            // Count subarrays Length (R - L + 1)
            count += (r - l + 1);

            r++;
        }

        return count;
    }
}
