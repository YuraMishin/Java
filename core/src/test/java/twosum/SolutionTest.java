package twosum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void testTwoSumPositive() {
        // given
        var nums = new int[]{2, 7, 11, 15};
        var target = 9;
        var resultExpected = new int[]{0, 1};

        // when
        var resultActual = new Solution().twoSum(nums, target);

        // then
        assertThat(resultActual).isEqualTo(resultExpected);
    }
}

