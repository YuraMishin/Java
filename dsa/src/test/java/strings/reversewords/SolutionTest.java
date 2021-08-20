package strings.reversewords;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests reversewords.Solution.
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
     * Tests reverseWords() method.
     */
    @Test
    void shouldReturnsNothingWhenInvokesWithNUll() {
        // given
        String sentence = null;
        String expected = "";

        // when
        String actual = SOLUTION.reverseWords(sentence);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Tests reverseWords() method.
     */
    @Test
    void shouldReverseWords() {
        // given
        String sentence = "Hello World !";
        String expected = "! World Hello";

        // when
        String actual = SOLUTION.reverseWords(sentence);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
