package leapyear;

/**
 * Class Solution.
 * Implements task solution.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.10.2021
 */
public class Solution {
    /**
     * Method defines if the given year is a leap year.
     *
     * @param year Year
     * @return Boolean
     */
    public boolean isLeapYear(final int year) {
        return (year % 4 == 0 && year % 100 > 0) || (year % 400 == 0);
    }
}
