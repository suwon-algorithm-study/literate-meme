package yeonuk.programmers.신규_아이디_추천;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution1() {
        String newId = "...!@BaT#*..y.abcdefghijklm";
        String result = "bat.y.abcdefghi";

        Solution solution = new Solution();
        String expected = solution.solution(newId);

        assertEquals(expected, result);
    }

    @Test
    void solution2() {
        String newId = 	"z-+.^.";
        String result = "z--";

        Solution solution = new Solution();
        String expected = solution.solution(newId);

        assertEquals(expected, result);
    }

    @Test
    void solution3() {
        String newId = "=.=";
        String result = "aaa";

        Solution solution = new Solution();
        String expected = solution.solution(newId);

        assertEquals(expected, result);
    }

    @Test
    void solution4() {
        String newId = "123_.def";
        String result = "123_.def";

        Solution solution = new Solution();
        String expected = solution.solution(newId);

        assertEquals(expected, result);
    }

    @Test
    void solution5() {
        String newId = "abcdefghijklmn.p";
        String result = "abcdefghijklmn";

        Solution solution = new Solution();
        String expected = solution.solution(newId);

        assertEquals(expected, result);
    }
}