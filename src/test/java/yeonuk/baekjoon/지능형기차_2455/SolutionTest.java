package yeonuk.baekjoon.지능형기차_2455;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        Parameter parameter = new Parameter(0, 32, 3, 13, 28, 25, 39, 0);

        Solution solution = new Solution();

        assertEquals(solution.solve(parameter), 42);
    }
}