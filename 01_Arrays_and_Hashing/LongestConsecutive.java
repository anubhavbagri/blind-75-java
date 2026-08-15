package Arrays_and_Hashing;

import java.util.*;

/**
 * Time Complexity: Amortized Analysis - O(n)
 * Space Complexity: O(n)
 */

public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int c = 0, maxC = 0;

        for (int i : nums) {
            set.add(i);
        }

        for (int i : set) {
            if (set.contains(i - 1)) continue;
            int x = i;
            while (set.contains(x)) {
                c++;
                x = x + 1;
            }
            maxC = Math.max(maxC, c);
            c = 0;
        }

        return maxC;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] a = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(a));
    }
}
