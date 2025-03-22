class Solution {
    public int maxSubmatrixSum(int[][] matrix, int k) 
    {
        int n = matrix.length;
        int m = matrix[0].length;

        // Prefix Sum matrix
        int[][] prefixSum = new int[n + 1][m + 1];
        /*
            fill First Row & Col with 0 - Edge case handling

            prefixSum[0][Row] = 0;
            prefixSum[Col][0] = 0;
        */


        for (int i = 1; i <= n; i++) 
        {
            for (int j = 1; j <= m; j++) 
            {
                /*
                    curPrefix = curNum in Matrix 
                            + prefix Prev Row + prefix Prev Col 

                        Overlapping Case: [row][col] addes Twice
                            - prefix Prev Row & Col
                */
                prefixSum[i][j] = matrix[i - 1][j - 1] 
                                + prefixSum[i - 1][j] 
                                + prefixSum[i][j - 1] 
                                - prefixSum[i - 1][j - 1];
            }
        }

        // maximum Submatrix Sum K
        int maxSum = Integer.MIN_VALUE;

        // iterate from K to N [ k x k => Submatrix ]
        for (int i = k; i <= n; i++) 
        {
            for (int j = k; j <= m; j++) 
            {
                /*
                    curSum = curPrefix 

                        Eliminate prefixSum of Prev Submatrix:
                            - (prefix Row-K) - (prefix Col-k) 

                        Overlapping Case: [row][col] subracts Twice
                            + prefix Prev Row & Col
                */
                int currentSum = prefixSum[i][j] 
                            - prefixSum[i - k][j] 
                            - prefixSum[i][j - k] 
                            + prefixSum[i - k][j - k];

                if (currentSum > maxSum) 
                {
                    // update maxSum
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }
}