package factorial;

/**
 * Class FactorialRecur.
 * Implements factorial calculation over recursion.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.04.22
 */
public class FactorialRecur {
    /**
     * Method calculates factorial.
     *
     * @param n Number.
     * @return Factorial.
     */
    public final int calc(final int n) {
        return (n <= 1) ? 1 : n * calc(n - 1);
    }
}
