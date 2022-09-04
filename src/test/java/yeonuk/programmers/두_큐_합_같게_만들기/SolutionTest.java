package yeonuk.programmers.두_큐_합_같게_만들기;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        Solution solution = new Solution();
        int result = solution.solution(queue1, queue2);

        assertEquals(result, 2);
    }

    @Test
    void test2() {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};

        Solution solution = new Solution();
        int result = solution.solution(queue1, queue2);

        assertEquals(result, 7);
    }

    @Test
    void test3() {
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};

        Solution solution = new Solution();
        int result = solution.solution(queue1, queue2);

        assertEquals(result, -1);
    }
}