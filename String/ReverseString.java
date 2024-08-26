class Solution 
{
    public void reverseString(char[] s) 
    {
        int i = 0,j = s.length;
        while(i < j)
        {
            char temp = s[i];
            s[i] = s[--j];
            s[j] = temp;
            i++;
        }
        System.out.println(s);
        
    }
}