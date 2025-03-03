class Solution{
     public boolean balancedSums(int[] nums) 
     {
        // sum Left to Number
        int left = 0;

        // Total Sum Array (Int Stream)
        int right = Arrays.stream(nums).sum();
        
        for(int num : arr)
        {
            // exclude curNum for rightSum
            right -= num;
            
            // Left equals Right - Found
            if(left == right)
            {
                return true;
            }
            
            // add Num to leftSUm
            left += num;
        }
        
        // Not Found
        return false;
    }
}