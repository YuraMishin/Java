package arraycheckasc;

/**
 * Class Solution.
 * Checking whether an array is sorted in ascending order.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.04.2022
 */
public class Solution {
    /**
     * Method computes the solution.
     *
     * @param arr Array.
     * @return boolean.
     */
    public final boolean isOrderedASC(final int[] arr) {
        boolean result = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                result = false;
                break;
            }
        }

        return result;
    }
}
