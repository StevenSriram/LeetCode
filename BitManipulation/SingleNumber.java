class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums)
        {
            res ^= num;
            /*
                EX-OR : 
                    0 0 = 0
                    0 1 = 1
                    1 0 = 1
                    1 1 = 0
                
                x ^ 0 = x
                x ^ x = 0
            */
        }
        return res;
    }
}
/*
    000
    100 - 4
    100
    001 - 1
    101
    010 - 2
    111
    001 - 1
    110
    010 - 2
    100 => 4 (Single Number)
*/