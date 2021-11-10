package arrayreverse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests arrayreverse.Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.11.2021
 */
class SolutionTest {
    /**
     * Tests reverse() method.
     */
    @Test
    void shouldReverseArray() {
        // given
        Solution solution = new Solution();
        int[] numbers = {1, 2, 3};
        int[] expected = {3, 2, 1};

        // when
        solution.reverse(numbers);

        // then
        assertThat(numbers).isEqualTo(expected);
    }
}
