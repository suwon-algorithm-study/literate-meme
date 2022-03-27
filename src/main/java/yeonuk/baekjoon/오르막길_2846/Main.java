package yeonuk.baekjoon.오르막길_2846;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int solve() throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine(), " ");
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(stk.nextToken());
        }

        if (n == 1) {
            return 0;
        }

        int max = 0;
        int current = 0;
        for (int i = 1; i < n; i++) {
            if (height[i - 1] < height[i]) {
                current += (height[i] - height[i - 1]);
                if (current > max) {
                    max = current;
                }
            } else {
                current = 0;
            }
        }

        return max;
    }

//    public static void main(String[] args) throws IOException {
//        Main main = new Main();
//        int result = main.solve();
//
//        System.out.println(result);
//    }
}
