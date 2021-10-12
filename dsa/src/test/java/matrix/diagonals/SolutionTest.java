package matrix.diagonals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class SolutionTest.
 * Tests matrix.diagonals.Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 12.10.2021
 */
class SolutionTest {
    /**
     * Tests process() method.
     */
    @Test
    void shouldProcess() {
        // given
        int[][] matrix = new int[3][3];
        int[][] expectedMatrix = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1}
        };
        Solution solution = new Solution();

        // when
        solution.process(matrix);

        // then
        assertTrue(Arrays.deepEquals(expectedMatrix, matrix));
    }
}