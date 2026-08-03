package Arrays_and_Hashing;

import java.util.*;

/**
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 * The auxiliary array has a fixed size (26), independent of the input size n. Constant-sized memory is expressed as O(1).
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) { run(); }

    public static void run() {
        int[] a = {3, 5, 1, 8};
        System.out.println(Arrays.toString(twoSum(a, 11)));
    }
}
