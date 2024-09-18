class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // Number of Islands Logic
        if(grid.length == 0) return 0;

        // max Area of Island
        int maxCount = 0;

        int r = grid.length, c = grid[0].length;
        // Queue fro BFS traversal
        Queue<int[]> q = new LinkedList<>();

        // check all Directions ( top, right, bottom, left )
        int[][] directions = { {-1,0}, {0,1}, {1,0}, {0,-1} };

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                // 1 - Island
                if(grid[i][j] == 1)
                {
                    // count cur Island Area
                    int count = 0;
                    // add to Queue, mark visited
                    q.offer(new int[]{i, j});
                    grid[i][j] = 2;

                    // BFS traversal from cur Island
                    while(!q.isEmpty())
                    {
                        int[] cur = q.poll();
                        // increment Area
                        count++; 

                        // check Bounds
                        for(int[] dist : directions)
                        {
                            int row = cur[0] + dist[0];
                            int col = cur[1] + dist[1];

                            if(row >= 0 && row < r && col >= 0 && col < c
                                            && grid[row][col] == 1)
                            {
                                // add to Queue, mark visited
                                q.offer(new int[]{row, col});
                                grid[row][col] = 2;
                            }
                        }
                    }

                    // update Max Area of Island
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }
}