class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // all permutations
        List<List<Integer>> perms = new ArrayList<>();
        // intialize with Empty Permutation
        perms.add(new ArrayList<>());

        // take each number
        for(int n : nums)
        {
            // current updated Permutations
            List<List<Integer>> newPerms = new ArrayList<>();

            // take every permuations
            for(List<Integer> p : perms)
            {
                // insert at the every position of existing Permutaions
                for(int i=0; i<=p.size(); i++)
                {
                    List<Integer> copy = new ArrayList<>(p);
                    copy.add(i, n);
                    // add to current Permutaions
                    newPerms.add(copy);
                }
            }
            // update with  new Permuation
            perms = newPerms;
        }
        return perms;
    }
}