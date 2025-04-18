/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) 
    {
        int n = intervals.size();

        // Sort Intervals based on their Start time
        Collections.sort(intervals, (i, j) -> i.start - j.start);

        // Check for any overlapping intervals
        for (int i = 1; i < n; i++) 
        {
            Interval prev = intervals.get(i - 1); // Prev meeting
            Interval cur = intervals.get(i);      // Cur meeting

            // If cur meeting starts before prev meeting ends, there's a conflict
            if (cur.start < prev.end)
                return false;
        }

        // No conflicts found; all meetings can be attended
        return true;
    }
}
