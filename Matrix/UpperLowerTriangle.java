class Solution
{
    ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        int upperSum = 0;
        int lowerSum = 0;
        
        for(int i=0; i<n ;i++)
        {
            for(int j=0; j<n; j++)
            {
                // Row < Col - Upper Triangle
                if(i <= j)
                    upperSum += matrix[i][j];
                  
                // Row > Col - Lower Triangle  
                if(i >= j)
                    lowerSum += matrix[i][j];
            }
        }
        
        // ArrayList upperSum, LowerSum
        return new ArrayList<Integer>(Arrays.asList(upperSum, lowerSum));
    }
}