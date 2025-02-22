class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // Sum of N Natural numbers
        int total = (n * (n + 1)) / 2;

        // Sum of Array
        int sum = 0;
        for(int num : nums)
            sum += num;

        // Missing Number
        return total - sum;
    }
}
