class Solution{
     public String balancedSums(List<Integer> arr) 
     {
        // Total Sum Array
        int total = arr.stream().mapToInt(Integer::intValue).sum();
        
        // sum Left to Number
        int left = 0;
        for(int num : arr)
        {
            // Right = Total - LeftSum - curNum
            int right = total - left - num;
            
            // Left equals Right - Found
            if(left == right)
            {
                return "YES";
            }
            
            // add Num to Left
            left += num;
        }
        
        // Not Found
        return "NO";
    }
}
