package yeonuk.programmers.성격_유형_검사하기;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        //given
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choice = {5, 3, 2, 7, 5};
        String expected = "TCMA";

        //when
        Solution solution = new Solution();
        String actual = solution.solution(survey, choice);

        //then
        assertEquals(expected, actual);
    }
}