package arraycheckasc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.04.2022
 */
class SolutionTest {
    /**
     * Tests isOrderedASC() method.
     */
    @Test
    public void whenSortedThenReturnTrue() {
        Solution solution = new Solution();
        int[] ints = {1, 2, 3};

        assertThat(solution.isOrderedASC(ints)).isTrue();
    }

    /**
     * Tests isOrderedASC() method.
     */
    @Test
    void whenUnSortedThenReturnFalse() {
        Solution solution = new Solution();
        int[] ints = {1, 0, 3};

        assertThat(solution.isOrderedASC(ints)).isFalse();
    }
}
