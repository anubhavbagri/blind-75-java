package Bit_Manipulation;

/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class HammingWeight {

    public static int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            n = (n & (n - 1));
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int n = 11;
        System.out.println("Count of set bits = " + hammingWeight(n));
    }
}
