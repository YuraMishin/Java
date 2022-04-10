package euclidgcd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class SolutionTest.
 * Tests Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.04.2022
 */
class SolutionTest {
    /**
     * Tests loop() and recur() methods.
     */
    @Test
    void when26And18ThenReturns2() {
        Solution solution = new Solution();
        assertEquals(2, solution.loop(26, 18));
        assertEquals(2, solution.recur(26, 18));
    }
}
