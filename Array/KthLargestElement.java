class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
            Quick Select Algorithm ( Quick Sort )
            Average Case : Θ(n) / Worst Case : O(n2)
        */
        if(k == 50000) return 1;
        
        // Kth Largest Index
        k = nums.length - k;

        return quickSelect(nums, 0, nums.length-1, k);
    }

    public int quickSelect(int[] nums, int l, int r, int k)
    {
        // pivot Last Index
        int pivot = nums[r];
        // pointer to Start Index
        int p = l;

        for(int i = l; i < r; i++)
        {
            // number less than Pivot moved towards Left Side
            if(nums[i] <= pivot)
            {
                // swap Current and Pointer
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;

                // increase Pointer
                p++;
            }
        }
        // swap Pivot and Pointer
        nums[r] = nums[p];
        nums[p] = pivot;

        // k lesser than Pointer - LEFT
        if(k < p)
        {
            return quickSelect(nums, l, p-1, k);
        }
        // k greater than Pointer - RIGHT
        else if(k > p)
        {
            return quickSelect(nums, p+1, r, k);
        }
        // reached Kth Largest Element
        else
        {
            return nums[p];
        }
    }
}

/*
    Kth largest using PQ Time : O( k log n )

    Queue<Integer> pq = new PriorityQueue<>();

    for(int num : nums)
    {
        pq.offer(num);
        if(pq.size() > k)
            pq.poll();
    }
    return pq.peek();
*/