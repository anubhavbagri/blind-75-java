package Intervals;

import java.util.*;

/**
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class Merge {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] track = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(track[1] >= intervals[i][0]){
                track[1] = Math.max(track[1], intervals[i][1]);
            } else {
                res.add(track);
                track = intervals[i];
            }
        }
        res.add(track);
        return res.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] intervals = {{1, 10}, {2, 6}, {8, 10}, {12, 16}};
        System.out.println("Output = " + Arrays.deepToString(merge(intervals)));
    }
}
