package yeonuk.programmers.전화번호목록;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        String[] phoneBook = {"119", "97674223", "1195524421"};

        Solution solution = new Solution();
        boolean actual = solution.solution(phoneBook);

        assertFalse(actual);
    }

    @Test
    void test2() {
        String[] phoneBook = {"123","456","789"};

        Solution solution = new Solution();
        boolean actual = solution.solution(phoneBook);

        assertTrue(actual);
    }

    @Test
    void test3() {
        String[] phoneBook = {"12","123","1235","567","88"};

        Solution solution = new Solution();
        boolean actual = solution.solution(phoneBook);

        assertFalse(actual);
    }
}