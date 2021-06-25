package sorting.quick;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class QuickSortTest.
 * Tests QuickSort class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 25.06.2021
 */
public class QuickSortTest {
    /**
     * Tests sort() method.
     */
    @Test
    public void whenInvokesThenSorts() {
        int[] array = {3, 8, 2, 5, 0, 1, 4, 10};
        int[] result = {0, 1, 2, 3, 4, 5, 8, 10};
        new QuickSort().sort(array);

        assertThat(result, is(array));
    }

    /**
     * Tests sort() method.
     */
    @Test
    public void whenInvokesThenNoSorts() {
        int[] array = {};
        int[] result = {};
        new QuickSort().sort(array);

        assertThat(result, is(array));
    }
}