package strings.reversewords;

import java.util.Arrays;
import java.util.Collections;

/**
 * Class Solution.
 * Implements the solution to reverse words.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.06.2021
 */
public class Solution {
    /**
     * Method reverses words.
     *
     * @param sentence Sentence.
     * @return String.
     */
    public final String reverseWords(final String sentence) {
        if (sentence == null) {
            return "";
        }
        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
