package Two_Pointers;

/**
 * Time Complexity: O(n * n)
 * Space Complexity: O(1)
 */
public class TrappingRainwater {

    public static int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;

            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int k = i; k < n; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(h));
    }
}
