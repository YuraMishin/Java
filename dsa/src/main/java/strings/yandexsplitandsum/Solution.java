package strings.yandexsplitandsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * Class Solution.
 * Implements Solution.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 05.07.2022
 */
public class Solution {
    /**
     * @param str String
     * @return String
     * @throws IOException IOException
     */
    public String perform(final String str) throws IOException {
        StringBuilder outputBuffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new StringReader(str))) {
            int numLines = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numLines; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int value1 = Integer.parseInt(tokenizer.nextToken());
                int value2 = Integer.parseInt(tokenizer.nextToken());
                int result = value1 + value2;
                outputBuffer.append(result).append("\n");
            }
        }
        return outputBuffer.toString().trim();
    }
}
