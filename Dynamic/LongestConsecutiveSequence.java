class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) 
            return 0;
        // Longest Consecutive Sequence
        int longest = Integer.MIN_VALUE;

        // make Nums as Set for easy operations
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        // take from Set
        for(int n : set)
        {
            // if previous of Number is not in the Set,
            //  then this is Start of Sequence
            if(!set.contains(n-1))
            {
                // count Sequence Length
                int length = 0;
                // check next of Number is present
                while(set.contains(n + length))
                {
                    // increment Length
                    length++;
                }
                
                // max LCS
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}