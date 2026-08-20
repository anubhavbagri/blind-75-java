package Bit_Manipulation;

import java.util.*;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int rightMostBit = n & 1;
            ans = (ans << 1) | rightMostBit;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int n = 43261596;
        System.out.println("Reverse bits of the given 32 bits signed integer: " + reverseBits(n));
    }
}
