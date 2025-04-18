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
    public int minMeetingRooms(List<Interval> intervals) 
    {
        // Lists of all Start and End times separately
        List<Integer> startTime = new ArrayList<>();
        List<Integer> endTime = new ArrayList<>();

        // Fill from intervals
        for (Interval meet : intervals) 
        {
            startTime.add(meet.start);
            endTime.add(meet.end);
        }

        // Sort both lists
        Collections.sort(startTime);
        Collections.sort(endTime);

        int i = 0; // pointer for startTime
        int j = 0; // pointer for endTime

        // Max no. of Conferences needed at any time
        int conferences = 0; 

        // cur no. of Conferences being used
        int count = 0; 

        /*
            Iterate through all start times, only depends on
             Start time, if all meeting started : No Conflit
        */
        while (i < startTime.size()) 
        {
            // If a meeting starts before prev one ends
            if (startTime.get(i) < endTime.get(j)) 
            {
                // need a new room
                count++;    

                i++;  // move to next start time
            }
            else 
            {
                // Meeting has ended, room can be reused
                count--;    
                
                j++;  // move to next end time        
            }

            // Update max no. of Conferences needed
            conferences = Math.max(conferences, count);         
        }

        return conferences;
    }
}
