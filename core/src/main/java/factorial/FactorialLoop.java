package factorial;

/**
 * Class FactorialLoop.
 * Implements factorial calculation over loop.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.04.22
 */
public class FactorialLoop {
    /**
     * Method calculates factorial.
     *
     * @param n Number.
     * @return Factorial.
     */
    public final int calc(final int n) {
        int result = 1;
        for (int i = n; i > 1; i--) {
            result = result * i;
        }
        return result;
    }
}
