package yeonuk.baekjoon.회의실_배정_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 회의안하겠습니다
 */
public class Main {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int solve() throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());

        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            Time time = new Time(start, end);
            times.add(time);
        }
        Collections.sort(times);

        int current = times.get(0).getEnd();
        int count = 1;
        for (int i = 1; i < n; i++) {
            Time time = times.get(i);
            int start = time.getStart();
            int end = time.getEnd();

            if (current <= start) {
                current = end;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int result = main.solve();

        System.out.println(result);
    }

    public static class Time implements Comparable<Time> {
        private final int start;
        private final int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Time time) {
            if (this.end < time.end) {
                return -1;
            } else if (this.end > time.end) {
                return 1;
            }
            return 0;
        }
    }
}

//4-1 7-5 11-8 14-12
//5-3
//6-0
//7-5
//8-3
//9-5
//10-6
//11-8
//12-8
//13-2
//14-12