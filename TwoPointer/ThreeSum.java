class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();

        // Sort array to use Two-Pointer technique
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++)
        {
            // skip Duplicate Elements
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            // perform Two-Sum II 
            int l = i + 1, r = nums.length - 1;

            // left and right Not Cross Over
            while(l < r)
            {
                // calculate Triplet Sum
                int sum = nums[i] + nums[l] + nums[r];

                // triplet sums Up to Zero
                if(sum == 0)
                {
                    // found Result - move to Next element
                    res.add(Arrays.asList(nums[i], nums[l] , nums[r]));
                    l++;

                    // skip Duplicates here also
                    while(l < r && nums[l] == nums[l-1])
                        l++;
                }

                // Sum less than 0 - Increase Sum
                else if(sum < 0)
                {
                    l++;
                }

                // Sum greater than 0 - Decrease Sum
                else
                {
                    r--;
                }
            }
        }

        return res;
    }
}