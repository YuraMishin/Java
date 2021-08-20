package strings.countvowels;

/**
 * Class Solution.
 * Implements the method that counts vowels in a string.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.06.2021
 */
public class Solution {
    /**
     * Method counts vowels in a string.
     *
     * @param str String.
     * @return int.
     */
    public final int countVowels(final String str) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        String vowels = "aeiouy";
        for (var ch : str.toLowerCase().toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}
