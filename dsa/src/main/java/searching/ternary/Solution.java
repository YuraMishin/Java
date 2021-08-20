package searching.ternary;

/**
 * Class Solution.
 * Implements ternary search.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 26.06.2021
 */
public class Solution {

    /**
     * TERNARY_CONST.
     */
    public static final int TERNARY_CONST = 3;

    /**
     * Methods performs search.
     *
     * @param array  Array.
     * @param target Target.
     * @return Boolean.
     */
    public final boolean ternarySearch(
            final int[] array,
            final int target) {
        return ternarySearch(array, target, 0, array.length - 1);
    }

    /**
     * Methods performs search.
     *
     * @param array  Array.
     * @param target Target.
     * @param left   Left.
     * @param right  Right.
     * @return Boolean.
     */
    private boolean ternarySearch(
            final int[] array,
            final int target,
            final int left,
            final int right) {

        if (left > right) {
            return false;
        }
        int partitionSize = (right - left) / TERNARY_CONST;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;
        if (array[mid1] == target) {
            return true;
        }
        if (array[mid2] == target) {
            return true;
        }
        if (target < array[mid1]) {
            return ternarySearch(array, target, left, mid1 - 1);
        }
        if (target > array[mid2]) {
            return ternarySearch(array, target, mid2 + 1, right);
        }

        return ternarySearch(array, target, mid1 + 1, mid2 - 1);
    }
}
