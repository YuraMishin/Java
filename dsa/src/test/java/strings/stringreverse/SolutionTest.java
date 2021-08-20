package strings.stringreverse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests stringreverse.Solution.
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
     * Tests reverse() method.
     */
    @Test
    void shouldReverseWord() {
        // given
        String string = "abc";
        String expected = "cba";

        // when
        String actual = SOLUTION.reverseByStack(string);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Tests reverseByStringBuilder() method.
     */
    @Test
    void shouldReverseWord2() {
        // given
        String string = "abc";
        String expected = "cba";

        // when
        String actual = SOLUTION.reverseByStringBuilder(string);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Tests reverseByStringBuilder() method.
     */
    @Test
    void shouldReturnEmptyWhenInvokesWithNull() {
        // given
        String string = null;
        String expected = "";

        // when
        String actual = SOLUTION.reverseByStringBuilder(string);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
