class Solution {
    /*
        [1, 3]      n = 6

        Patch 2 : maxNumBefore + currentPatch (maxNumBefore + 1)
                    1 + 2 => 3 (we can achive 3 so far)

        [1, {2}, 3] = 3 + 3 => 6
    */
    
    public int minPatches(int[] nums, int n) 
    {
        int i = 0, size = nums.length;

        // Mininum No. of Patches required to get all Sum until N
        int minPatches = 0;

        // Maximum No. of Sum get So Far
        long maxNumSoFar = 0;

        // while maxSum less than N
        while(maxNumSoFar < n)    
        {
            // size Inbounds & looking for number after currentMaxSum
            //  if greater than Nums[i] - No Need to Patch
            if(i < size && (maxNumSoFar + 1) >= nums[i])
            {
                // we get Sum until this Number
                maxNumSoFar += nums[i];

                // move to Next Number
                i++;
            }

            // currentMaxSum + 1 : can't Achiveable
            // Need to Patch next Number
            else
            {
                // patching a Number to Array
                minPatches++;

                // we get Sum until this next Number
                maxNumSoFar += (maxNumSoFar + 1);
            }
        }

        return minPatches;
    }
}