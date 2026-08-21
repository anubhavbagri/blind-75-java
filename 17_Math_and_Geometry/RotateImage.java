package Math_and_Geometry;

import java.util.Arrays;

/**
 * Time Complexity: O(n * n)
 * Space Complexity: O(1)
 */
public class RotateImage {

    public static void rotateImage(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotateImage(matrix);
        System.out.println("Rotated matrix: " + Arrays.deepToString(matrix));
    }
}
