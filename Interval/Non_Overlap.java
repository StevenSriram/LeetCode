class Solution {
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        /*
            Sorting by End ensures choosing the interval that 
            leaves the most room for future intervals.
        */

        // Sort the Interval based on End
        Arrays.sort(intervals, (i, j) -> i[1] - j[1]);

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