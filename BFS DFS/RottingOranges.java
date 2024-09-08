class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length, c = grid[0].length;

        // Queue for BFS
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                // rotten Oranges
                if(grid[i][j] == 2)
                    q.offer(new int[]{i, j});
                
                // fresh Oranges
                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        int[][] directions = { {-1,0}, {0,1}, {1,0}, {0,-1} };
        // track every Minute
        int minutes = 0;

        // if all fresh Oranges are rotten stop BFS
        while(!q.isEmpty() && fresh > 0)
        {
            // increment Minute
            minutes++;

            int len = q.size();
            for(int i=0; i<len; i++)
            {
                // BFS traversal from rotten oranges
                int[] cur = q.poll();

                for(int[] dist : directions)
                {
                    int row = cur[0] + dist[0];
                    int col = cur[1] + dist[1];

                    if(row >= 0 && row < r && col >= 0 && col < c 
                                                && grid[row][col] == 1)
                    {
                        // add rotting Oranges
                        q.offer(new int[]{row, col});
                        grid[row][col] = 2;

                        // decrement fresh Orange
                        fresh--;
                    }
                }
            }
        }
        // check all fresh are Rotten or Not
        return (fresh == 0) ? minutes : -1;
    }
} 