package Two_Pointers;

/**
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class IsPalindrome {

    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(Character.isLetterOrDigit(ch))
                sb.append(Character.toLowerCase(ch));
        }
        String s = sb.toString();
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) { run(); }

    public static void run() {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
