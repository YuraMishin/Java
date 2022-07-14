package strings.palindrom;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests palindrom.Solution.
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
     * Tests isPalindrome() method.
     */
    @Test
    void shouldReturnTrue() {
        // given
        String word = "madam";

        // when
        boolean actual = SOLUTION.isPalindrome(word);

        // then
        assertThat(actual).isTrue();
    }

    /**
     * Tests isPalindrome() method.
     */
    @Test
    void shouldReturnFalse() {
        // given
        String word = "Java";

        // when
        boolean actual = SOLUTION.isPalindrome(word);

        // then
        assertThat(actual).isFalse();
    }

    /**
     * Tests isPalindromeV2() method.
     */
    @Test
    void shouldReturnTrue2() {
        // given
        String word = "madam";

        // when
        boolean actual = SOLUTION.isPalindromeV2(word);

        // then
        assertThat(actual).isTrue();
    }

    /**
     * Tests isPalindromeV2() method.
     */
    @Test
    void shouldReturnFalse2() {
        // given
        String word = "Java";

        // when
        boolean actual = SOLUTION.isPalindromeV2(word);

        // then
        assertThat(actual).isFalse();
    }
}
