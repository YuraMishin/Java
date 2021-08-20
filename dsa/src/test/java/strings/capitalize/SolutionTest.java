package strings.capitalize;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests capitalize.Solution.
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
     * Tests capitalize() method.
     */
    @Test
    void shouldReturnEmptyWhenInvokesWithNull() {
        // given
        String sentence = null;
        String expected = "";

        // when
        String actual = SOLUTION.capitalize(sentence);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Tests capitalize() method.
     */
    @Test
    void shouldReturnEmptyWhenInvokesWithEmpty() {
        // given
        String sentence = "";
        String expected = "";

        // when
        String actual = SOLUTION.capitalize(sentence);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Tests capitalize() method.
     */
    @Test
    void shouldCapitalize() {
        // given
        String sentence = "hello, world!";
        String expected = "Hello, World!";

        // when
        String actual = SOLUTION.capitalize(sentence);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
