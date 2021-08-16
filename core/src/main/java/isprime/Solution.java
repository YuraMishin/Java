package isprime;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Class Solution.
 * Implements entity Solution to check if the number is prime.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
public final class Solution implements IntPredicate {
    /**
     * @param value Value
     * @return boolean
     */
    @Override
    public boolean test(final int value) {
        var result = IntStream
            .range(1, (value / 2) + 1)
            .filter(i -> value % i == 0)
            .count();
        return result == 1;
    }
}
