package Intervals;

import java.util.*;

/**
 * Heap-based approach
 * Time Complexity:  O(n log n)
 * Space Complexity: O(1)
 */
public class MinMeetingRooms {

    public static int minMeetingRooms(int[] start, int[] end) {
        Arrays.sort(start);
        Arrays.sort(end);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < start.length; i++) {
            if (!pq.isEmpty() && pq.peek() <= start[i]) {
                pq.poll();
            }
            pq.offer(end[i]);
        }
        return pq.size();
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
