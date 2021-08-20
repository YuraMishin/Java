package sorting.bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class Solution.
 * Implements bucket sort.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 26.06.2021
 */
public class Solution {
    /**
     * @param array           Array.
     * @param numberOfBuckets Number of buckets.
     */
    public final void sort(
            final int[] array,
            final int numberOfBuckets) {
        var i = 0;
        for (var bucket : createBuckets(array, numberOfBuckets)) {
            Collections.sort(bucket);
            for (var item : bucket) {
                array[i++] = item;
            }
        }
    }

    /**
     * @param array           Array.
     * @param numberOfBuckets Number of buckets.
     * @return List<List < Integer>>
     */
    private List<List<Integer>> createBuckets(
            final int[] array,
            final int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (var i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (var item : array) {
            buckets.get(item / numberOfBuckets).add(item);
        }

        return buckets;
    }
}
