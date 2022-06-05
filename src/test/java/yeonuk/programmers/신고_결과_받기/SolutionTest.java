package yeonuk.programmers.신고_결과_받기;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void solution() {
        //given
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] reports = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] expected = {2, 1, 1, 0};

        //when
        Solution solution = new Solution();
        int[] actual = solution.solution(idList, reports, k);

        assertArrayEquals(expected, actual);
    }

    @Test
    void solution2() {
        //given
        String[] idList = {"con", "ryan"};
        String[] reports = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        int[] expected = {0, 0};

        //when
        Solution solution = new Solution();
        int[] actual = solution.solution(idList, reports, k);

        assertArrayEquals(expected, actual);
    }
}