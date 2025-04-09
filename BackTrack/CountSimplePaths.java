public class Solution {
    // No. of valid paths of length K
    int paths = 0;

    // Four directions: up, right, down, left
    int[][] directions;

    public void backTrack(int i, int j, char[][] grid, int move, int K) 
    {
        // If we moved K steps
        if (move == K) 
        {
            // count Path
            paths++;
            return;
        }

        // mark the cur as Visited
        grid[i][j] = '$';

        for (int[] dist : directions) 
        {
            int row = i + dist[0]; 
            int col = j + dist[1]; 

            // Check next pos is Valid
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                     && grid[row][col] == '.') 
            {
                // Recursively move to the next position
                backTrack(row, col, grid, move + 1, K);
            }
        }

        // BackTrack :  Unmark the cur pos
        grid[i][j] = '.';
    }

    public int countPaths(char[][] grid, int K) 
    {
        int r = grid.length, c = grid[0].length;

        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // Iterate Over grid
        for (int i = 0; i < r; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                // '.' - Count Valid Paths from here
                if (grid[i][j] == '.') 
                {
                    backTrack(i, j, grid, 0, K);
                }
            }
        }
        
        return paths;
    }
}
