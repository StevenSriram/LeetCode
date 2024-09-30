class Solution {
    public void zigZag(int n, int[] arr) {
        boolean flag = true;
        
        // Check each Pair
        for(int i=0; i<n-1; i++)
        {
            // swap Variable
            int swap;
            
            // Increasing Pair
            if(flag)
            {
                if(arr[i] > arr[i+1])
                {
                    swap = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = swap;
                }
            }
            // Decreasing Pair
            else
            {
                if(arr[i] < arr[i+1])
                {
                    swap = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = swap;
                }
            }
            
            // toggle Zig_Zag
            flag = !flag;
        }
    }
}