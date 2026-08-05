package Arrays_and_Hashing;

import java.util.*;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class EncodeDecode {

    public static String encode(List<String> strs){
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }

//        System.out.println(sb.toString());
        return sb.toString();
    }
    public static List<String> decode(String str){
        List<String> list = new ArrayList<>();

        int t = 0;
        int len = 0;
        int i = 0;

        while(i < str.length()){
            char ch = str.charAt(i);
            if(ch == '#'){
                len = Integer.parseInt(str.substring(t, i));
                t = i+1;
                list.add(str.substring(t, t+len));
                i = t+len;
                t = i;
            } else {
                i++;
            }
        }

        return list;
    }


    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> strs = new ArrayList<>(List.of("Hello", "World"));
        String encoded_string = encode(strs);
        List<String> decoded_strs = decode(encoded_string);
        System.out.println(decoded_strs);
    }
}
