class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Sliding Window of size K
        Set<Integer> window = new HashSet<>();

        int start = 0;

        for(int end = 0; end<nums.length; end++)
        {
            // Window size exists K
            if(end - start > k)
            {
                // remove Start
                window.remove(nums[start]);
                start++;
            }

            // duplicate Contains
            if(window.contains(nums[end]))
                return true;
            
            // add to Window
            window.add(nums[end]);
        }
        return false;
    }
}