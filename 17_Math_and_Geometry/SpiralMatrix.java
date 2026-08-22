package Math_and_Geometry;

import java.util.*;

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */
public class SpiralMatrix {

    public static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        int dir = 0;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            } else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }

        return list;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println("Spiral traversal: " + spiralMatrix(matrix));
    }
}
