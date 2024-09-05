class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 0(1) - both insert / check
        HashSet<Integer> set = new HashSet<>();

        for(int x : nums)
        {
            // duplicate
            if(set.contains(x))
                return true;
            set.add(x);
        }
        return false;
    }
}