package yeonuk.baekjoon.도서관_1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Input input = new Input();
        input.init();

        main.solve(input);
    }


    public void solve(Input input) {
        input.sort();

        int result = 0;
        if (input.hasPositiveMaxValue()) {
            result += input.getMaxPositiveValue();

            List<Integer> positiveValues = input.getPositiveValues();
            for (int i = input.getM(); i < positiveValues.size(); i+= input.getM()) {
                result += positiveValues.get(i) * 2;
            }

            List<Integer> negativeValues = input.getNegativeValues();
            for (int i = 0; i < negativeValues.size(); i+= input.getM()) {
                result += abs(negativeValues.get(i)) * 2;
            }
        } else {
            result += input.getMaxNegativeValue();

            List<Integer> positiveValues = input.getPositiveValues();
            for (int i = 0; i < positiveValues.size(); i+= input.getM()) {
                result += positiveValues.get(i) * 2;
            }

            List<Integer> negativeValues = input.getNegativeValues();
            for (int i = input.getM(); i < negativeValues.size(); i+= input.getM()) {
                result += abs(negativeValues.get(i)) * 2;
            }
        }

        System.out.println(result);
    }

    private boolean isPositive(int number) {
        return abs(number) == number;
    }

    static class Input {

        private final BufferedReader br;

        private int n;

        private int m;

        private final List<Integer> positiveValues;

        private final List<Integer> negativeValues;

        public Input() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.positiveValues = new ArrayList<>();
            this.negativeValues = new ArrayList<>();
        }

        public void init() {
            try {
                initInput();
                initValues(n);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }

        private void initInput() throws IOException {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            this.n = Integer.parseInt(stk.nextToken());
            this.m = Integer.parseInt(stk.nextToken());
        }

        private void initValues(int n) throws IOException {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(stk.nextToken());
                if (value >= 0) {
                    this.positiveValues.add(value);
                } else {
                    this.negativeValues.add(value);
                }
            }
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }

        public void sort() {
            Collections.sort(positiveValues);
            Collections.reverse(positiveValues);
            Collections.sort(negativeValues);
        }

        public boolean hasPositiveMaxValue() {
            if (positiveValues.isEmpty()) {
                return false;
            } else if (negativeValues.isEmpty()) {
                return true;
            }
            return abs(negativeValues.get(0)) < abs(positiveValues.get(0));
        }

        public List<Integer> getPositiveValues() {
            return positiveValues;
        }

        public List<Integer> getNegativeValues() {
            return negativeValues;
        }

        public int getMaxPositiveValue() {
            return positiveValues.get(0);
        }

        public int getMaxNegativeValue() {
            return abs(negativeValues.get(0));
        }
    }
}

//-18 -9 -4 50 22 -26 40 -45
// -45 -26 -18 -9 -4 // 22 40 50
// 50 90 18

// -37 2 -6 -39 -29 11 -28
// -39 -37 // -29 -28 -6 2 11
// 39 22 56

// 39 58 12 22 = 131