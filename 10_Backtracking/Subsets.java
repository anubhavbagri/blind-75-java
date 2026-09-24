package Backtracking;

import java.util.*;

/**
 * Time complexity: Exponential O(2 ^ n) * n
 * Space Complexity: O(n)
 */
public class Subsets {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        solve(0, list, nums);
        return res;
    }

    private static void solve(int idx, List<Integer> list, int[] nums) {

        if (idx >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        solve(idx+1, list, nums);
        list.remove(list.size() - 1);
        solve(idx+1, list, nums);
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
