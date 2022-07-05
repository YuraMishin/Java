package strings.yandexsplitandsum;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Class SolutionTest.
 * Tests strings.yandexsplitandsum.Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 05.07.2022
 */
class SolutionTest {
    /**
     * Tests perform method.
     */
    @Test
    void shouldTrueWhenInvoke() throws IOException {
        // given
        var input = """
            1
            1 2
            """;
        var expected = "3";

        // when
        var actual = new Solution().perform(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}