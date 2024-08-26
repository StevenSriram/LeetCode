class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        // for Finding Repated Element
        Set<Character> set = new HashSet<>();

        int maxLen = 0;
        int start = 0;

        for(int end=0; end<s.length(); end++)
        {
            // current Character
            char cur = s.charAt(end);
            
            //if current present in set remove all prev till duplicate is removed
            while(set.contains(cur))
            {
                set.remove(s.charAt(start));
                start++;
            }

            // add cur element
            set.add(cur);

            // find MaxLength comparing start to end
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}