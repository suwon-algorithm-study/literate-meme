package yeonuk.baekjoon.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    }

}

class Input {

    private int n;
    private int m;
    private List<String> values;

    public Input() {
        this.values = new ArrayList<>();
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            values.add(stk.nextToken());
        }

        br.close();
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public List<String> getValues() {
        return values;
    }
}
