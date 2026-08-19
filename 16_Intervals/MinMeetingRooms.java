package Intervals;

import java.util.*;

/**
 * Two-pointer approach (Line sweep)
 * Time Complexity:  O(n log n)
 * Space Complexity: O(1)
 */
public class MinMeetingRooms {

    public static int minMeetingRooms(int[] start, int[] end) {
        int n = start.length;
        int i = 0, j = 0;
        int activeRooms = 0, maxActive = 0;
        Arrays.sort(start);
        Arrays.sort(end);
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                activeRooms++;
                i++;
            } else {
                activeRooms--;
                j++;
            }
            maxActive = Math.max(maxActive, activeRooms);
        }
        return maxActive;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int start[] = {0, 1, 2, 5, 7, 11, 13, 16, 19, 24};
        int end[] = {10, 3, 6, 8, 12, 15, 18, 20, 25, 30};
        System.out.println("Output = " + minMeetingRooms(start, end));
    }
}
