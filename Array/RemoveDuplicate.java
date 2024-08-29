class Solution {
    public int removeDuplicates(int[] nums) {
        // two pointer L - R
        int L = 1;
        for(int R=1; R<nums.length; R++)
        {
            // check prev if differ unique
            if(nums[R] != nums[R-1])
            {
                nums[L] = nums[R];
                L++;
            }
        }
        // unique count
        return L;
    }
}