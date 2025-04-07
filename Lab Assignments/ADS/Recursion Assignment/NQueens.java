import java.util.*;

public class NQueens {

    // Solve the N-Queens problem
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        solve(0, board, solutions);
        return solutions;
    }

    // Recursive backtracking function
    private static void solve(int row, char[][] board, List<List<String>> solutions) {
        int n = board.length;

        if (row == n) {
            // Convert board to List<String> format
            List<String> current = new ArrayList<>();
            for (char[] line : board) {
                current.add(new String(line));
            }
            solutions.add(current);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(row + 1, board, solutions);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    // Check if placing queen is safe
    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check vertical column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    // Main method to take user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int n = scanner.nextInt();

        List<List<String>> solutions = solveNQueens(n);

        System.out.println("Solutions to the " + n + "-Queens problem:");
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println(); // separate boards
        }

        System.out.println("Total solutions: " + solutions.size());

        scanner.close();
    }
}
