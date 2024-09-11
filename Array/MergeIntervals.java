class Solution {
    public int[][] merge(int[][] intervals) {
       int n = intervals.length;

       // Sort based on Start of Interval
       Arrays.sort(intervals, (i, j) -> i[0] - j[0]);

       // List of Arrays to merge Intervals 
       List<int []> res = new ArrayList<>();
       // initialize with first Interval
       res.add(intervals[0]);

       // Interval [ start: 0, end: 1 ] 
       for(int i=1; i<n; i++)
       {
            // lastly Merged Interval
            int[] lastMerged = res.get(res.size() - 1);

            // OVERLAP - start <= prevEnd
            if(intervals[i][0] <= lastMerged[1])
            {
                // merge Prev and Cur Intervals
                lastMerged[1] = Math.max(lastMerged[1], intervals[i][1]);
            }
            else
            {
                // Non - Overlap , add
                res.add(intervals[i]);
            }
       }
       // res to Array
       return res.toArray(new int[res.size()][]);
    }
}