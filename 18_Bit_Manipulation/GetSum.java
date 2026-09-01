package Bit_Manipulation;

/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class GetSum {

    public static int getSum(int a, int b) {
        int partialSum = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            int newSum = partialSum ^ carry;
            int newCarry = (partialSum & carry) << 1;
            partialSum = newSum;
            carry = newCarry;
        }
        return partialSum;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int a = 3, b = 5;
        System.out.println("Without using + or - operator, sum = " + getSum(a, b));
    }
}
