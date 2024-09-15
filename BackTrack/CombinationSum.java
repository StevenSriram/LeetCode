class Solution {
    // Time : O(2^target)
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // combination Sum List
        res = new ArrayList<>();

        // backTrack ( index, curCombination, curTotal )
        backTrack(0, new ArrayList<Integer>(), 0, candidates, target);

        return res;
    }

    public void backTrack(int i, List<Integer> cur, int total,
                                int[] candidates, int target)
    {
        // found Combination Sum
        if(total == target)
        {
            // add Copy of cur
            res.add(new ArrayList<>(cur));
            return;
        }

        // Range exits or Total exits Target
        if(i >= candidates.length || total > target)
            return;

        /* Include cur Candidate */
        cur.add(candidates[i]);
        // backTrack (index, cur, add cur to Total)
        backTrack(i, cur, total+candidates[i], candidates, target);

        /* Exclude cur Candidate */
        // remove previously added Candidate
        cur.remove(cur.size()-1);
        // backTrack (index+1, cur, same Total)
        backTrack(i+1, cur, total, candidates, target);
    }
}