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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort meetings by start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // Check adjacent meetings for overlap
        for (int i = 1; i < intervals.size(); i++) {
            Interval previous = intervals.get(i - 1);
            Interval current = intervals.get(i);

            // If current meeting starts before previous meeting ends
            if (current.start < previous.end) {
                return false;
            }
        }

        return true;
    }
}
