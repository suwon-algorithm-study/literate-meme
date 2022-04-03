package yeonuk.baekjoon.설탕배달_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int result = main.solve();

        System.out.println(result);
    }

    public int solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int number = Integer.parseInt(stk.nextToken());
        int temp = 0;
        int result = 0;

        while (number >= 0) {
            if (number % 5 == 0) {
                result += number / 5;
                result += temp;
                return result;
            }
            temp++;
            number-=3;
        }

        return -1;
    }
}


/**
 * 1 : -1
 * 2 : -1
 * 3 : 1    3
 * 4 : -1
 * 5 : 1    5
 * 6 : -1
 * 7 : -1
 * 8 : -1
 * 9 : 3    3 / 3 / 3
 * 10 : 2   5 / 5
 * 11 : 3   5 / 3 / 3
 * 14 : 3   5 / 3 / 3 / 3
 *
 * 56 : 5 * 10 / 3 * 2
 */