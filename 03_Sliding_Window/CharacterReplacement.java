package Sliding_Window;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class CharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxL = 0;
        int maxFreq = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char rightCh = s.charAt(end);
            freq[rightCh - 'A']++;

            maxFreq = Math.max(maxFreq, freq[rightCh - 'A']);
            while (((end - start + 1) - maxFreq) > k) {
                char leftCh = s.charAt(start);
                freq[leftCh - 'A']--;
                start++;
            }
            maxL = Math.max(maxL, end - start + 1);
        }
        return maxL;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String s = "AABAC";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
