package Backtracking;

import java.util.*;

/**
 * Time complexity: Exponential O(m * n * 3 ^ L)
 * where m * n = no. of cells in the board, L = length of the word
 * Once you move to a neighboring cell, you cannot go back to the cell
 * you just came from, because it's already visited.
 * <p>
 * Therefore, after the first move, there are at most: 3 choices
 * Space Complexity: Auxiliary Space O(L)
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && solve(i, j, m, n, 0, word, board))
                    return true;
            }
        }
        return false;
    }

    private static boolean solve(int i, int j, int m, int n, int idx, String word, char[][] board) {
        if (idx == word.length()) return true;

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#' || board[i][j] != word.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = solve(i + 1, j, m, n, idx + 1, word, board) ||
                solve(i - 1, j, m, n, idx + 1, word, board) ||
                solve(i, j + 1, m, n, idx + 1, word, board) ||
                solve(i, j - 1, m, n, idx + 1, word, board);

        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
