package Bit_Manipulation;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing number = " + missingNumber(nums));
    }
}
