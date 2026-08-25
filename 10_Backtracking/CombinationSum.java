package Backtracking;

import java.util.*;

/**
 * Time complexity: Exponential O(2 ^ t) * k
 * where t = target, k = average length of candidates array
 * Space Complexity: Dependent on the number of combinations
 */
public class CombinationSum {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        solve(0, target, list, candidates);
        return res;
    }

    private static void solve(int i, int sum, List<Integer> list, int[] a) {

        if (sum == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (sum < 0 || i >= a.length)
            return;

        list.add(a[i]);
        solve(i, sum - a[i], list, a);
        list.remove(list.size() - 1);
        solve(i + 1, sum, list, a);
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
