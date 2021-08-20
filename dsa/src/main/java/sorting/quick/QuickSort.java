package sorting.quick;

/**
 * Class QuickSort.
 * Implements quick sort algorithm.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
public class QuickSort {
    /**
     * Method sorts an array.
     *
     * @param array Array.
     */
    public final void sort(final int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * Method sort an array within interval.
     *
     * @param array Array.
     * @param start Start.
     * @param end   End.
     */
    private void sort(final int[] array, final int start, final int end) {
        if (start >= end) {
            return;
        }
        var boundary = partition(array, start, end);
        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);
    }

    /**
     * Method precesses partition.
     *
     * @param array Array.
     * @param start Start.
     * @param end   End.
     * @return int Boundary.
     */
    private int partition(final int[] array, final int start, final int end) {
        var pivot = array[end];
        var boundary = start - 1;
        for (var i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                swap(array, i, ++boundary);
            }
        }
        return boundary;
    }

    /**
     * Method swaps indexes.
     *
     * @param array  Array.
     * @param index1 Index1.
     * @param index2 Index2.
     */
    private void swap(final int[] array, final int index1, final int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
