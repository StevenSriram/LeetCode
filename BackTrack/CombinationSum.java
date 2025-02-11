class Solution {
    // Time : O(2^target)

    // All Unique Combinations Sum
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        res = new ArrayList<>();

        // backTrack ( index, curCombination, curTotal )
        backTrack(0, new ArrayList<>(), 0, candidates, target);

        return res;
    }
    // Recursive Tree : 
    /*
                                                []

                                [2]                          []

                    [2,2]                [2]             [3]       []

        [2,2,2]            [2,2]    [2,3]     [2]             [6]      []

        x       x   { [2,2,3] }  [2,2]       [2,6] [2]             [7]     []
    */

    public void backTrack(int i, List<Integer> cur, int total, 
                                    int[] candidates, int target)
    {
        // curTotal equals Target - Combination Sum found
        if(total == target)
        {
            // add Copy of cur
            res.add(cur.stream().toList());
            return;
        }

        // Range exits or Total exits Target
        if(i == candidates.length || total > target)
            return;

        /* Include cur Candidate */
        cur.add(candidates[i]);

        /* Same Candidates can be choosen Unlimited no times  */
        // backTrack (index, cur, add cur to Total)
        backTrack(i, cur, total + candidates[i], candidates, target);

        // BackTrack :  remove previously added Candidate
        cur.remove(cur.size() - 1);

        /* Exclude cur Candidate */
        // backTrack (index+1, cur, same Total)
        backTrack(i + 1, cur, total, candidates, target);
    }
}