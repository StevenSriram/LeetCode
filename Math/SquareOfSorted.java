class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        // Squares in sorted order [-4, 0, 2] -> [0, 4, 16]
        int[] res = new int[n];

        // Fill from Reverse Sorted Order
        int idx = n - 1;

        // Two Pointers : L - start, R - end
        int l = 0, r = n - 1;

        // Loop until Pointers Overlap
        while (l <= r) 
        {
            // Compare absolute values at both ends
            if (Math.abs(nums[l]) > Math.abs(nums[r])) 
            {
                // Square largest Val - move Left
                res[idx--] = nums[l] * nums[l];
                l++; 
            }
            else 
            {
                // Square largest Val - move Right
                res[idx--] = nums[r] * nums[r];
                r--; 
            }
        }

        return res;
    }
}
