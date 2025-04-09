class Solution {
    public int[] rankWithTies(int[] nums) 
    {
        int n = nums.length;

        // Ranks assigned to each Value
        int[] rankings = new int[n]; 
        

        /* Integer for Sort using Comparator */
        Integer[] indices = new Integer[n];

        // indices of original Values 
        for(int i=0; i<n; i++)
            indices[i] = i; 
          
        // Sort indices in descending order of values
        Arrays.sort(indices, (i, j) -> nums[j] - nums[i]);
        
        int rank = 1;
        for(int i=0; i<n; i++) 
        {
            // index of Max Value
            int maxIdx = indices[i];
            
            // Update rank when value changes 
            if(i > 0 && nums[indices[i]] != nums[indices[i-1]])
            {
                // Competition ranking (1, 1, 2) <- {rank 3}
                rank = i + 1; 
            }
              
            // Assign rank to original position
            rankings[maxIdx] = rank; 
        }
        
        return rankings;
    } 
}