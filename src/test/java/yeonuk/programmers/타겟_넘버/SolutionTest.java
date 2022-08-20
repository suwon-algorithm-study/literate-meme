package yeonuk.programmers.타겟_넘버;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        int[] numbers = {1, 1, 1, 1, 1};

        Solution solution = new Solution();
        int result = solution.solution(numbers, 3);

        assertEquals(result, 5);
    }
}