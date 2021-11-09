package digitsum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests digitsum.Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 09.11.2021
 */
class SolutionTest {
    /**
     * Tests sumDigits() method.
     */
    @Test
    void shouldReturn8WhenConsume125() {
        // given
        Solution solution = new Solution();

        // when
        int sum = solution.sumDigits(125);

        // then
        assertThat(sum).isEqualTo(8);
    }

    /**
     * Tests sumDigits() method.
     */
    @Test
    void shouldReturnM1WhenConsume5() {
        // given
        Solution solution = new Solution();

        // when
        int sum = solution.sumDigits(5);

        // then
        assertThat(sum).isEqualTo(-1);
    }
}
