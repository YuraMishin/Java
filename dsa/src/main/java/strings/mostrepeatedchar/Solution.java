package strings.mostrepeatedchar;

/**
 * Class Solution.
 * Implements the solution to find the most repeated char.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.06.2021
 */
public class Solution {
    /**
     * Method returns the most repeated char.
     *
     * @param str String.
     * @return String.
     */
    public final String getMaxOccuringChar(final String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final int asciisize = 256;
        int[] frequencies = new int[asciisize];
        for (var ch : str.toCharArray()) {
            frequencies[ch]++;
        }
        int max = 0;
        char result = ' ';
        for (var i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }
        }
        return String.valueOf(result);
    }
}
