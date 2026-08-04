package Arrays_and_Hashing;

import java.util.*;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int x = 1;
        for(int i = n-2; i >= 0; i--){
            x = x * nums[i+1];
            ans[i] = ans[i] * x;
        }

        return ans;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] a = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(a)));
    }
}
