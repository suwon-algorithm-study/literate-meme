package yeonuk.programmers.뉴스_클러스터링;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void solution() {
        //given
        String str1 = "FRANCE";
        String str2 = "french";

        int expected = 16384;

        //when
        Solution solution = new Solution();
        int actual = solution.solution(str1, str2);

        assertEquals(expected, actual);
    }

    @Test
    void solution2() {
        //given
        String str1 = "handshake";
        String str2 = "shake hands";

        int expected = 65536;

        //when
        Solution solution = new Solution();
        int actual = solution.solution(str1, str2);

        assertEquals(expected, actual);
    }

    @Test
    void solution3() {
        //given
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        int expected = 43690;

        //when
        Solution solution = new Solution();
        int actual = solution.solution(str1, str2);

        assertEquals(expected, actual);
    }

    @Test
    void solution4() {
        //given
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";

        int expected = 65536;

        //when
        Solution solution = new Solution();
        int actual = solution.solution(str1, str2);

        assertEquals(expected, actual);
    }

    @Test
    void solution5() {
        //given
        String str1 = "BAAAA";
        String str2 = "AAA";

        int expected = 32768;

        //when
        Solution solution = new Solution();
        int actual = solution.solution(str1, str2);

        assertEquals(expected, actual);
    }
}