package yeonuk.programmers.주차요금계산;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void solution() {
        //given
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] expected = {14600, 34400, 5000};

        //when
        Solution solution = new Solution();
        int[] actual = solution.solution(fees, records);

        assertArrayEquals(expected, actual);
    }

    @Test
    void solution2() {
        //given
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        int[] expected = {0, 591};

        //when
        Solution solution = new Solution();
        int[] actual = solution.solution(fees, records);

        assertArrayEquals(expected, actual);
    }

    @Test
    void solution3() {
        //given
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};

        int[] expected = {14841};

        //when
        Solution solution = new Solution();
        int[] actual = solution.solution(fees, records);

        assertArrayEquals(expected, actual);
    }
}