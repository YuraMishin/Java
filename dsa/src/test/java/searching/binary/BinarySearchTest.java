package searching.binary;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class BinarySearchTest.
 * Tests BinarySearch class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 26.06.2021
 */
class BinarySearchTest {
    private final BinarySearch binarySearch = new BinarySearch();

    /**
     * Tests binarySearchRec() method.
     */
    @Test
    void shouldRecTrueWhenContainsValue() {
        // given
        int[] array = {1, 2, 3, 4, 5};
        int value = 3;

        // when
        boolean result = binarySearch.binarySearchRec(array, value);

        // then
        assertThat(result).isTrue();
    }

    /**
     * Tests binarySearchRec() method.
     */
    @Test
    void shouldRecFalseWhenDoesNotContainValue() {
        // given
        int[] array = {1, 2, 3, 4, 5};
        int value = 30;

        // when
        boolean result = binarySearch.binarySearchRec(array, value);

        // then
        assertThat(result).isFalse();
    }

    /**
     * Tests binarySearch() method.
     */
    @Test
    void shouldTrueWhenContainsValue() {
        // given
        int[] array = {1, 2, 3, 4, 5};
        int value = 3;

        // when
        boolean result = binarySearch.binarySearch(array, value);

        // then
        assertThat(result).isTrue();
    }

    /**
     * Tests binarySearch() method.
     */
    @Test
    void shouldFalseWhenDoesNotContainValue() {
        // given
        int[] array = {1, 2, 3, 4, 5};
        int value = 30;

        // when
        boolean result = binarySearch.binarySearch(array, value);

        // then
        assertThat(result).isFalse();
    }
}
