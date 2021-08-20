package sorting.bubble;

/**
 * Class BubbleSort.
 * Implements Bubble sort algorithm.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
public class BubbleSort {
    /**
     * Method sorts an array.
     *
     * @param array Array.
     * @return Array.
     */
    public final int[] sort(final int[] array) {
        boolean isSorted;
        for (var i = 0; i < array.length; i++) {
            isSorted = true;
            for (var j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                return array;
            }
        }
        return array;
    }

    /**
     * Method swaps the items.
     *
     * @param array  Array.
     * @param index1 Index1.
     * @param index2 Index2.
     */
    private void swap(
            final int[] array,
            final int index1,
            final int index2) {

        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
