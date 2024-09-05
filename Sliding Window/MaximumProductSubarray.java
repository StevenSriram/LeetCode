class Solution {
    public int maxProduct(int[] nums) {
        // 1 - neutral value for Multiplication
        int leftProd = 1;
        int rightProd = 1;

        int maxProd = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++)
        {
            leftProd *= nums[i];
            rightProd *= nums[nums.length - 1 - i];

            // max of Left and Right Product
            maxProd = Math.max(maxProd, Math.max(leftProd, rightProd));

            // 0 (kills Prod) - reset Product
            if(leftProd == 0) 
                leftProd = 1;
                
            if(rightProd == 0) 
                rightProd = 1;
        }
        return maxProd;
    }
}