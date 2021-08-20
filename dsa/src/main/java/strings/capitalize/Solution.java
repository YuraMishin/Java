package strings.capitalize;

/**
 * Class Solution.
 * Implements the solution to capitalize words in a sentence.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.06.2021
 */
public class Solution {
    /**
     * Method performs capitalization.
     *
     * @param sentence Sentence.
     * @return String.
     */
    public final String capitalize(final String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }

        String[] words = sentence
                .trim()
                .replaceAll(" +", " ")
                .split(" ");

        for (var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }
}
