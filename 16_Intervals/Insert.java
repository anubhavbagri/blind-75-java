package Intervals;

import java.util.*;

/**
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class Insert {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (end < newInterval[0]) {
                res.add(intervals[i]);
            } else if (start > newInterval[1]) {
                break;
            } else {
                newInterval[0] = Math.min(start, newInterval[0]);
                newInterval[1] = Math.max(newInterval[1], end);
            }
            i++;
        }
        res.add(newInterval);
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);   // old syntax: pass an empty array of size res
        // return res.toArray(int[][]::new); // modern syntax: converts directly to int[][] using constructor reference
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println("Output = " + Arrays.deepToString(insert(intervals, newInterval)));
    }
}
