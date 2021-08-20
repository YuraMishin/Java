package sorting.insertion;

/**
 * Class InsertionSort.
 * Implements Insertion sort algorithm.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
public class InsertionSort {
    /**
     * Method sorts an array.
     *
     * @param array Array.
     */
    public final void sort(final int[] array) {
        for (var i = 1; i < array.length; i++) {
            var current = array[i];
            var j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}
