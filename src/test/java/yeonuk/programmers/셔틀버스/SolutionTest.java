package yeonuk.programmers.셔틀버스;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

        Solution solution = new Solution();
        String result = solution.solution(1, 1, 5, timetable);

        System.out.println(result);
    }

    @Test
    void name2() {
        String[] timetable = {"09:10", "09:09", "08:00"};

        Solution solution = new Solution();
        String result = solution.solution(2, 10, 2, timetable);

        System.out.println(result);
    }

    @Test
    void name3() {
        String[] timetable = {"09:00", "09:00", "09:00", "09:00"};

        Solution solution = new Solution();
        String result = solution.solution(2, 1, 2, timetable);

        System.out.println(result);
    }

    @Test
    void name4() {
        String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};

        Solution solution = new Solution();
        String result = solution.solution(1, 1, 5, timetable);

        System.out.println(result);
    }

    @Test
    void name5() {
        String[] timetable = {"23:59"};

        Solution solution = new Solution();
        String result = solution.solution(1, 1, 1, timetable);

        System.out.println(result);
    }

    @Test
    void name6() {
        String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        Solution solution = new Solution();
        String result = solution.solution(10, 60, 45, timetable);

        System.out.println(result);
    }
}