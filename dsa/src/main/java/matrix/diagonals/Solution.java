package matrix.diagonals;

/**
 * Class Solution.
 * Implements solution to change main diagonal and antidiagonal.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 12.10.2021
 */
public final class Solution {
    /**
     * Method implements the solution.
     *
     * @param matrix Matrix
     */
    public void process(final int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
                if ((i + j) == (matrix.length - 1)) {
                    matrix[i][j] = 1;
                }
            }
        }
    }
}
