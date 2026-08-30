package Binary_Search;

/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] a = {-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch(a, 9));
    }
}
