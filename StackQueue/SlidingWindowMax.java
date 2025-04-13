class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        // Max of each sliding window
        List<Integer> windowMax = new ArrayList<>();

        // Monotonically Decreasing Deque [ Indices ]
        Deque<Integer> q = new ArrayDeque<>();

        // Initial Window of K
        for(int i = 0; i < k; i++)
        {
            // Remove elements from Last deque,
            //  if curNum greater than nums[Last]
            while(! q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.pollLast();

            // Add cur Index to deque
            q.offerLast(i);
        }
        // First : Max of Initial Window
        windowMax.add(nums[q.peekFirst()]);

        for(int i = k; i < nums.length; i++)  
        {
            // Remove elements from Last deque,
            //  if curNum greater than nums[Last]
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.pollLast();
            
            // Add cur Index to deque
            q.offerLast(i);

            // Remove First if it's outside of cur Window
            if(q.peekFirst() == i - k)
                q.pollFirst();
            
            // First : Max of cur Window
            windowMax.add(nums[q.peekFirst()]);
        }

        return windowMax.stream().mapToInt(Integer::intValue).toArray();
    }
}
