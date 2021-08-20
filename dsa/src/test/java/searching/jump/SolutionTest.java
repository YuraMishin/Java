package searching.jump;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests jump.Solution.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 26.06.2021
 */
class SolutionTest {
    /**
     * SOLUTION.
     */
    private static final searching.jump.Solution SOLUTION = new Solution();

    /**
     * Tests jumpSearch() method.
     */
    @Test
    void shouldFindValue() {
        //given
        int[] array = {1, 2, 3, 4, 5};
        int value = 3;

        // when
        boolean result = SOLUTION.jumpSearch(array, value);

        // then
        assertThat(result).isTrue();
    }

    /**
     * Tests jumpSearch() method.
     */
    @Test
    void shouldNotFindValue() {
        // given
        int[] array = {1, 2, 3, 4, 5};
        int value = 30;

        // when
        boolean result = SOLUTION.jumpSearch(array, value);

        // then
        assertThat(result).isFalse();
    }
}
