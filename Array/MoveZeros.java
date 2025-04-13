class Solution {
    public void moveZeroes(int[] nums) 
    {
        int n = nums.length;

        // Pointer to track pos of next non-zero element
        int l = 0;

        // Traverse array with right pointer
        for (int r = 0; r < n; r++) 
        {
            // If current element is not zero
            if (nums[r] != 0) 
            {
                // Swap current element with element at index 'l'
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;

                // Move left pointer forward
                l++;
            }
        }
    }
}
