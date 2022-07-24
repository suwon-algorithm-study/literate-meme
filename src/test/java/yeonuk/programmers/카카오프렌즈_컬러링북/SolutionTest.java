package yeonuk.programmers.카카오프렌즈_컬러링북;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void solution() {

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        Solution solution = new Solution();
        int[] actual = solution.solution(6, 4, picture);

        int[] expected = {4, 5};
        assertArrayEquals(actual, expected);
    }
}

/**
 0 0 1 1 3 3
 1 2 0 0 0 0
 1 2 0 0 0 0
 1 1 1 0 0 0
 **/