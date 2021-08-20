package searching.jump;

/**
 * Class Solution.
 * Implements jump search.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 26.06.2021
 */
public class Solution {
    /**
     * Method performs search.
     *
     * @param array  Array.
     * @param target Target.
     * @return Boolean.
     */
    public final boolean jumpSearch(
            final int[] array,
            final int target) {

        int blockSize = (int) Math.sqrt(array.length);
        var start = 0;
        int next = blockSize;
        while (start < array.length
                && array[next - 1] < target) {
            start = next;
            next += blockSize;
            if (next > array.length) {
                next = array.length;
            }
        }
        for (var i = start; i < next; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    }
}
