package strings.removeduplicates;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests removeduplicates.Solution.
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
     * Tests removeDuplicates() method.
     */
    @Test
    void shouldReturnEmptyWhenInvokesWithNull() {
        // given
        String sentence = null;
        String expected = "";

        // when
        String actual = SOLUTION.removeDuplicates(sentence);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Tests removeDuplicates() method.
     */
    @Test
    void shouldRemovesDuplicates() {
        // given
        String sentence = "Hello, Java!";
        String expected = "Helo, Jav!";

        // when
        String actual = SOLUTION.removeDuplicates(sentence);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
