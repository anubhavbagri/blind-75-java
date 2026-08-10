import java.util.Stack;

public class IsValid {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!st.isEmpty() && ((ch == ')' && st.peek() == '(') || (ch == '}' && st.peek() == '{')
                    || (ch == ']' && st.peek() == '['))) {
                st.pop();
            } else
                st.push(ch);
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
