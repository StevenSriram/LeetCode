class Solution {
    int r;  // Rows in Board
    int c;  // Cols in Board

    int n;  // No. of chars in Words

    public boolean exist(char[][] board, String word) 
    {
        r = board.length;
        c = board[0].length;

        n = word.length();

        // Special Case : only Single element
        if(r == 1 && c == 1 && n == 1)
        {
            // check Matches
            return board[0][0] == word.charAt(0);
        }

        // go through Every position in Grid
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                // if one Path found - Word exits
                if( backTrack(new int[]{i ,j}, 0, board, word) )
                    return true;
            }
        }

        // Word - Not exits
        return false;
    }

    public boolean backTrack(int[] pos, int idx, char[][] board, String word)
    {
        int i = pos[0], j = pos[1];

        // word exits in Grid
        if(idx == n)
            return true;

        // char Not Matched
        if(board[i][j] != word.charAt(idx))
            return false;

        // Directions Array - Four way
        int[][] directions = { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };

        // store cur_Char - later Use
        char ch = board[i][j];

        // mark Visited
        board[i][j] = '#';

        // go through every directions
        for(int[] dist : directions)
        {
            int row = i + dist[0];
            int col = j + dist[1];

            // check Inbounds
            if(row >= 0 && row < r && col >=0 && col < c)
            {
                // backTrack(newPos, nextIdx)
                if( backTrack(new int[]{row, col}, idx + 1, board, word) )
                    return true;
            }
        }

        // BackTrack : reset char
        board[i][j] = ch;

        // cur Pos - not Matched
        return false;
    }
}