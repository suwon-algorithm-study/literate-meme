package yeonuk.programmers.수식최대화;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {

        Solution solution = new Solution();
        long actual = solution.solution("50*6-3*2");

        System.out.println(actual);
    }
}