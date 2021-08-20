package strings.removeduplicates;

import java.util.HashSet;
import java.util.Set;

/**
 * Class Solution.
 * Implements remove duplicates.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.06.2021
 */
public class Solution {
    /**
     * Method removes duplicates.
     *
     * @param str String.
     * @return String.
     */
    public final String removeDuplicates(final String str) {
        if (str == null) {
            return "";
        }
        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }
}
