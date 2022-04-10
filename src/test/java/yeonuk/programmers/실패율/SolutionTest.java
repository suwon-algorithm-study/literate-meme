package yeonuk.programmers.실패율;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        int n = 5;
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        int[] actual = new int[]{3, 4, 2, 1, 5};

        Solution solution = new Solution();
        int[] expected = solution.solution(n, stages);

        assertArrayEquals(expected, actual);
    }

    @Test
    void solution2() {
        int n = 4;
        int[] stages = new int[]{4,4,4,4,4};
        int[] actual = new int[]{4,1,2,3};

        Solution solution = new Solution();
        int[] expected = solution.solution(n, stages);

        assertArrayEquals(expected, actual);
    }
}