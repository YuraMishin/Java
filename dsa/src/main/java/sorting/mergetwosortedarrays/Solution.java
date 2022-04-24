package sorting.mergetwosortedarrays;

/**
 * Class Solution.
 * Merging two sorted arrays into one.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.04.2022
 */
public final class Solution {
    /**
     * Constructor.
     */
    Solution() {
    }

    /**
     * Method computes the solution.
     *
     * @param arrOne Array.
     * @param arrTwo Array.
     * @return Array.
     */
    public int[] merge(final int[] arrOne, final int[] arrTwo) {

        int fooLength = arrOne.length;
        int barLength = arrTwo.length;

        int[] merged = new int[fooLength + barLength];

        int fooPosition = 0;
        int barPosition = 0;
        int mergedPosition = 0;

        while (fooPosition < fooLength && barPosition < barLength) {
            if (arrOne[fooPosition] < arrTwo[barPosition]) {
                merged[mergedPosition++] = arrOne[fooPosition++];
            } else {
                merged[mergedPosition++] = arrTwo[barPosition++];
            }
        }

        while (fooPosition < fooLength) {
            merged[mergedPosition++] = arrOne[fooPosition++];
        }

        while (barPosition < barLength) {
            merged[mergedPosition++] = arrTwo[barPosition++];
        }

        return merged;
    }
}
