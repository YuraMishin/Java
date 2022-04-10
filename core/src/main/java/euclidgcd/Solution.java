package euclidgcd;

/**
 * Class Solution.
 * Implements euclid algorithm to get GCD — greatest common divisor.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.04.2022
 */
public class Solution {
    /**
     * Method calculates the solution by loop.
     *
     * @param pA A.
     * @param pB B.
     * @return int Result.
     */
    public final int loop(final int pA, final int pB) {
        int a = pA;
        int b = pB;
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    /**
     * Method calculates the solution by recursion.
     *
     * @param a A.
     * @param b B.
     * @return int Result.
     */
    public final int recur(final int a, final int b) {
        if (b == 0) {
            return a;
        }
        return recur(b, a % b);
    }
}
