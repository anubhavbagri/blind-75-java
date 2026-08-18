package Intervals;

import java.util.*;

/**
 * sorting the 2D array based on end
 * Time Complexity:  O(n log n)
 * Space Complexity: O(1)
 */
public class CanAttendMeetings {

    public static boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0)   return true;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1][1] > intervals[i][0])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] intervals = {{2, 4}, {9, 12}, {6, 10}};
        System.out.println("Output = " + canAttendMeetings(intervals));
    }
}
