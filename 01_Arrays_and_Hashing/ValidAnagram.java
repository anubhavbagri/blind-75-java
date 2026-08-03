package Arrays_and_Hashing;

/**
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 * The auxiliary array has a fixed size (26), independent of the input size n. Constant-sized memory is expressed as O(1).
 */
public class ValidAnagram {

    public static boolean validAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];
        for(char ch: s.toCharArray())   freq[ch-'a']++;

        for(char ch: t.toCharArray()){
            if(freq[ch-'a'] <= 0){
                return false;
            }
            freq[ch-'a']--;
        }
        return true;
    }

    public static void main(String[] args) { run(); }

    public static void run() {
        String s = "ab"; // "ab"
        String t = "aa"; // "aa"
        System.out.println(validAnagram(s, t));
    }
}
