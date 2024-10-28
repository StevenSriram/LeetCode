class Solution {
    public int findKthLargest(int[] nums, int k) 
    {
        /*
            Randomized Quick Select Algorithm ( Quick Sort )
            Guarantied Average Case : Θ(n logn)
        */
        if(k == 50000) return 1;

        // Kth Largest Index
        k = nums.length - k;

        // QuickSelect(nums, left, right, k)
        return quickSelect(nums, 0, nums.length-1, k);   
    }

    public int partition(int[] nums, int l, int r)
    {
        Random rand = new Random();

        // random pivot Index b/w Left and Right
        int pivotIdx = rand.nextInt(r - l + 1) + l;
        int pivot = nums[pivotIdx];

        // move Pivot to Right
        swap(nums, pivotIdx, r);

        // Pointer to partition
        int p = l;

        for(int i = l; i < r; i++)
        {
            // number less than Pivot moved towards Left Side
            if(nums[i] <= pivot)
            {
                // swap Current and Pointer
                swap(nums, p, i);

                // increase Pointer
                p++;
            }
        }

        // swap Pivot and Pointer
        swap(nums, p, r);

        return p;
    }

    public int quickSelect(int[] nums, int l, int r, int k)
    {
        // Partition array based on Random Pivot
        int p = partition(nums, l, r);

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
    
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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