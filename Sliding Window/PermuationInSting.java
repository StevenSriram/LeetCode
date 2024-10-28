class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        // Fixed Size Sliding Window ( n1 )
        int n1 = s1.length(), n2 = s2.length();

        if(n1 > n2)
            return false;

        // Alphabets Array 
        int[] size1 = new int[26];
        int[] size2 = new int[26];

        // build up the intial Window of size n1
        for(int i=0; i<n1; i++)
        {
            size1[s1.charAt(i) - 'a']++;
            size2[s2.charAt(i) - 'a']++;
        }
        // premuations mathched at beginning
        if(Arrays.equals(size1, size2))
            return true;

        // Slide the Window
        for(int i=n1; i<n2; i++)
        {
            //  add the next Char
            size2[s2.charAt(i) - 'a']++;
            // remove the first Char
            size2[s2.charAt(i - n1) - 'a']--;

            // premutation Matches
            if(Arrays.equals(size1, size2))
               return true;
        }

        // premutation doesn't Matches
        return false;
    }
}