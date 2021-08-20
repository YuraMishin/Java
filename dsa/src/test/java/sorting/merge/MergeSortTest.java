package sorting.merge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class MergeSortTest.
 * Tests merge.MergeSort.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
class MergeSortTest {
    /**
     * SOLUTION.
     */
    private static final MergeSort SOLUTION = new MergeSort();

    /**
     * Tests sorting.
     */
    @Test
    void shouldSortArray() {
        // given
        int[] input = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};

        // when
        SOLUTION.sort(input);

        // then
        assertThat(input).isEqualTo(expected);
    }
}
