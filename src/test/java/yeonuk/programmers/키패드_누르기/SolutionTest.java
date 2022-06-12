package yeonuk.programmers.키패드_누르기;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {

        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        Solution solution = new Solution();
        String result = solution.solution(numbers, hand);

        assertEquals("LRLLLRLLRRL", result);
    }

    @Test
    void solution2() {

        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        Solution solution = new Solution();
        String result = solution.solution(numbers, hand);

        assertEquals("LRLLRRLLLRR", result);
    }

    @Test
    void solution3() {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";

        Solution solution = new Solution();
        String result = solution.solution(numbers, hand);

        assertEquals("LLRLLRLLRL", result);
    }
}