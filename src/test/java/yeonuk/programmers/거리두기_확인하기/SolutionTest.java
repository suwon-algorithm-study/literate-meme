package yeonuk.programmers.거리두기_확인하기;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void solution() {

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POXPX", "OXPXP", "PXXXO", "OXXXO", "OOOPO"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        Solution solution = new Solution();
        int[] actual = solution.solution(places);

        int[] expected = {1, 0, 1, 1, 1};

        assertArrayEquals(actual, expected);
    }
}