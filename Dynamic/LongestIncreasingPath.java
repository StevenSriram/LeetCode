class Solution {
    /*  Dynamic Programming + Recursion  */

    int[][] dp;
    int[][] directions;

    // Longest Increasing Path in Matrix
    int res = 0;

    public void maxPath(int[][] matrix, int r, int c, int i, int j)
    {
        // already Path calculated from curIdx
        if(dp[i][j] != 0)   
            return;

        // max among four Directions
        int curPath = 0;

        for(int[] dist : directions)
        {
            int row = i + dist[0];
            int col = j + dist[1];

            // check Inbounds and Increasing Order
            if(row >=0 && row < r && col >= 0 && col < c
                && matrix[row][col] > matrix[i][j])
            {
                // maxPath from next Idx
                maxPath(matrix, r, c, row, col);

                // update maximum of all directions
                curPath = Math.max(curPath, dp[row][col]);
            }
        }

        // add current Number to max Path
        curPath++;

        // update DP table
        dp[i][j] = curPath;

        // maximum Path in matrix
        res = Math.max(res, curPath);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;

        // Dyanmic Programming for Memoization
        dp = new int[r][c];

        // Four Directions
        directions = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                // longest Increasing Path for each Idx
                maxPath(matrix , r, c, i, j);
            }
        }

        return res;
    }
}