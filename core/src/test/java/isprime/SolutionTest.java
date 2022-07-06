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
    private final SolutionV2 solutionV2 = new SolutionV2();
    private final SolutionV3 solutionV3 = new SolutionV3();

    /**
     * Tests isPrime() method.
     */
    @Test
    void shouldTrueWhenPrime() {
        // given

        // when
        var result = solution.test(5);
        var result2 = solutionV2.test(5);
        var result3 = solutionV3.test(5);

        // then
        assertThat(result).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isTrue();
    }

    /**
     * Tests isPrime() method.
     */
    @Test
    void shouldFalseWhenNotPrime() {
        // given

        // when
        var result = solution.test(6);
        var result2 = solutionV2.test(6);
        var result3 = solutionV3.test(6);

        // then
        assertThat(result).isFalse();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }
}
