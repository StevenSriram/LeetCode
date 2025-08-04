public class Solution {
    public void alternateSort(int[] nums) 
    {
        /* Selection Sort : with Alternating Min/Max */
        int n = nums.length;

        // Loop until N - 1
        for (int i = 0; i < n - 1; i++) 
        {
            // Consider cur as Min/Max index
            int minMaxIdx = i;

            // Find Min/Max in remaining nums
            for (int j = i + 1; j < n; j++) 
            {
                /*  
                    If index is EVEN, find Maximum
                    If index is ODD, find Minimum
                */
                boolean condition = (i % 2 == 0) ?
                        nums[j] > nums[minMaxIdx] : nums[j] < nums[minMaxIdx];

                // Update if Max/Min found
                if (condition) 
                {
                    minMaxIdx = j;
                }
            }

            // Swap found element with cur index
            if (minMaxIdx != i) 
            {
                int temp = nums[i];
                nums[i] = nums[minMaxIdx];
                nums[minMaxIdx] = temp;
            }
        }
    }
}
