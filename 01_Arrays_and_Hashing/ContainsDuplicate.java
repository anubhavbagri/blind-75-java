package Arrays_and_Hashing;

import java.util.*;

/**
 * Time Complexity:  O(n)
 * Space Complexity: O(n)
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] a = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(a));
    }
}
