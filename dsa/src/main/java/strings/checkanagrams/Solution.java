package strings.checkanagrams;

import java.util.Arrays;

/**
 * Class Solution.
 * Implements the solution to check anagrams.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.06.2021
 */
public class Solution {
    /**
     * Method checks the anagram.
     *
     * @param first  First.
     * @param second Second.
     * @return Boolean.
     */
    // O(n log n)
    public final boolean areAnagramsOne(
            final String first,
            final String second
    ) {
        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);
        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }

    /**
     * Method checks the anagram.
     *
     * @param first  First.
     * @param second Second.
     * @return Boolean.
     */
    // O(n)
    public final boolean areAnagramTwo(
            final String first,
            final String second
    ) {
        final int englishAlphabet = 26;
        int[] frequencies = new int[englishAlphabet];
        String firstStr = first.toLowerCase();
        for (var i = 0; i < firstStr.length(); i++) {
            frequencies[firstStr.charAt(i) - 'a']++;
        }
        String secondStr = second.toLowerCase();
        for (var i = 0; i < secondStr.length(); i++) {
            var index = secondStr.charAt(i) - 'a';
            if (frequencies[index] == 0) {
                return false;
            }
            frequencies[index]--;
        }
        return true;
    }
}
