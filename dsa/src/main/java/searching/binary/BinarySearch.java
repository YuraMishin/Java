package searching.binary;

/**
 * Class BinarySearch.
 * Implements binary search algorithm.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 26.06.2021
 */
public class BinarySearch {
    /**
     * Method performs search recursively.
     *
     * @param array  Array.
     * @param target Target.
     * @return Boolean.
     */
    public final boolean binarySearchRec(
            final int[] array,
            final int target) {
        return binarySearchRec(array, target, 0, array.length - 1);
    }

    /**
     * Method performs search recursively.
     *
     * @param array  Array.
     * @param target Target.
     * @param left   Left.
     * @param right  Right.
     * @return Boolean.
     */
    private boolean binarySearchRec(
            final int[] array,
            final int target,
            final int left,
            final int right) {

        if (right < left) {
            return false;
        }
        int middle = (left + right) / 2;
        if (array[middle] == target) {
            return true;
        }
        if (target < array[middle]) {
            return binarySearchRec(array, target, left, middle - 1);
        }

        return binarySearchRec(array, target, middle + 1, right);
    }

    /**
     * Method performs search iteratively.
     *
     * @param array  Array.
     * @param target Target.
     * @return Boolean.
     */
    public final boolean binarySearch(
            final int[] array,
            final int target) {

        var left = 0;
        var right = array.length - 1;
        while (left <= right) {
            var middle = (left + right) / 2;
            if (array[middle] == target) {
                return true;
            }
            if (target < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }
}
