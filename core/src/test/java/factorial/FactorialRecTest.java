package factorial;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Class FactorialRecTest.
 * Tests FactorialRecur class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.04.22
 */
class FactorialRecTest {
    /**
     * Method tests calculation of factorial.
     */
    @Test
    void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        FactorialRecur factorial = new FactorialRecur();

        int expect = 120;
        int result = factorial.calc(5);

        assertThat(result).isEqualTo(expect);
    }

    /**
     * Method tests calculation of factorial.
     */
    @Test
    void whenCalculateFactorialForZeroThenOne() {
        FactorialRecur factorial = new FactorialRecur();

        int expect = 1;
        int result = factorial.calc(0);

        assertThat(result).isEqualTo(expect);
    }
}
