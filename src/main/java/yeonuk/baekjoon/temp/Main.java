package yeonuk.baekjoon.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Input input = new Input();
        input.init();

        main.solve(input);
    }


    public void solve(Input input) {

    }

    static class Input {

        private final BufferedReader br;

        private List<String> values;

        public Input() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public void init() {
            try {
                this.values = getInput();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }

        private List<String> getInput() throws IOException {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            List<String> inputs = new ArrayList<>();
            stk = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                inputs.add(stk.nextToken());
            }

            return inputs;
        }

        public List<String> getValues() {
            return values;
        }
    }
}
