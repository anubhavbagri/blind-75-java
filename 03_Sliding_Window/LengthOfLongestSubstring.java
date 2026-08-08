package Sliding_Window;

import java.util.*;

/**
 * Although there is a nested while loop, the algorithm is still O(n) because the start pointer only moves
 * forward and never resets. Each character is visited at most twice: once by the end pointer when entering
 * the window and once by the start pointer when leaving the window. Therefore, the total number of pointer
 * movements is at most 2n, giving an overall Time Complexity of O(n)
 * Space Complexity: O(n)
 */

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char rightCh = s.charAt(end);
            map.put(rightCh, map.getOrDefault(rightCh, 0) + 1);
            while (map.get(rightCh) > 1) {
                char leftCh = s.charAt(start);
                map.put(leftCh, map.get(leftCh) - 1);
                if (map.get(leftCh) == 0) map.remove(leftCh);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
