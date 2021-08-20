package searching.linear;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests linear.Solution.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 26.06.2021
 */
class SolutionTest {
    /**
     * SOLUTION.
     */
    private static final Solution SOLUTION = new Solution();

    /**
     * Tests search() method.
     */
    @Test
    void shouldFindValue() {
        // given
        int[] array = {1, 2, 3, 4, 5};
        int value = 3;

        // when
        boolean result = SOLUTION.linearSearch(array, value);

        // then
        assertThat(result).isTrue();
    }

    /**
     * Tests search() method.
     */
    @Test
    void shouldNotFindValue() {
        // given
        int[] array = {1, 2, 3, 4, 5};
        int value = 30;

        // when
        boolean result = SOLUTION.linearSearch(array, value);

        // then
        assertThat(result).isFalse();
    }
}
