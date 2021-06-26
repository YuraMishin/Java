package searching.exponential;

import searching.binary.BinarySearch;

/**
 * Class Solution.
 * Implements exponential search.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 26.06.2021
 */
public class Solution {
    /**
     * @param array  Array.
     * @param target Target.
     * @return Boolean.
     */
    public final boolean exponentialSearch(
            final int[] array,
            final int target) {

        int bound = 1;
        while (bound < array.length
                && array[bound] < target) {
            bound *= 2;
        }

        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);

        return new BinarySearch().binarySearchRec(array, target);
    }
}
