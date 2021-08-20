package strings.palindrom;

/**
 * Class Solution.
 * Implements the solution to check palindrome.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.06.2021
 */
public class Solution {
    /**
     * Method checks palindrome.
     *
     * @param word Word.
     * @return Boolean.
     */
    public final boolean isPalindrome(final String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
