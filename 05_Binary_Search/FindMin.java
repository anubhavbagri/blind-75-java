package Binary_Search;

/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class FindMin {
    public static int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] < nums[n - 1]) return nums[0];

        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;   // if mid is last
            int prev = (mid - 1 + n) % n;   // if mid is first

            // minimum element would be smaller than both neighbours
            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return nums[mid];
            }

            // this half is sorted so eliminate it since min. element will lie in the unsorted half
            else if (nums[0] <= nums[mid]) {
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] a = {3, 4, 5, 1, 2};
        System.out.println(findMin(a));
    }
}
