class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        /*
            set Bounds on all four direction, if exceeds bound chage direction
        */
        List<Integer> res =  new ArrayList<>();

        // four Bounds T, B, L, R
        int top = 0, bottom = matrix.length;
        int left = 0, right = matrix[0].length;
        
        while(top < bottom && left < right)
        {
            // for every i from L - R
            for(int i=left; i<right; i++)
            {
                res.add(matrix[top][i]);
            }
            top++;

            // for every i from L - R
            for(int i=top; i<bottom; i++)
            {
                res.add(matrix[i][right-1]);
            }
            right--;

            // check for ending of spiral traversal order
            if(! (left < right && top < bottom))
            {
                break;
            }

             // for every i from R - L
             for(int i=right-1; i>=left; i--)
             {
                res.add(matrix[bottom-1][i]);
             }
             bottom--;

             // for every i from B - T
             for(int i=bottom-1; i>=top; i--)
             {
                res.add(matrix[i][left]);
             }
             left++;
        }
        return res;
    }
}