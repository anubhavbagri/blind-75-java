package Binary_Search;

/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class Search {
    public static int search(int[] nums, int target) {
        int indx = findIndex(nums);
        int res = binarySearch(nums, target, 0, indx - 1);
        if (res == -1) {
            res = binarySearch(nums, target, indx, nums.length - 1);
        }
        return res;
    }

    private static int binarySearch(int[] a, int t, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == t) {
                return mid;
            } else if (a[mid] < t) {
                s = mid + 1;
            } else e = mid - 1;
        }
        return -1;
    }

    private static int findIndex(int[] nums) {
        int n = nums.length;
        if (nums[0] < nums[n - 1])
            return 0;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev])
                return mid;

            else if (nums[0] <= nums[mid])
                start = mid + 1;

            else
                end = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(a, target));
    }
}
