class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int row = matrix.length, col = matrix[0].length;

        /* 2-D Binary Search : 
                Consider Matrix into Flatten Array
                l = 0   r = (row * col) - 1

                L [1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 60] R
                                    M
                Mid = (l + r) / 2

                mid is the index of Flatten Array, to find mid index in Matrix
                    i = mid / col 
                    j = mid % col

                    Index* of Flatten Array in Matrix
                    [ 0, 1, 2, 3
                      4, 5, 6, 7        5 / 4 = 1st Row
                      8, 9, 10, 11 ]    5 % 4 = 1st Col
        */
        int l = 0, r = (row * col) - 1;

        while(l <= r)
        {
            int mid = (l + r) / 2;

            int i = mid / col;
            int j = mid % col;

            // target less than Middle
            if(target < matrix[i][j])
            {
                r = mid - 1;
            }
            // target great than Middle
            else if(target > matrix[i][j])
            {
                l = mid + 1;
            }
            // Target Found
            else
            {
                return true;
            }
        }
        // Target Not Found        
        return false;
    }
}