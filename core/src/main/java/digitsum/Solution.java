package digitsum;

/**
 * Class Solution.
 * Implements solution.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 09.11.2021
 */
public class Solution {
    /**
     * @param number Number
     * @return Int
     */
    public int sumDigits(int number) {
        if (number < 10) {
            return -1;
        }
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }
}
