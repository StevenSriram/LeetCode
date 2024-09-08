class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                // ignore (0, 0) grid
                if(i == 0 && j == 0)
                    continue;

                // left and down - infinity
                int leftPath, downPath;
                leftPath = downPath = Integer.MAX_VALUE;

                // DownSide Sum
                if(i != 0)
                    downPath = grid[i][j] + grid[i-1][j];

                // LeftSide Sum
                if(j != 0)
                    leftPath = grid[i][j] + grid[i][j-1];

                // min Path Sum
                grid[i][j] = Math.min(leftPath, downPath);
            }
        }
        // Optimal Time : O(m x n)  Space : O(1)
        return grid[r-1][c-1];
    }
}