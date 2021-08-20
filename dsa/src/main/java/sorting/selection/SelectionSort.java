package sorting.selection;

/**
 * Class SelectionSort.
 * Implements selection sort.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
public class SelectionSort {
    /**
     * Method sorts the array.
     *
     * @param array Array.
     */
    public final void sort(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
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
