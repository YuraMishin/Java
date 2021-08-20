package sorting.merge;

/**
 * Class MergeSort.
 * Implements Merge sort algorithm
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
public class MergeSort {
    /**
     * Method sorts an array.
     *
     * @param array Array.
     */
    public final void sort(final int[] array) {
        if (array.length < 2) {
            return;
        }

        var middle = array.length / 2;

        int[] left = new int[middle];
        for (var i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - middle];
        for (var i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }

        sort(left);
        sort(right);

        merge(left, right, array);
    }

    /**
     * Method merges the array.
     *
     * @param left   Left part.
     * @param right  Right part.
     * @param result Result array.
     */
    private void merge(
            final int[] left,
            final int[] right,
            final int[] result) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}
