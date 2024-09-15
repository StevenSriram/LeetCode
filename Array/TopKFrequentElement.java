class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /* 
            Optimal Bucket Sort 
            Time : O(n)  Space : O(n)
        */
        Map<Integer, Integer> count = new HashMap<>();
        // count occurance of character
        for(int num : nums)
        {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Count as Key / no. Number with count as Value
        List<Integer>[] freq = new List[nums.length + 1];
        for(int i=0; i<freq.length; i++)
        {
            freq[i] = new ArrayList<>();
        }

        // build Bucket Sort table
        count.forEach( (key, val) -> freq[val].add(key) );

        int[] res = new int[k];
        int idx = 0;
        for(int i=freq.length - 1; i>=0; i--)
        {
            for(int n : freq[i])
            {
                res[idx++] = n;
                if(idx == k)
                    return res;
            }
        }
        return res;
    }
}