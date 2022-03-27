package yeonuk.programmers.숫자_문자열과_영단어;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        String s = "one4seveneight";

        Solution solution = new Solution();

        String actual = solution.solve(s);

        String expect = "1478";

        assertEquals(expect, actual);
    }

    @Test
    void test2() {
        String s = "23four5six7";

        Solution solution = new Solution();

        String actual = solution.solve(s);

        String expect = "234567";

        assertEquals(expect, actual);
    }

    @Test
    void test3() {
        String s = "2three45sixseven";

        Solution solution = new Solution();

        String actual = solution.solve(s);

        String expect = "234567";

        assertEquals(expect, actual);
    }

    @Test
    void test4() {
        String s = "123";

        Solution solution = new Solution();

        String actual = solution.solve(s);

        String expect = "123";

        assertEquals(expect, actual);
    }
}