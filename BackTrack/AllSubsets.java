class Solution {
    /* Time Complexity  : O(2^n) */
    // all Subsets of nums
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) 
    {
        res = new ArrayList<>();

        // start BackTrack from 0 index
        backTrack(0, nums, new ArrayList<>());

        return res;
    }

    public void backTrack(int i, int[] nums, List<Integer> subset)
    {
        // i equals to length of nums - One Subset
        if(i == nums.length)
        {
            // add one Subset
            res.add(subset.stream().toList());
            return;
        }
        //Recursive Tree - Each Level deals with Inclusion & Exclusion of num
        /*
                                         []

        (1)                     []                   [1]

        (2)             []       [2]             [1]          [1,2]

        (3)        []  [3]   [2]   [2,3]    [1]   [1,3]   [1,2]  [1,2,3]
        */

       // Exclude cur form Subset

            backTrack(i+1, nums, subset);


        // Include cur to Subset

            subset.add(nums[i]);
            // add next Num to Subset
            backTrack(i+1, nums, subset);
            // BackTrack : remove lastly add num from Subset
            subset.remove(subset.size() - 1);
        
    }
}