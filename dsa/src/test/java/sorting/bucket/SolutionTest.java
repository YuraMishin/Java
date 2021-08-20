package sorting.bucket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests sorting.Solution.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 21.06.2020
 */
class SolutionTest {
    /**
     * SOLUTION.
     */
    private static final Solution SOLUTION = new Solution();

    /**
     * Tests sort() method.
     */
    @Test
    void shouldSortArray() {
        // given
        int[] ints = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};

        // when
        SOLUTION.sort(ints, ints.length);

        // then
        assertThat(ints).isEqualTo(expected);
    }
}
