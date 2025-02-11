class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int r = maze.length, c = maze[0].length;

        // minimum No. of Move to Exits Maze
        int minMove = 0;

        // Breadth First Search
        Queue<int[]> q =  new ArrayDeque<>();
        int[][] directions = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

        // Entrance is Not Considered as Exit
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '#';

        while(!q.isEmpty())
        {
            // one Move to Cover cur Level
            minMove++;
            int qLen = q.size();

            // Level by Level Traversal
            for(int i=0; i<qLen; i++)
            {
                int[] cur = q.poll();

                // for all Directions
                for(int [] dist : directions)
                {
                    int row =  cur[0] + dist[0];
                    int col = cur[1] + dist[1];
                    
                    // check Inbounds and Path exits
                    if(row >= 0 && row < r && col >=0 && col < c 
                        && maze[row][col] == '.')
                    {
                        // check for End Cell - EXIT
                        if(row == 0 || row == r-1 || col == 0 || col == c-1)
                            return minMove;

                        // add to Queue for next Level
                        q.offer(new int[]{row, col});
                        maze[row][col] = '#';
                    }
                }
            }
        }
        // Can't able to EXIT
        return -1;
    }
}