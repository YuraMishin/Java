package sorting.quick;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class QuickSortTest.
 * Tests QuickSort class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
class QuickSortTest {
    /**
     * Tests sort() method.
     */
    @Test
    void shouldSortArray() {
        // given
        int[] array = {3, 8, 2, 5, 0, 1, 4, 10};
        int[] result = {0, 1, 2, 3, 4, 5, 8, 10};

        // when
        new QuickSort().sort(array);

        // then
        assertThat(result).isEqualTo(array);
    }

    /**
     * Tests sort() method.
     */
    @Test
    void shouldNotSortArray() {
        // given
        int[] array = {};
        int[] result = {};

        // when
        new QuickSort().sort(array);

        // then
        assertThat(result).isEqualTo(array);
    }
}