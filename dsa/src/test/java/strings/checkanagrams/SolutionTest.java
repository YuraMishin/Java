package strings.checkanagrams;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests checkanagrams.Solution.
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
     * Tests areAnagramsOne() method.
     */
    @Test
    void shouldReturnTrue() {
        // given
        String firstWord = "abc";
        String secondWord = "cba";

        // when
        boolean actual = SOLUTION.areAnagramsOne(firstWord, secondWord);

        // then
        assertThat(actual).isTrue();
    }

    /**
     * Tests areAnagramsOne() method.
     */
    @Test
    void shouldReturnFalse() {
        // given
        String firstWord = "abc";
        String secondWord = "cbacba";

        // when
        boolean actual = SOLUTION.areAnagramsOne(firstWord, secondWord);

        // then
        assertThat(actual).isFalse();
    }

    /**
     * Tests areAnagramTwo() method.
     */
    @Test
    void shouldReturnTrue2() {
        // given
        String firstWord = "abc";
        String secondWord = "cba";

        // when
        boolean actual = SOLUTION.areAnagramTwo(firstWord, secondWord);

        // then
        assertThat(actual).isTrue();
    }

    /**
     * Tests areAnagramTwo() method.
     */
    @Test
    void shouldReturnFalse2() {
        // given
        String firstWord = "abc";
        String secondWord = "cbacba";

        // when
        boolean actual = SOLUTION.areAnagramTwo(firstWord, secondWord);

        // then
        assertThat(actual).isFalse();
    }
}
