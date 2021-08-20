package strings.stringreverse;

import java.util.Stack;

/**
 * Class Solution.
 * Implements solution to reverse the string.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.06.2021
 */
public class Solution {
    /**
     * Method reverses the string using stack.
     *
     * @param string String.
     * @return String.
     */
    public final String reverseByStack(final String string) {
        char[] chars = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            stack.push(aChar);
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    /**
     * Method reverses the string using StringBuilder.
     *
     * @param str String.
     * @return String.
     */
    public final String reverseByStringBuilder(final String str) {
        if (str == null) {
            return "";
        }
        StringBuilder reversed = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
