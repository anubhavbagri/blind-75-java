package Two_Pointers;

import java.util.*;

/**
 * Time Complexity: O(n * n)
 * Space Complexity: O(1)
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1])   continue;
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0){    // sum is too small
                    left++;     // moving j right makes the 2nd number larger
                } else if (sum > 0){    // sum is too large
                    right--;    // moving k left makes the 3rd number smaller
                } else {
                    res.add(
                        new ArrayList<>(List.of(nums[i], nums[left], nums[right]))
                    );
                    left++;
                    right--;
                    while(left < n && nums[left] == nums[left-1])
                        left++;
                    while(right > 0 && nums[right] == nums[right+1])
                        right--;
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
