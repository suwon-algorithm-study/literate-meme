package yeonuk.baekjoon.치킨쿠폰_1673;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void solve1() {
        Solution solution = new Solution();

        assertEquals(solution.solve(4, 3), 5);
    }

    @Test
    void solve2() {
        Solution solution = new Solution();

        assertEquals(solution.solve(10, 3), 14);
    }

    @Test
    void solve3() {
        Solution solution = new Solution();

        assertEquals(solution.solve(100, 5), 124);
    }

    @Test
    void solve4() {
        Solution solution = new Solution();

        assertEquals(solution.solve(7, 2), 13);
    }
}