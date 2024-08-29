class Solution {
    public int maxArea(int[] height) {

        int res = 0;

        // two pointers L - R
        int left = 0, right = height.length - 1;

        while(left < right)
        {
            // Area = Width x Height
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);

            // increase bottle-neck
            if(height[left] < height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return res;
    }
}