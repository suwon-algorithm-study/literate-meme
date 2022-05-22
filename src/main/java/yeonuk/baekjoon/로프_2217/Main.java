package yeonuk.baekjoon.로프_2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Input input = new Input();
            input.init();

            Main main = new Main();
            main.solve(input);
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }


    public void solve(Input input) {
        List<Integer> ropes = input.getValues();
        Collections.sort(ropes);

        List<Integer> results = new ArrayList<>();
        int index = input.getN();
        for (int i = 0; i < ropes.size(); i++) {
            Integer rope = ropes.get(i);
            results.add(rope * index);
            index--;
        }

        System.out.println(Collections.max(results));
    }

    static class Input {

        private int n;
        private List<Integer> values;

        public Input() {
            this.values = new ArrayList<>();
        }

        public void init() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(stk.nextToken());

            for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(br.readLine(), " ");
                values.add(Integer.valueOf(stk.nextToken()));
            }

            br.close();
        }

        public int getN() {
            return n;
        }


        public List<Integer> getValues() {
            return values;
        }
    }
}


/**
 * 5
 * <p>
 * 10
 * 15
 * 20
 * 30
 * 40
 * <p>
 * 5 -> 50
 * 4 -> 60
 * 3 -> 60
 * 2 -> 60
 * 1 -> 40
 */

/**
 * 5 -> 50
 * 4 -> 60
 * 3 -> 60
 * 2 -> 60
 * 1 -> 40
 */
/*

5
20
10
15
30
40
 */