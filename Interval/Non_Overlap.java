class Solution {
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        // Sort the Interval based on Start
        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);

        int minRemove = 0;

        // No need to remove Overlaped Interval
        int prevEnd = intervals[0][1];

        // start from 1 - First Interval
        for(int i = 1; i < intervals.length; i++)
        {
            // Over - Lap : curStart less than prevEnd
            if(intervals[i][0] < prevEnd)
            {
                // need to remove Interval
                minRemove++;

                /* Min has Less chance of Overlap */

                // update with Minimum of both End
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
            else
            {
                // move prevEnd to curEnd
                prevEnd = intervals[i][1];
            }
        }
        
        // Minimum Interval to remove - make Non - Ovrelap
        return minRemove;
    }
}