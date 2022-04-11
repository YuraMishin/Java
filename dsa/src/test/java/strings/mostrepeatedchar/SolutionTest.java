package strings.mostrepeatedchar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

/**
 * Class SolutionTest.
 * Tests mostrepeatedchar.Solution.
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
     * Tests getMaxOccuringChar() method.
     */
    @Test()
    void shouldThrowsExceptionOnNull() {
        // given
        String str = null;

        // when
        Throwable thrown = catchThrowable(() -> SOLUTION.getMaxOccuringChar(str));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Tests getMaxOccuringChar() method.
     */
    @Test()
    void shouldThrowsExceptionOnEmpty() {
        // given
        String str = "";

        // when
        Throwable thrown = catchThrowable(() -> SOLUTION.getMaxOccuringChar(str));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Tests getMaxOccuringChar() method.
     */
    @Test
    void shouldReturnChar() {
        // given
        String str = "Hello World";
        String expected = "l";

        // when
        String actual = SOLUTION.getMaxOccuringChar(str);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Tests getMaxOccuringCharV2() method.
     */
    @Test
    void shouldReturnCharV2() {
        // given
        String str = "Hello World";
        String expected = "l";

        // when
        String actual = SOLUTION.getMaxOccuringCharV2(str);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
