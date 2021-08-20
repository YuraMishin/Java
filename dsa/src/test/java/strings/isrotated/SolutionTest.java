package strings.isrotated;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests isrotated.Solution.
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
     * Tests areRotations() method.
     */
    @Test
    void shouldReturnTrue() {
        // when
        boolean actual = SOLUTION.areRotations("ABCD", "DABC");

        // then
        assertThat(actual).isTrue();
    }

    /**
     * Tests areRotations() method.
     */
    @Test
    void shouldReturnFalse() {
        // when
        boolean actual = SOLUTION.areRotations("ABCD", "DBCA");

        // then
        assertThat(actual).isFalse();
    }

    /**
     * Tests areRotations() method.
     */
    @Test
    void shouldReturnTrueWhenInvokesWithNull() {
        // when
        boolean actual = SOLUTION.areRotations(null, "DBCA");

        // then
        assertThat(actual).isFalse();
    }
}
