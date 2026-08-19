package Bit_Manipulation;

import java.util.*;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class CountBits {

    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0; i <= n; i++){
            res[i] = countSetBits(i);
        }
        return res;
    }

    private static int countSetBits(int n){
        int cnt = 0;
        while(n > 0){
            n = (n & (n-1));
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int n = 5;
        System.out.println("Count of set bits for each index = " + Arrays.toString(countBits(n)));
    }
}
