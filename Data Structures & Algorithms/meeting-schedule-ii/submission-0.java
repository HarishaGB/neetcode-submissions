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
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();

        if (n == 0) {
            return 0;
        }

        int[] starts = new int[n];
        int[] ends = new int[n];

        // Store start and end times separately
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        // Sort both arrays
        Arrays.sort(starts);
        Arrays.sort(ends);

        int s = 0;
        int e = 0;

        int count = 0;
        int result = 0;

        // Process every meeting start
        while (s < n) {
            if (starts[s] < ends[e]) {
                // Meeting starts before another meeting ends
                count++;

                result = Math.max(result, count);

                s++;

            } else {
                // A meeting ended, so reuse its room
                count--;

                e++;
            }
        }

        return result;
    }
}
