package Greedy;

import java.util.*;

/**
 * Kadane's Algorithm
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int overallMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            overallMax = Math.max(currMax, overallMax);
        }
        return overallMax;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Output = " + maxSubArray(a));
    }
}
