package strings.isrotated;

/**
 * Class Solution.
 * Implements the solution
 * to check whether the word is a rotated version of another one.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.06.2021
 */
public class Solution {
    /**
     * Method checks the statement.
     *
     * @param str1 str1.
     * @param str2 str2.
     * @return Boolean.
     */
    public final boolean areRotations(
            final String str1, final String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        return (str1.length() == str2.length()
                && (str1 + str1).contains(str2));
    }
}
