class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // count no. Jewels in Stones
        int count = 0;

        /*
           uses Hash to Check element exists in Set at Constant Time O(1)
        */
        Set<Character> set = new HashSet<>();

        // add jewels
        for(char c : jewels.toCharArray())
        {
            set.add(c);
        }

        // check stone is a jewel
        for(char c : stones.toCharArray())
        {
            if(set.contains(c))
                count++;
        }
        
        return count;
    }
}