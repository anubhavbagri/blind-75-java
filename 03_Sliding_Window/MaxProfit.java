package Sliding_Window;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxP = 0;   //max profit
        int sp = prices[n - 1];   //selling price
        for (int i = n - 2; i >= 0; i--) {
            int p = sp - prices[i];
            sp = Math.max(sp, prices[i]);
            maxP = Math.max(maxP, p);
        }
        return maxP;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
