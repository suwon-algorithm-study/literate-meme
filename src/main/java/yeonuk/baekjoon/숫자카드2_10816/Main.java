package yeonuk.baekjoon.숫자카드2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Input input = new Input();
        input.init();

        Map<String, Integer> results = main.solve(input);

        String result = input.getMList()
                .stream()
                .map(results::get)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }


    public Map<String, Integer> solve(Input input) {
        Map<String, Integer> results = new HashMap<>();
        for (String mValue : input.getMList()) {
            results.put(mValue, 0);
        }

        for (String nValue : input.getNList()) {
            if (results.containsKey(nValue)) {
                int mValue = results.get(nValue);
                mValue++;
                results.put(nValue, mValue);
            }
        }

        return results;
    }

    static class Input {

        private final BufferedReader br;

        private List<String> nList;
        private List<String> mList;

        public Input() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public void init() {
            try {
                this.nList = getInput();
                this.mList = getInput();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }

        private List<String> getInput() throws IOException {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(stk.nextToken());

            List<String> inputs = new ArrayList<>();
            stk = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < size; i++) {
                inputs.add(stk.nextToken());
            }

            return inputs;
        }

        public List<String> getNList() {
            return Collections.unmodifiableList(nList);
        }

        public List<String> getMList() {
            return Collections.unmodifiableList(mList);
        }
    }

}
