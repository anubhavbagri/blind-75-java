package Greedy;

import java.util.*;

/**
 * Kadane's Algorithm
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class CanJump {

    public static boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= n - 1) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] a = {2, 3, 0, 1, 4};
        System.out.println("Output = " + canJump(a));
    }
}
