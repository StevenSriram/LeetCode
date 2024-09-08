class Solution {
    // all Subsets
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();

        // start BackTrack from 0 index
        backTrack(0, nums, new ArrayList<Integer>());

        return res;
    }

    public void backTrack(int i, int[] nums, List<Integer>  subset)
    {
        if(i == nums.length)
        {
            // limit exceeds add to all Subset
            res.add(new ArrayList<>(subset));
            return;
        }

        // include current to Subset
        subset.add(nums[i]);
        backTrack(i+1, nums, subset);

        // exclude current from Subset
        subset.remove(subset.size() - 1);
        backTrack(i+1, nums, subset);
    }
}