package yeonuk.baekjoon.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try {
            Input input = new Input();
            input.init();

            Solution solution = new Solution(input);
            solution.solve();
        } catch (IOException e) {
            System.out.println("입력 오류");
        }
    }
}

class Solution {

    private final Input input;

    public Solution(Input input) {
        this.input = input;
    }

    public void solve() {

    }
}

class Input {

    private int n;
    private int m;

    private int[][] values;

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        values = new int[n][m];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            String token = stk.nextToken();
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(String.valueOf(token.charAt(j)));
                values[i][j] = value;
            }
        }

        br.close();
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int[][] getValues() {
        return values;
    }
}
