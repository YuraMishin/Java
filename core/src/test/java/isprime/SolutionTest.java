package isprime;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
class SolutionTest {
    private final Solution solution = new Solution();

    /**
     * Tests isPrime() method.
     */
    @Test
    void shouldTrueWhenPrime() {
        // given

        // when
        var result = solution.test(5);

        // then
        assertThat(result).isTrue();
    }

    /**
     * Tests isPrime() method.
     */
    @Test
    void shouldFalseWhenNotPrime() {
        // given

        // when
        var result = solution.test(6);

        // then
        assertThat(result).isFalse();
    }
}
