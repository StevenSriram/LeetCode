class Solution {
    public void reverseString(char[] s) 
    {
        // Two Pointers - L, R
        int l = 0, r = s.length - 1;

        // Not Cross Over
        while(l < r)    
        {
            // Swap (L , R)
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            // move Pointers
            l++;
            r--;
        }
    }
}