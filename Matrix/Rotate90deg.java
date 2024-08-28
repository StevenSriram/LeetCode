class Solution {
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        //Transpose Matrix
        for(int i=0; i<r; i++)
        {
            // Start from i to avoid redundant swaps
            for(int j=i; j<c; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int[] row : matrix)
        {
            // reverse Row to rotate 90°
            for(int i=0; i<row.length/2; i++)
            {
                int temp = row[i];
                row[i] = row[row.length - 1 - i];
                row[row.length - 1 - i] = temp;
            }
        }
    }
}