package Two_Pointers;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaxArea {

    public static int maxArea(int[] h) {
        int n = h.length;
        int maxWater = Integer.MIN_VALUE;
        int l = 0, r = n - 1;
        while (l < r) {
            int water = Math.min(h[l], h[r]) * (r - l);
            maxWater = Math.max(maxWater, water);
            if (h[l] < h[r]) l++;
            else r--;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(h));
    }
}
