import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows and columns:");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        //  Display the matrix before spiral
        System.out.println("Matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // move to next row
        }

        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) result.add(matrix[top][i]);
            top++;
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;
            if (top <= bottom)
                for (int i = right; i >= left; i--) result.add(matrix[bottom][i]);
            bottom--;
            if (left <= right)
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
            left++;
        }

        System.out.println("Spiral Order: " + result);
    }
}
