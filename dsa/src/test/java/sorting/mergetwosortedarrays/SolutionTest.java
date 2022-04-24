package sorting.mergetwosortedarrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.04.2022
 */
class SolutionTest {
    /**
     * Tests merge() method.
     */
    @Test
    void whenInvokedThenMerge() {
        Solution solution = new Solution();
        int[] arrOne = {1, 2, 3, 10, 15, 17, 100};
        int[] arrTwo = {3, 4, 5, 6, 60, 62};
        int[] expected = {1, 2, 3, 3, 4, 5, 6, 10, 15, 17, 60, 62, 100};
        int[] result = solution.merge(arrOne, arrTwo);

        assertThat(result).isEqualTo(expected);
    }
}
