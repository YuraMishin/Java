package sorting.selection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SelectionSortTest.
 * Tests SelectionSort class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
class SelectionSortTest {
    /**
     * Tests sort() method.
     */
    @Test
    void shouldSortArray() {
        // given
        int[] array = {3, 8, 2, 5, 0, 1, 4, 10};
        int[] result = {0, 1, 2, 3, 4, 5, 8, 10};

        // when
        new SelectionSort().sort(array);

        // then
        assertThat(result).isEqualTo(array);
    }
}
