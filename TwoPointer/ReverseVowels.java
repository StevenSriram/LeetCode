class Solution {
    // check Character is a Vowel or not
    public boolean isVowel(char c)
    {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    // Swap two Vowel Characters
    public void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];   
        arr[i] = arr[j];       
        arr[j] = temp;         
    }

    public String reverseVowels(String s) 
    {
        char[] arr = s.toCharArray();   

        int l = 0, r = arr.length - 1;  

        // Loop until the Two pointers meet
        while(l < r)
        {
            // Move left pointer until a vowel is found
            while(l < r && !isVowel(arr[l]))
                l++;
            
            // Move right pointer until a vowel is found
            while(l < r && !isVowel(arr[r]))
                r--;
            
            // Swap the vowels at the left and right 
            swap(arr, l, r);

            // Move both pointers inward
            l++;
            r--;
        }

        return new String(arr); 
    }
}
