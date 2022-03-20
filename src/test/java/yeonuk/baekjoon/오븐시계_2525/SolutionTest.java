package yeonuk.baekjoon.오븐시계_2525;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve1() {
        Parameter parameter = new Parameter(14, 30, 20);
        Answer actual = new Answer(14, 50);

        Solution solution = new Solution();
        Answer expect = solution.solve(parameter);

        assertEquals(expect.getHour(), actual.getHour());
        assertEquals(expect.getMinute(), actual.getMinute());
    }

    @Test
    void solve2() {
        Parameter parameter = new Parameter(17, 40, 80);
        Answer actual = new Answer(19, 0);

        Solution solution = new Solution();
        Answer expect = solution.solve(parameter);

        assertEquals(expect.getHour(), actual.getHour());
        assertEquals(expect.getMinute(), actual.getMinute());
    }

    @Test
    void solve3() {
        Parameter parameter = new Parameter(23, 48, 25);
        Answer actual = new Answer(0, 13);

        Solution solution = new Solution();
        Answer expect = solution.solve(parameter);

        assertEquals(expect.getHour(), actual.getHour());
        assertEquals(expect.getMinute(), actual.getMinute());
    }
}