package yeonuk.programmers.로또의_최고_순위와_최저_순위;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void solve1() {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums ={31, 10, 45, 1, 6, 19};
        int[] result = {3, 5};

        Solution solution = new Solution();
        int[] answer = solution.solve(lottos, winNums);

        assertArrayEquals(result, answer);
    }

    @Test
    void solve2() {
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] winNums ={38, 19, 20, 40, 15, 25};
        int[] result = {1, 6};

        Solution solution = new Solution();
        int[] answer = solution.solve(lottos, winNums);

        assertArrayEquals(result, answer);
    }

    @Test
    void solve3() {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] winNums ={20, 9, 3, 45, 4, 35};
        int[] result = {1, 1};

        Solution solution = new Solution();
        int[] answer = solution.solve(lottos, winNums);

        assertArrayEquals(result, answer);
    }
}