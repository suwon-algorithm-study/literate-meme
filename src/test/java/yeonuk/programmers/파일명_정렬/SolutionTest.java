package yeonuk.programmers.파일명_정렬;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        String[] input = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG", "z1"};
        String[] expected = {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png", "z1"};

        Solution solution = new Solution();
        String[] actual = solution.solution(input);

        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        String[] input = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] expected = {"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"};

        Solution solution = new Solution();
        String[] actual = solution.solution(input);

        assertArrayEquals(expected, actual);
    }
}