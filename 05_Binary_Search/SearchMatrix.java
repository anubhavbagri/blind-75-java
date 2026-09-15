package Binary_Search;

/**
 * Time Complexity: O(log (m * n))
 * Space Complexity: O(1)
 */

public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m*n - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;
            if(target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));
    }
}
