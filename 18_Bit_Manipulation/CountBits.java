package Bit_Manipulation;

import java.util.*;

import static Bit_Manipulation.HammingWeight.hammingWeight;

/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
public class CountBits {

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = hammingWeight(i);
        }
        return res;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int n = 5;
        System.out.println("Count of set bits for each index = " + Arrays.toString(countBits(n)));
    }
}
