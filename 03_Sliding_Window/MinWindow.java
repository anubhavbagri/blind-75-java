package Sliding_Window;

import java.util.*;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class MinWindow {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();
        int minL = s.length();
        String res = "";
        int satisfied = 0;
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char rightCh = s.charAt(end);
            mapS.put(rightCh, mapS.getOrDefault(rightCh, 0) + 1);

            if (mapT.containsKey(rightCh) && mapS.get(rightCh) == mapT.get(rightCh)) {
                satisfied++;
            }

            while (satisfied == mapT.size()) {

                if((end - start + 1) <= minL){
                    minL = end - start + 1;
                    res = s.substring(start, end + 1);
                }

                char leftCh = s.charAt(start);
                mapS.put(leftCh, mapS.get(leftCh) - 1);
                start++;

                if (mapS.get(leftCh) < mapT.getOrDefault(leftCh, 0)) {
                    satisfied--;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
