class Solution {
    public void rotate(int[] nums, int k) 
    {
        /*
            Rotate Array by 3 times : [1,2,3,4,5,6,7]

            Reverse whole Array : [7,6,5,4,3,2,1]

            Reverse first 3 elements : [5,6,7 , 4,3,2,1]

            Reverse remaining elements : [5,6,7 , 1,2,3,4]
        */
        int n = nums.length;
        // stay On Range
        k = k % n;

        // Reverse whole Array
        reverse(nums, 0, n-1);

        // Reverse first K elements
        reverse(nums, 0, k-1);

        // Reverse remaining elements
        reverse(nums, k, n-1);
    }

    // Helper func to Reverse Array
    public void reverse(int[] nums, int l, int r)
    {
        // not Cross Over
        while(l <= r)
        {
            // swap left and right
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            // Inc left, Dec right
            l++;
            r--;
        }
    }
}