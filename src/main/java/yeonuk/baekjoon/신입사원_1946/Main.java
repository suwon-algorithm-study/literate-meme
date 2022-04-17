package yeonuk.baekjoon.신입사원_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        main.solve();
    }


    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(stk.nextToken());

        for (int i = 0; i< t; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stk.nextToken());

            List<Applicant> applicants = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                stk = new StringTokenizer(br.readLine(), " ");
                int firstScore = Integer.parseInt(stk.nextToken());
                int secondScore = Integer.parseInt(stk.nextToken());

                Applicant applicant = new Applicant(firstScore, secondScore);
                applicants.add(applicant);
            }

            int result = n;
            for (Applicant applicant : applicants) {
                boolean ok = applicants.stream()
                        .anyMatch(a -> (a.firstScore < applicant.firstScore && a.secondScore < applicant.secondScore));

                if (ok) {
                    result--;
                }
            }
            System.out.println(result);
        }
    }

    static class Applicant {

        private final int firstScore;
        private final int secondScore;

        Applicant(int firstScore, int secondScore) {
            this.firstScore = firstScore;
            this.secondScore = secondScore;
        }

        @Override
        public String toString() {
            return "Applicant{" +
                    "firstScore=" + firstScore +
                    ", secondScore=" + secondScore +
                    '}';
        }
    }
}