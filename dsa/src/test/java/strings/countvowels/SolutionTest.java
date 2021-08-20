package strings.countvowels;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests countvowels.Solution.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.06.2021
 */
class SolutionTest {
    /**
     * SOLUTION.
     */
    private static final Solution SOLUTION = new Solution();

    /**
     * Tests countVowels() method.
     */
    @Test
    void shouldReturnResult() {
        // given
        String phrase = "Java";
        int expected = 2;

        // when
        int actual = SOLUTION.countVowels(phrase);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Tests countVowels() method.
     */
    @Test
    void shouldReturnZero() {
        // given
        String phrase = "BCD";
        int expected = 0;

        // when
        int actual = SOLUTION.countVowels(phrase);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
