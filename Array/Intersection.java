class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Intersection 
        Set<Integer> intersection = new HashSet<>();

        // set for Manipulatation
        Set<Integer> set = new HashSet<>();

        // add nums1 to Set
        for(int n : nums1)
            set.add(n);
        
        // contains in Set remove from Set
        for(int n : nums2)
        {
            if(set.contains(n))
            {
                // add to Intersection
                intersection.add(n);
                set.remove(n);
            }
        }
        
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}