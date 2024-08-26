class Solution {
    public double findMaxAverage(int[] nums, int k) 
    {
        // Siliding Window Solution 
        int n = nums.length;

        // Initilize Cur_Sum
        double cur_sum = 0;

        //Build up Window
        for(int i=0;i<k;i++)        
            cur_sum += nums[i];
        
        // Initialize Max_Avg
        double max_avg = cur_sum / k;
        /*
            add next - nums[k]
            remove prev - nums[i-k]
        */
        for(int i=k;i<n;i++)
        {
            cur_sum += nums[i];
            cur_sum -= nums[i-k];

            double avg = cur_sum / k;
            // Compare Max_Avg
            max_avg = Math.max(avg, max_avg);
        }
        return max_avg;
    }
}