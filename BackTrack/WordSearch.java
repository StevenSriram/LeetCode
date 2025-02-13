class Solution {
    int r;  // Rows in Board
    int c;  // Cols in Board

    int n;  // No. of chars in Words
    int[][] directions;


    public boolean backTrack(int i, int j, int idx, char[][] board, String word)
    {
        // reaches End - All Word Matches or Only One Char
        if(idx == n || n == 1)
            return true;

        // Char at board Not Matches 
        if(board[i][j] != word.charAt(idx))
            return false;

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
           if(row >= 0 && row < r && col >= 0 && col < c)
           {
                // backTrack(newPos, nextIdx)
                if(backTrack(row, col, idx + 1, board, word))
                    return true;
           }
        }

        // BackTrack : reset char
        board[i][j] = ch;
        
        // cur Path - not Matched
        return false;
    }

    public boolean exist(char[][] board, String word) 
    {
        r = board.length;
        c = board[0].length;

        n = word.length();

        // Directions Array - Four way
        directions = new int[][]{ {0,-1}, {1,0}, {0,1}, {-1,0} };

        // go through Every position in Grid
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                // first char Matches check - Word exits
                if( board[i][j] == word.charAt(0) && 
                    backTrack(i, j, 0, board, word) )
                {
                    // Word Found
                    return true;
                }
            }
        }
        // Word Not Found
        return false;
    }
}