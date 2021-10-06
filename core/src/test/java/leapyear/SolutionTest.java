package leapyear;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SolutionTest.
 * Tests leapyear.Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.10.2021
 */
class SolutionTest {
    /**
     * Solution.
     */
    private static Solution solution;

    /**
     * Method inits tests.
     */
    @BeforeAll
    public static void setup() {
        solution = new Solution();
    }

    /**
     * Tests isLeapYear() method.
     */
    @DisplayName("Tests years which are not leap")
    @ParameterizedTest
    @ValueSource(ints = {1700, 1800, 1900, 2021, 2100, 2200, 2300})
    void shouldReturnFalse(int year) {
        // given
        solution = new Solution();

        // when
        boolean result = solution.isLeapYear(year);

        // then
        assertThat(result).isFalse();
    }

    /**
     * Tests isLeapYear() method.
     */
    @DisplayName("Tests years which are leap")
    @ParameterizedTest
    @ValueSource(ints = {1600, 2000, 2020})
    void shouldReturnTrue(int year) {
        // given
        solution = new Solution();

        // when
        boolean result = solution.isLeapYear(year);

        // then
        assertThat(result).isTrue();
    }
}