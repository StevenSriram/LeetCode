class Solution {
    /* Time Complexity : O(n!) */
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) 
    {
        // All Permuations of nums
        res = new ArrayList<>();

        //  BackTracking - generate all permuations
        backTrack(nums, new LinkedList<>());

        return res;
    }

    // Recursive Tree
    /*
                          (1,2,3) (2,3) (3)
        Permuations Math :  _3_   _2_   _1_ 

                           []

              [1]          [2]           [3]

         [1,2]  [1,3]  [2,1]  [2,3]  [3,1]  [3,2]

      [1,2,3] [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1]
    */

    public void backTrack(int[] nums, List<Integer> cur)
    {
        // size of current equals num - One Permuation
        if(cur.size() == nums.length)
        {
            // add copy of Cur ( Avoid passing reference )
            res.add(cur.stream().toList());
            return;
        }

        // iterating through Every nums
        for(int n : nums)
        {
            // not in current perm
            if(!cur.contains(n))
            {
                // add to cur perm
                cur.add(n);

                // add next nums to Perm
                backTrack(nums, cur);

                // backTrack : remove lastly add nums from cur Perm
                cur.remove(cur.size()-1);
            }
        }
    }
}