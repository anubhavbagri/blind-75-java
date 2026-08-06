package Arrays_and_Hashing;

import java.util.*;

/**
 * Time Complexity: O(n * n)
 * Space Complexity: O(n)
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = arr[i] + arr[j] + arr[k];
                if (s < 0) { // sum is too small
                    j++;    // moving j right makes the 2nd number larger
                } else if (s > 0) { // sum is too large
                    k--;    // moving k left makes the 3rd number smaller
                } else {
                    set.add(new ArrayList<>(List.of(arr[i], arr[j], arr[k])));
                    j++;
                    k--;
                }
            }
        }
        for (var e : set) {
            res.add(e);
        }
        return res;
    }

    public static void main(String[] args) { run(); }

    public static void run() {
        int[] a = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));
    }
}
