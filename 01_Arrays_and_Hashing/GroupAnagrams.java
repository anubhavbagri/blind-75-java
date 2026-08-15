package Arrays_and_Hashing;

import java.util.*;

/**
 * Time Complexity: O(n * k)
 * Space Complexity: O(n)
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String k = genKey(str);
            if (map.containsKey(k)) {
                map.get(k).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(k, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static String genKey(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                sb.append((char) (i + 'a')).append(freq[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
