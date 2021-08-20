package searching.linear;

/**
 * Class Solution.
 * Implements linear search.
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
    public final boolean linearSearch(
            final int[] array,
            final int target) {
        for (int value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}
