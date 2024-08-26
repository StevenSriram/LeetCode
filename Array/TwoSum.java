class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        Map<Integer,Integer>  map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            // Complement to find remaining num get target
            int complement = target - nums[i];

            // if complement present - target finded
            if(map.containsKey(complement))
            {
                return new int[]{map.get(complement), i};
            }

            // insert num, index
            map.put(nums[i], i);
        }

        // not present empty
        return new int[]{};
    }
}
