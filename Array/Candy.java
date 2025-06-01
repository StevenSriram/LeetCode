class Solution {
    public int candy(int[] ratings) 
    {
        int n = ratings.length;

        // No. Candies for Each Child
        int[] distribute = new int[n];
        
        // Atleast 1 candy for Each
        Arrays.fill(distribute, 1);

        // Left to Right pass:        
        for(int i = 1; i < n; i++)
        {
            /* 
                If cur Child's rating is greater than Prev neighbor,
                give one more candy than Prev child
            */
            if(ratings[i] > ratings[i-1])
                distribute[i] = distribute[i-1] + 1;
        }

        // Right to Left pass:        
        for(int i = n-2; i >= 0; i--)
        {
            /*
                If cur Child's rating is greater than Next neighbor,
                and Only if cur Child has Less Candies than Next child

                give one more candy than the Next child
            */
            if(ratings[i] > ratings[i+1] && distribute[i] <= distribute[i+1])
                distribute[i] = distribute[i+1] + 1;
        }

        // Total Candies distributed
        return Arrays.stream(distribute).sum();
    }
}
