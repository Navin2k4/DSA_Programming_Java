import java.util.List;
import java.util.ArrayList;

class Solution {
    static void markColumns(int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    static void markRows(int row, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        List<int[]> zeroPositions = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroPositions.add(new int[] { i, j });
                }
            }
        }

        for (int[] pos : zeroPositions) {
            markRows(pos[0], matrix);
            markColumns(pos[1], matrix);
        }
    }
}

public class setmatzeros {
    public static void main(String[] args) {
        // int[][] matrix = {
        // {1, 1, 1},
        // {1, 0, 1},
        // {1, 1, 1}
        // };
        int[][] matrix = {
                { 0, 1 }
        };

        Solution solution = new Solution();
        solution.setZeroes(matrix);

        // Optional: print matrix after calling setZeroes
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
