package jian.baekjoon.회문_17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int result = isPalindrome(br.readLine());
            System.out.println(result);
        }
    }

    public int isPalindrome(String input) {
        ListIterator<String> iterL = Arrays.asList(input.split("")).listIterator();

        String reverse = new StringBuffer(input).reverse().toString();
        ListIterator<String> iterR = Arrays.asList(reverse.split("")).listIterator();

        int index = 0;

        // xabba
        // iterL: x, a, b, b, a
        // iterR: a, b, b, a, x

        while (iterL.hasNext()) {
            String left = iterL.next();
            String right = iterR.next();

            if (!left.equals(right)) {
                index += 1;
                
                // TODO
            }
        }

        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return 2;
        }
    }
}
