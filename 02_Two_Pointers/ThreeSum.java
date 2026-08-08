package Two_Pointers;

import java.util.*;

/**
 * Time Complexity: O(n * n)
 * Space Complexity: O(1)
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(i > 0 && arr[i] == arr[i-1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = arr[i] + arr[j] + arr[k];
                if (s < 0) { // sum is too small
                    j++;    // moving j right makes the 2nd number larger
                } else if (s > 0) { // sum is too large
                    k--;    // moving k left makes the 3rd number smaller
                } else {
                    res.add(new ArrayList<>(List.of(arr[i], arr[j], arr[k])));
                    j++;
                    k--;
                    while(j < n && arr[j] == arr[j-1])  j++;
                    while(k > 0 && arr[k] == arr[k+1])  k--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) { run(); }

    public static void run() {
        int[] a = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));
    }
}
