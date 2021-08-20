package sorting.bubble;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class BubbleSortTest.
 * Tests BubbleSort class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
class BubbleSortTest {
    /**
     * Tests sorting.
     */
    @Test
    void shouldSortArray() {
        // given
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};

        // when
        int[] result = bubbleSort.sort(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
