package isprime;

import java.util.function.IntPredicate;

/**
 * Class Solution.
 * Implements entity Solution to check if the number is prime.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.07.2022
 */
public final class SolutionV3 implements IntPredicate {
    /**
     * @param n Value
     * @return boolean
     */
    @Override
    public boolean test(final int n) {
        if (n == 1) {
            return false;
        }
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i = i + 1;
        }
        return true;
    }
}
