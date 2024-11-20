class Solution {
    // Monotonic-Stack
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        // Hash Map to track { Element : Index }
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < nums1.length; i++)
        {
            // add nums1 {num : idx} to maintain Order in res
            index.put(nums1[i], i);
        }

        // res Array fill with Default -1 
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        // Stack always store element in Decreasing Order
        Deque<Integer> stack = new ArrayDeque<>();

        // take Each element for nums2
        for(int curNum : nums2)
        {
            // Stack Not Empty and CurNum great than stack top
            while(!stack.isEmpty() && curNum > stack.peek())
            {
                // Found Greater Element
                int top = stack.pop();

                // get Idx of top and add Greater Element
                res[index.get(top)] = curNum;
            }

            // CurNum less than top push to Stack
            if(index.containsKey(curNum))
            {
                stack.push(curNum);
            }
        }

        // return Next Greater Element
        return res;
    }
}