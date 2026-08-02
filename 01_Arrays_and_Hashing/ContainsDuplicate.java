package Arrays_and_Hashing;

import java.util.*;

/**
 * Time Complexity:  
 * Space Complexity:
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        return true;
    }

    public static void main(String[] args) { run(); }

    public static void run() {
        System.out.println("\n--- Contains Duplicate ---");
        System.out.println("containsDuplicate([1,2,3,1])    => " + containsDuplicate(new int[]{1, 2, 3, 1}));    // true
        System.out.println("containsDuplicate([1,2,3,4])    => " + containsDuplicate(new int[]{1, 2, 3, 4}));    // false
        System.out.println("containsDuplicate([1,1,1,3,3,4,3,2,4,2]) => " + containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})); // true
    }
}
