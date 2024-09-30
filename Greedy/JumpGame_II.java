class Solution {
    public int jump(int[] nums) {
        /* One Dimensional BFS */
        int minJump = 0;

        // BFS area
        int l = 0, r = 0;
        
        // if we reached Goal(n-1) return
        while(r < nums.length-1)
        {
            int farthest = 0;
            for(int i=l; i<=r; i++)
            {
                // farthest Region reach from current area (l, r)
                farthest = Math.max(farthest, i + nums[i]);
            }

            // left = next Region(right + 1)
            l = r + 1;
            // right = longest Region(farthest) 
            r = farthest;

            // jump to next Area
            minJump++;
        }

        // Minimum Number of Jumps
        return minJump;
    }
}