package Intervals;

import java.util.*;

/**
 * Smaller ending point -> more room for future intervals -> thus, fewer removals
 * sorting the 2D array based on end
 * Time Complexity:  O(n log n)
 * Space Complexity: O(1)
 */
public class EraseOverlapIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int c = 0;
        int[] track = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (track[1] > intervals[i][0]) {
                c++;
            } else {
                track = intervals[i];
            }
        }
        return c;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Output = " + eraseOverlapIntervals(intervals));
    }
}
