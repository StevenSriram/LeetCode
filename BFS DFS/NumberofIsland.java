class Solution {
    public int numIslands(char[][] grid) 
    {
       if(grid == null || grid.length == 0)
        return 0;

        // number of Island
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        // BFS - traversal
        Queue<int []> q = new LinkedList<>();

        // all diection TOP - RIGHT - BOTTOM - LEFT
        int[][] direction = { {0,-1}, {1,0}, {0,1}, {-1,0} };

        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                // if island increase count
                if(grid[i][j] == '1')
                {
                    count++;
                    q.add(new int[]{i, j});
                    grid[i][j] = '2';  // mark Visited

                    while(!q.isEmpty())
                    {
                        // poll and check all direction
                        int[] cur = q.poll();
                        for(int[] dist : direction)
                        {
                            int r = cur[0] + dist[0];
                            int c = cur[1] + dist[1];
                            
                            // wheather it exceeds linit
                            if(r>=0 && r<row && c>=0 && c<col && grid[r][c] == '1')
                            {
                                // add to queue and mark visited
                                q.add(new int[]{r, c});
                                grid[r][c] = '2';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}