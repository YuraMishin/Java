package sorting.counting;

/**
 * Class Solution.
 * Implements counting sort.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 2606.2021
 */
public class Solution {
    /**
     * Method sorts an array.
     *
     * @param array Array.
     * @param max   Max.
     */
    public final void sort(final int[] array, final int max) {
        int[] counts = new int[max + 1];
        for (var item : array) {
            counts[item]++;
        }

        var k = 0;
        for (var i = 0; i < counts.length; i++) {
            for (var j = 0; j < counts[i]; j++) {
                array[k++] = i;
            }
        }
    }
}
