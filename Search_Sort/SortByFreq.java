/*
  ?  ⚠️ Java auto-unboxes Integer to int when using < or >
  ?   BUT: DO NOT use '==' to compare Integer objects directly

  #  Java caches Integer values from -128 to 127 to 
        improve performance and save memory.

        Integer a = 127, b = 127;
  #      System.out.println(a == b); // true

        Integer x = 128, y = 128;
  #      System.out.println(x == y); // false

        For values outside the cache range,
                Java creates new objects, so == fails.
*/

class Solution {
    Map<Integer, Integer> countMap;

    public void merge(int[] nums, int l, int mid, int r)
    {
        // Temp : store Merged Array
        int[] temp = new int[r - l + 1];
        int idx = 0;

        // Split : [l , mid]  [mid+1 , r]
        int i = l, j = mid + 1;

        while(i <= mid && j <= r)
        {
            /*
                check count[Left] < count[right] OR
                    if two values Same then compare right > left
            */
            if ( countMap.get(nums[i]) < countMap.get(nums[j]) || 
                 countMap.get(nums[i]).equals(countMap.get(nums[j])) && 
                        nums[i] > nums[j] )
            {
                // copy from Left half
                temp[idx++] = nums[i++];
            }

            else
            {
                // copy from Right half
                temp[idx++] = nums[j++];
            }
        }

        // Copy remaining elements from Left half
        while(i <= mid)
        {
            temp[idx++] = nums[i++];
        }

        // Copy remaining elements from Right half
        while(j <= r)
        {
            temp[idx++] = nums[j++];
        }

        // Copy sorted temp array back to nums
        for(idx = 0; idx < temp.length; idx++)
        {
            nums[l + idx] = temp[idx];
        }
    }

    public void sort(int[] nums, int l, int r)
    {
        if(l < r)
        {
            // compute Middle
            int mid = l + (r - l) / 2;

            // recursively Split into Two
            sort(nums, l, mid);
            sort(nums, mid + 1, r);

            // Merge two Arrays
            merge(nums, l, mid, r);
        }
    }

    public int[] frequencySort(int[] nums)
    {
        countMap = new HashMap<>();
        for(int num : nums)
        {
            // Map to count frequency of each number
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Sort array using Merge Sort
        sort(nums, 0, nums.length - 1);

        return nums;
    }
}

/*
    Compartor Sort : 
        we can't use Comparator on primitive int - works only on Objects
        
    List<Integer> res = Arrays.stream(nums)
                                .boxed()
                                .collect(Collectors.
                                            toCollection(ArrayList::new));

    Collections.sort(res, (a, b) -> {
        int freqDiff = countMap.get(a) - countMap.get(b);
        
        if(freqDiff == 0)
            return b - a;
        
        return freqDiff;
    });                        

    return res.stream().mapToInt(Integer::intValue).toArray();   
*/