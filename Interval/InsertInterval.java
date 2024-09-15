class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        // Inserted Interval
        List<int[]> res = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            // Insert before Interval
            // newInterval end is less than curInterval
            if(newInterval[1] < intervals[i][0])
            {
                // intermediate insertion of nweInterval
                res.add(newInterval);
                for(int[] a : Arrays.copyOfRange(intervals, i, n))
                {
                    res.add(a);
                }
                return res.toArray(new int[res.size()][]);
            }
            // Insert after Interval
            // newInterval start is great than curInterval
            else if(newInterval[0] > intervals[i][1])
            {
                res.add(intervals[i]);
            }
            // Overlap
            else
            {
                // minimum of Start's
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                // maximum of End's
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        // end insertion of newInterval
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}