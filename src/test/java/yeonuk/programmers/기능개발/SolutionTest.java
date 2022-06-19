package yeonuk.programmers.기능개발;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        //given
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] expected = {2, 1};

        //when
        Solution solution = new Solution();
        int[] actual = solution.solution(progresses, speeds);

        assertArrayEquals(expected, actual);
    }

    @Test
    void solution2() {
        //given
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] expected = {1, 3, 2};

        //when
        Solution solution = new Solution();
        int[] actual = solution.solution(progresses, speeds);

        assertArrayEquals(expected, actual);
    }

}