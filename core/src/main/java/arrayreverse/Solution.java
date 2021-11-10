package arrayreverse;

/**
 * Class Solution.
 * Implements solution to reverse an array.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.11.2021
 */
public class Solution {
    public void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }
}
