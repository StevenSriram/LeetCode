class Solution {
    int SIZE = 9; // Board (9x9)
    int SG = 3;  // SubGrid (3x3)
    
    public boolean isValidSudoku(char[][] board) 
    {
        /*
            Bit Masking : 
                use bits to keep track of which digits are already
                 used in each Row, Col, and SubGrid.
        */
        int[] rowFlag = new int[SIZE];     
        int[] colFlag = new int[SIZE];     
        int[] subGridFlag = new int[SIZE]; 

        // Iterate over each cell in the board
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[0].length; c++)
            {
                // Skip empty cells
                if(board[r][c] == '.') 
                    continue;

                /*
                    Index of subgrid (3x3 region) :
                        (Row / 3) * 3 + (Col / 3)
                */
                int subIdx = (r / SG) * SG + (c / SG);
                int digit = board[r][c] - '0';

                // Check Digit used in row, column, or subgrid
                if(
                    (rowFlag[r] & (1 << digit)) != 0 ||  
                    (colFlag[c] & (1 << digit)) != 0 || 
                    (subGridFlag[subIdx] & (1 << digit)) != 0 
                  )
                {
                    // Not Valid Suduko
                    return false; 
                }

                // Mark digit as used in row, column, and subgrid
                rowFlag[r] |= (1 << digit);
                colFlag[c] |= (1 << digit);
                subGridFlag[subIdx] |= (1 << digit);
            }
        }

        // Valid Suduko
        return true;
    }
}
