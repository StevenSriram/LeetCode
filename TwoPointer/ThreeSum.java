class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        // Sort array to use Two-Pointer technique
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++)
        {
            // skip duplicate elements
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            // preform Two-Sum II 
            int l = i + 1, r = nums.length - 1;
            while(l < r)
            {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0)
                    r--;
                else if(sum < 0)
                    l++;
                else
                {
                    // add triplet
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    // skip duplicates here
                    while(nums[l] == nums[l-1] && l < r)
                        l++;
                }
            }
        }
        return res;
    }
}