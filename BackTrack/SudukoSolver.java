class Solution {
    int SIZE = 9, SG = 3;

    int[] rowFlag;
    int[] colFlag;
    int[] subGridFlag;

    public boolean backTrack(char[][] board, int r, int c)
    {
        // reached end ROW - Suduko Solved
        if(r == SIZE)
            return true;

        // reached end COL - move to next ROW
        if(c == SIZE)
            return backTrack(board, r + 1, 0);

        // Board aready Filled with Num - move to next COL
        if(board[r][c] != '.')
            return backTrack(board, r, c + 1);

        // Try Placing Digits from [0-9]
        for(int digit = 0; digit < SIZE; digit++)
        {
            int subIdx = (r / SG) * SG + (c / SG);

            // check Digit already placed in row, col, subGrid 
            if(
                (rowFlag[r] & (1 << digit)) != 0 ||
                (colFlag[c] & (1 << digit)) != 0 ||
                (subGridFlag[subIdx] & (1 << digit)) != 0
              )
            {
                continue;
            }

            // place this Number
            board[r][c] = (char) (digit + '1');

            // mark Digits Used
            rowFlag[r] |= (1 << digit);
            colFlag[c] |= (1 << digit);
            subGridFlag[subIdx] |= (1 << digit);

            // move to next COL
            if(backTrack(board, r, c + 1))
                return true;

            // BackTrack : reset to .
            board[r][c] = '.';

            // reset Digits Used
            rowFlag[r] ^= (1 << digit);
            colFlag[c] ^= (1 << digit);
            subGridFlag[subIdx] ^= (1 << digit);
        }

        // can't place a Number
        return false;
    }

    public void solveSudoku(char[][] board) 
    {
        rowFlag = new int[SIZE];
        colFlag = new int[SIZE];
        subGridFlag = new int[SIZE];

        // prefill Board State
        for(int r=0; r<board.length; r++)
        {
            for(int c=0; c<board[0].length; c++)
            {
                if(board[r][c] == '.')
                    continue;
                
                int subIdx = (r / SG) * SG + (c / SG);
                int digit = board[r][c] - '1';

                rowFlag[r] |= (1 << digit);
                colFlag[c] |= (1 << digit);
                subGridFlag[subIdx] |= (1 << digit);
            }
        }

        // solve(baord, row, col)
        backTrack(board, 0, 0);
    }
}